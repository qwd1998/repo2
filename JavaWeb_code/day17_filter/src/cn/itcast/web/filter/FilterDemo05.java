package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo05 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo05来了");

        //放行
        chain.doFilter(req, resp);

        System.out.println("demo05回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
