package com.atguigu.service;


import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void delete(int id) {
        int rows=userMapper.delete(id);
        System.out.println("rows = " + rows);
        int i=1/0;
    }
}
