package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
登陆过滤器
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.把ServletRequest转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;

        //2.获取请求路径
        String uri = request.getRequestURI();

        //3.判断请求路径是否与登录相关
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet")|| uri.contains("/css/")|| uri.contains("/fonts/")|| uri.contains("/js/")|| uri.contains("/checkCodeServlet")){
           //相关直接放行
            chain.doFilter(req, resp);
        }else{
            //不相关，需要判断用户是否登录
            Object username = request.getSession().getAttribute("username");
            if(username!=null){
                //已经登录，放行
                chain.doFilter(req, resp);
            }else{
                //存储错误信息
                request.getSession().setAttribute("error","您尚未登录，请登录!!");
                //没有登录，跳转到登录界面
                request.getRequestDispatcher("/login.jsp").forward(request,resp);

            }
        }

        /*chain.doFilter(req, resp);*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
