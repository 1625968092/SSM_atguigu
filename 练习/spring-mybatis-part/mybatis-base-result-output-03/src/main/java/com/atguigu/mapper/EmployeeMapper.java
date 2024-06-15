package com.atguigu.mapper;

import org.apache.ibatis.annotations.Param;

import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //DML语句返回是个int数据，影响行数rows
    int deleteById(Integer id);

    //指定删除类型，大部分是查询语句
    //根据用户的id查询员工的姓名
    String queryNameById(Integer id);
    //根据员工的id查询工资salary
    Double querySalaryById(Integer id);
    //返回单个实体类型
    Employee queryById(Integer id);
    //返回值是Map类型
    Map<String,Object> selectEmpNameAndMaxSalary();
    //查询工资高于传入值的员工的姓名
    List<String> queryNamesBySalary(Double salary);
    //查询全部员工信息
    List<Employee> queryAll();
    //员工插入
    int insertEmp(Employee employee);
}
