package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(JavaConfiguration.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void test(){
        studentService.changeInfo();
    }
}
