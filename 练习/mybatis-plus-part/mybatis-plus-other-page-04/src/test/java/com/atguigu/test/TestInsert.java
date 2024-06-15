package com.atguigu.test;

import com.atguigu.mapper.UserMapper;

import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestInsert {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setName("二狗子");
        user.setAge(18);
        user.setEmail("123@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void deleted(){
        int i = userMapper.deleteById(5);
        System.out.println("i = " + i);
    }
}
