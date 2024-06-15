package com.atguigu.test;


import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CrudTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("翠花");
        user.setAge(18);
        user.setEmail("111@163.com");
        int rows=userMapper.insert(user);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testDelete(){
        int i = userMapper.deleteById(1801101389467860994L);
        System.out.println("i = " + i);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(30);
        user.setId(1L);
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

        //所有人年龄改为22
        User user2=new User();
        user2.setAge(22);
        int rows = userMapper.update(user2, null);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);

        List<Long> ids=new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println("users = " + users);
    }
}
