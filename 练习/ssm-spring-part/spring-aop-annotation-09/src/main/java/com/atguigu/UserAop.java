package com.atguigu;

import com.atguigu.dyn.ProxyFactory;
import com.atguigu.statics.StaticProxyCalculator;

public class UserAop {
    public static void main(String[] args) {
        //房东
        Calculator target=new CalculatorPureImpl();

        //中介 代理
        Calculator proxyCalculator=new StaticProxyCalculator(target);

        proxyCalculator.add(1,1);

        //jdk
        ProxyFactory proxyFactory = new ProxyFactory(target);
        //使用接口接值 = 代理对象 【兄弟】
        Calculator proxy = (Calculator) proxyFactory.getProxy();

        proxy.add(1,1);

    }
}
