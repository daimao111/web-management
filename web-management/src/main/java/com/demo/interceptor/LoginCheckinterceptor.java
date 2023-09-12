package com.demo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.Result;
import com.demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckinterceptor implements HandlerInterceptor {
    @Override   //目标资源方法运行前执行，返回true放行，false不放行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //接收请求路径url

        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url路径为：{}", url);

        //判断是否为登录操作(login)
        if (url.contains("login")) {       //url为登录请求，放行
            log.info("登录操作，放行");
            return true;
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
            return false;
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
            return false;

        }
        //令牌正确，放行
        log.info("令牌合法，放行");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行");
    }
}
