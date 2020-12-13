package web;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*//获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装对象
        User  loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
        //获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginuser =new User();
        //使用beanutils封装
        try {
            BeanUtils.populate(loginuser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        if (user==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
