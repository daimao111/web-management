package com.demo.config;

import com.demo.interceptor.LoginCheckinterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckinterceptor loginCheckinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckinterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
