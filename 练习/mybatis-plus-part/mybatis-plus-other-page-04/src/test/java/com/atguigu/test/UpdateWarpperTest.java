package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UpdateWarpperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<User>();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        updateWrapper.like("name","a");
        updateWrapper.between("age",20,30);
        updateWrapper.isNotNull("email");
        //升序排列
        updateWrapper.orderByAsc("age");


        userMapper.update(null,updateWrapper);
    }
}
