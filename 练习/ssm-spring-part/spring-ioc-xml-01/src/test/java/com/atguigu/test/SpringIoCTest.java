package com.atguigu.test;

import com.atguitu.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {


    /**
     * 创建IoC容器  并且读取配置文件
     */
    @Test
    public void creatIoC(){
        //创建容器  选择合适的容器实现即可
        /**
         * 接口
         * BeanFactory
         * ApplicationContext
         * 实现类
         *       可以直接通过构造函数实例化!
         * ClassPathXmlApplicationContext               读取类路径下的xml配置方式
         * classesFileSystemXmlApplicationContext       读取指定文件位置的xml配置方式
         * AnnotationConfigApplicationContext           读取配置类方式的ioc容器
         * WebApplicationcontext                        web项目专属的配置的ioc容器
         */

        //方式一： 直接创建容器并且指定配置文件即可,自动在resources文件夹里找
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-03.xml");

        //方式二： 先创建IoC容器对象，再配置文件，再更新
        //通常是源码的配置过程
        ClassPathXmlApplicationContext applicationContext1=new ClassPathXmlApplicationContext();
        //独立设置配置文件
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();

    }

    /**
     * 获取容器中的组件
     */
    @Test
    public void getBeanFromIoC(){
        //1. 创建IoC容器对象

        ClassPathXmlApplicationContext applicationContext1=new ClassPathXmlApplicationContext();
        //独立设置配置文件
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();


        //2. 读取IoC容器组件
        //方案一：直接根据BeanID获取,获取类型是Object需要强制转换，不推荐
        HappyComponent happyComponent =(HappyComponent) applicationContext1.getBean("HappyComponent");
        happyComponent.sayHello();

        //方案二： 根据BeanID，同时指定Bean的类型 Class
        HappyComponent happyComponent1 = applicationContext1.getBean("HappyComponent", HappyComponent.class);

        //方案三： 直接根据类型获取
        HappyComponent happyComponent2 = applicationContext1.getBean(HappyComponent.class);

        //获得对象都是同一个
        System.out.println(happyComponent==happyComponent1);
        System.out.println(happyComponent1==happyComponent2);
    }


}
