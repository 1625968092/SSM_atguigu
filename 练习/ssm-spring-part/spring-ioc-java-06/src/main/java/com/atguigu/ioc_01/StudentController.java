package com.atguigu.ioc_01;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentController {

    @Autowired
    private StudentService studentService;
}
