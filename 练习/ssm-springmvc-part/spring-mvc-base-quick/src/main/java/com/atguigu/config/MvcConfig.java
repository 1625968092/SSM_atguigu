package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * 1. Controller配置ioc
 * 2. HandlerMapping handlerAdapter配置ioc
 *
 */


@Configuration
@ComponentScan("com.atguigu.controller")

public class MvcConfig {

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
            return  new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
            return new RequestMappingHandlerAdapter();
    }

}
