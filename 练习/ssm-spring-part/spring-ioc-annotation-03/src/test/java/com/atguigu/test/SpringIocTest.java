package com.atguigu.test;

import com.atguigu.ioc_01.CommonComponent;
import com.atguigu.ioc_01.XxxDao;
import com.atguigu.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {


    @Test
    public void testIoc_01(){
        //1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        //2. 获取组件
        CommonComponent commonComponent = applicationContext.getBean("commonComponent", CommonComponent.class);

        XxxDao xxxDao = applicationContext.getBean("xxxDao", XxxDao.class);

        System.out.println(commonComponent);
        System.out.println(xxxDao);
        //3. 关闭容器
        applicationContext.close();
    }

    @Test
    public void testIoc_03(){
        //1. 创建IOC容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        //2. 获取组件
        UserController userController = applicationContext.getBean("userController", UserController.class);

        userController.show();

        //3. 关闭容器
        applicationContext.close();
    }
}
