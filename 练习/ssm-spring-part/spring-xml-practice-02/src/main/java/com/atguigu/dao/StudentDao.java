package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 数据库查询所有学生信息
     * @return
     */
    List<Student> queryAll();
}
