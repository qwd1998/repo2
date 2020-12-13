package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//浏览器直接请求资源时，过滤器被执行
//@WebFilter(value ="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)//只有执行index.jsp才执行
//浏览器转发访问index.jsp，过滤器才被执行
//@WebFilter(value ="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)//只有执行index.jsp才执行

//浏览器转发访问index.jsp或者直接请求资源，过滤器才被执行
//@WebFilter(value ="/idnex.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})//只有执行index.jsp才执行
//@WebFilter(value ="/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})//只有执行index.jsp才执行，转发的会执行两次
public class FilterDemo04 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo04来了");

        //放行
        chain.doFilter(req, resp);

        System.out.println("demo04回来了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
