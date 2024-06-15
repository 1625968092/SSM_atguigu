package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 将controller  handlerAdapter handlerMapping加入IOC容器
 */

@Configuration
@ComponentScan("com.atguigu")
@EnableWebMvc  //添加经理 handlerAdapter  添加秘书 handlerMapping  添加jackson处理器
public class MvcConfig {
//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//        return new RequestMappingHandlerAdapter();
//    }
}
