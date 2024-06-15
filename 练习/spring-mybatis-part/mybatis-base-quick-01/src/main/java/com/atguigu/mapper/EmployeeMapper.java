package com.atguigu.mapper;

import com.atguigu.Employee;

public interface EmployeeMapper {
    //根据id查询员工信息
    Employee queryById(Integer id);

    int deleteById(Integer id);
}
