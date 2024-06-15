package com.atguigu.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)  //默认单例模式
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //多例模式
@Component  // <Bean id="JavaBean" class="JavaBean" >
public class JavaBean {

    //周期方法命名随意 public void修饰 没有形参

    @PostConstruct
    public void init(){
        System.out.println("inti...........");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy..........");
    }
}
