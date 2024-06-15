package com.atguigu.controller;

import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;

public class StudentController {


    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        System.out.println("Controller层："+studentService.findAll());
    }
}
