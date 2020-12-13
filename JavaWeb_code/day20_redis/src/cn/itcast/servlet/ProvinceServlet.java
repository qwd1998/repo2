package cn.itcast.servlet;

import cn.itcast.domain.Province;
import cn.itcast.service.ProviceService;
import cn.itcast.service.impl.ProviceServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
      /*  //1.调用servic查询
        ProviceService service = new ProviceServiceimpl();
        List<Province> list = service.findAll();

        //2.序列化list为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/

        //1.调用servic查询
        ProviceService service = new ProviceServiceimpl();
        String json = service.findJedis();

        System.out.println(json);
        //3.响应结果
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
