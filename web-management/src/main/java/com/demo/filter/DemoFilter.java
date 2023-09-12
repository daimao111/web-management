package com.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {


    //初始化方法，只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("调用了init方法");
    }

    //拦截方法，调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        System.out.println("拦截了请求");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);


    }

    //销毁方法，只调用一次
    @Override
    public void destroy() {
        System.out.println("调用了destroy方法");
    }
}
