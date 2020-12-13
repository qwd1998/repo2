package cn.web.servlet;

import cn.domain.User;
import cn.service.UserService;
import cn.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取图片的验证码
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        //获取输入的验证码
        String verifycode = request.getParameter("verifycode");

        //创建User对象
        User user = new User();
        //使用bean封装user
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        User denglu = service.denglu(user);
        //判断验证码是否正确
        if (checkCode != null && checkCode.equalsIgnoreCase(verifycode)) {
            if (denglu != null) {
                //登陆成功
                session.setAttribute("username",user.getUsername());
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            } else {
                request.setAttribute("error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
