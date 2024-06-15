package com.atguigu.mapper;

import com.atguigu.pojo.Customer;

import java.util.List;

public interface CustomerMapper {

//    查询所有客户信息包括订单信息
    List<Customer> queryList();
}
