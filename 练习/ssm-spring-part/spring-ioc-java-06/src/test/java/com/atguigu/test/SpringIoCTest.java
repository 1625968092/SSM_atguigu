package com.atguigu.test;

import com.atguigu.ioc_01.StudentController;
import com.atguigu.ioc_01.config.JavaConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void testIoC(){
        //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfiguration.class);
//            //创建方式二 ，先创建 再 配置
//            AnnotationConfigApplicationContext applicationContext1=new AnnotationConfigApplicationContext();
//            applicationContext1.register(JavaConfiguration.class);
//            //载入配置后刷新一下
//            applicationContext1.refresh();
        //2.拿到bean组件
        StudentController studentController = applicationContext.getBean(StudentController.class);
        //3.使用组件
        System.out.println(studentController);
        //4.关闭容器
        applicationContext.close();
        applicationContext.close();
    }
}
