package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")//只有执行index.jsp才执行
public class FilterDemo03 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo03来了");

        //放行
        chain.doFilter(req, resp);

        System.out.println("demo03回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
