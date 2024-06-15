package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WarpperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("name","a");
        queryWrapper.between("age",30,20);
        queryWrapper.isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);

        System.out.println("users = " + users);
    }

    @Test
    public void tes2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);

        System.out.println("users = " + users);
    }

    @Test
    public void tes3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");
        //升序排列
        queryWrapper.orderByAsc("age");
        List<User> users = userMapper.selectList(queryWrapper);

        System.out.println("users = " + users);
    }

    @Test
    public void tes4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.isNull("email");
        //删除email为空的
        userMapper.delete(queryWrapper);

    }

    @Test
    public void tes5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("age",20).like("name","a")
                .or().isNull("email");
        //删除email为空的
        userMapper.delete(queryWrapper);

    }
}
