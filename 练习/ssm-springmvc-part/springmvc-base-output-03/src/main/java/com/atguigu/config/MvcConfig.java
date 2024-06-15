package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc组件的配置类
 */

@EnableWebMvc  //handlerMapping handlerAdapter json转换器
@Configuration
@ComponentScan(basePackages = "com.atguigu")
public class MvcConfig implements WebMvcConfigurer {
        //视图解析器，指定前后缀

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry可以快速添加前后缀
        registry.jsp("/WEB-INF/views/", ".jsp");
    }


    //开启静态资源查找
    //dispatcherServlet -> handlerMapping 找有没有对应的handler再去找静态资源 ->有没有静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
