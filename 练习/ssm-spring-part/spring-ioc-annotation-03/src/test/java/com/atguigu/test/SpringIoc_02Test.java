package com.atguigu.test;

import com.atguigu.ioc_02.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoc_02Test {


    @Test
    public void testJavaBean(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        JavaBean javaBean2 = applicationContext.getBean("javaBean", JavaBean.class);

        System.out.println(javaBean==javaBean2);

        applicationContext.close();
    }
}
