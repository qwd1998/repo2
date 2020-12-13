package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.File;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Filter 快速入门程序
 */
//@WebFilter("/*")//访问所有资源前，都会执行该过滤器
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*
        服务器启动后，会创建Fileter对象，然后调用init，只执行一次
        ，用于加载资源

         */
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我被拦截了");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        /*
        在服务器正常关闭后，Filter对象被销毁  ，如果是正常关闭，会执行一次destroy方法
         用于释放资源
         */
        System.out.println("destroy....");
    }
}
