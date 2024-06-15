package com.atguigu.interceptors;

import com.atguigu.service.UserService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/*
    登录拦截保护，检查token是否有效

    有效放行
    没有，或者无效返回 504
 */

@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    //true放行  false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从请求头中获取token
        String token = request.getHeader("token");
        boolean expiration = jwtHelper.isExpiration(token);
        //检查是否有效
        if (!expiration) {
            //有效放行
            return true;
        }

        //构造JSON串
        Result build = Result.build(null, ResultCodeEnum.NOTLOGIN);

        //JSON转字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String josn = objectMapper.writeValueAsString(build);

        //json转为字符串后写入Response返回给前端
        response.getWriter().write(josn);
        return false;
    }
}
