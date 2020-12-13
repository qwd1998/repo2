package cn.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //找到服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/"+filename);
        //使用字节流关联起来
        FileInputStream fis = new FileInputStream(realPath);

        //设置response响应头
        //设置响应头类型content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);//浏览器自动解析文件的mime类型
        //设置响应头打开方式content-disposition
        response.setHeader("content-disposition","attachment,filename="+filename);

        //读了之后，再写
        ServletOutputStream sos = response.getOutputStream();
        byte a[] = new byte[1024];
        int len=0;
        while((len=fis.read(a))!=-1){
            sos.write(a,0,len);
        }
        sos.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
