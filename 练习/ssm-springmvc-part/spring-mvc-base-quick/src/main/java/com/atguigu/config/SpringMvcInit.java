package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * 继承这个类可以被Web项目加载，会初始化IOC容器，会设置dispatcherServlet的地址
 */


public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    //配置springmvc内部自带servlet 的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
