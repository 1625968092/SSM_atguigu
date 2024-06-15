package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    //根据员工的姓名和工资查询员工信息
    List<Employee> query(@Param("name") String name, @Param("salary")Double salray);

    List<Employee> queryTrim(@Param("name") String name, @Param("salary")Double salray);

    //根据两个条件查询，如果姓名不为null使用姓名查询，如果姓名为空但是薪水不为空就使用薪水查询，都为空，查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary")Double salray);

    //根据员工的id更新员工数据，要求只有在name和salary不为空时才更新
    int update(Employee employee);

    int updateTrim(Employee employee);

    //根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    //根据id批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    //批量添加
    int insert(@Param("list") List<Employee> employeeList);

    //批量修改
    int updateBatch(@Param("list")List<Employee> employeeList);


}
