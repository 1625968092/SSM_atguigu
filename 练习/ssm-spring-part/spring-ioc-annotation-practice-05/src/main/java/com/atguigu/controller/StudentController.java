package com.atguigu.controller;


import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    public void findAll(){
        for (Student student : studentService.findAll()) {
            System.out.println(student);
        }

    }

}
