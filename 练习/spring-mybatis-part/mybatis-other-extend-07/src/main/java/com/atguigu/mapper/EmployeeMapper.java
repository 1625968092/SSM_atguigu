package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //根据员工的姓名和工资查询员工信息
    List<Employee> queryList();

}
