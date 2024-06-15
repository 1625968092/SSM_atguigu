package com.atguitu.ioc_02;

public class UserService {
    
private UserDao userDao;

public UserService(int age,String name,UserDao userDao) {
    this.userDao = userDao;
}
}
