package com.demo.filter;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.http.HttpResponse;
import com.demo.pojo.Result;
import com.demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@Slf4j
//@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //接收请求路径url
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url路径为：{}", url);

        //判断是否为登录操作(login)
        if (url.contains("login")) {       //url为登录请求，放行
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //判断获取请求头中的令牌token
        String jwt = httpServletRequest.getHeader("token");

        //判断令牌是否存在，不存在则返回错误信息（未登录）
        if (!StringUtils.hasLength(jwt)) {
            log.info("令牌不存在，返回错误信息");
            Result error = Result.error("NOT_LOGIN");

//            手动转换为json格式，使用阿里巴巴---fastjson
            String jsonError = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(jsonError);
            return;
        }

        //检验令牌是否正确
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            //令牌失效或被篡改，返回错误信息
            log.info("令牌失效或被篡改，返回错误信息");
            Result error = Result.error("NOT_LOGIN");

//            手动转换为json格式，使用阿里巴巴---fastjson
            String jsonError = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(jsonError);
            return;

        }
        //令牌正确，放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
