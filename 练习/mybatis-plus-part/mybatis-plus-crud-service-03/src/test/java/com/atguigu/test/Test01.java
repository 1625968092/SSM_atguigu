package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
}
