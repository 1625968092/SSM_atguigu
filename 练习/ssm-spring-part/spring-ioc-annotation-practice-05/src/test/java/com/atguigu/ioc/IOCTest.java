package com.atguigu.ioc;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {



    @Test
    public void testAnnotationIOC(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-01.xml");

        StudentController studentController = applicationContext.getBean("studentController", StudentController.class);

        studentController.findAll();

        applicationContext.close();
    }
}
