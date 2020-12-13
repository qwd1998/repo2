package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.UserServicimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/html;charset=utf-8");

        Map<String, String[]> maps = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServicimpl();
        User chazhao = service.chazhao(user);

        Map<String,Object> map  =new HashMap<String, Object>();

        if(chazhao!=null){
            map.put("userExsit",true);
            map.put("msg","输入的用户名已存在");
        }else{
            map.put("userExsit",false);
            map.put("msg","输入的用户名可以注册");
        }

        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);

        response.getWriter().write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
