package com.atguigu.mapper;

import com.atguigu.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //根据id查询员工信息
    Employee queryById(Integer id);
    //根据id删除员工信息
    int deleteById(Integer id);
    //根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);
    //插入员工数据
    int insert(Employee employee);
    //根据员工姓名和工资查询信息
    List<Employee> queryByNameAndSalary(@Param("name")String name,@Param("salary") Double salary);
    //插入员工数据，但是存储在Map中（name=员工的名字，salary=员工的薪水）
    //Mapper接口中不允许重载  方法名重复了  xml中的id名就会重复
    int insertEmpMap(Map map);
}
