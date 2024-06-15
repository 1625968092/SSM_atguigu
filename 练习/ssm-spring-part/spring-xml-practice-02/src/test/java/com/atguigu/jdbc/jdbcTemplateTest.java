package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class jdbcTemplateTest {
    public void testForJava(){

        /**
         * jdbcTemplate只简化增删改查操作，不提供数据库连接池
         * druidDataSource  配合使用 负责连接的创建  和驱动的创建等
         */

//        创建一个连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/studb");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");



        // 1. 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //2.调用方法
        //jdbcTemplate.update();  DDL  DML  DCL ....  非查询语句
        //jdbcTemplate.query();   DQL   查询集合
        //jdbcTemplate.queryForObject();   查询单个对象

        //3.配合druid使用
        jdbcTemplate.setDataSource(druidDataSource);
    }

    @Test
    public void testForIoc(){

        //1.创建IOC容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取组件1
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
//        3.CRUD操作
        String sql="insert into students (id,name,gender,age,class)  values(?,?,?,?,?)";

        /**
         * 参数一，String就是sql语句，可以带占位符 ？ ，？只能替代值不能替代关键字和容器名
         * 参数二，object....param  传入占位符的值，顺序从左到右
         * 返回值，int类型  影响行数rows
         */
        int rows = jdbcTemplate.update(sql,9,"二狗子", "男", 18, "三年二班");

        System.out.println(rows);

        sql = "select id , name , age , gender , class as classes from students where id = ? ;";


        //根据id查询
        Student student = jdbcTemplate.queryForObject(sql,  (rs, rowNum) -> {
            //自己处理结果映射
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setGender(rs.getString("gender"));
            stu.setClasses(rs.getString("classes"));
            return stu;
        }, 2);

        System.out.println("student = " + student);



        //3.3查询所有学生数据
        sql="select id,name,age,gender,class as classes from students";

        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        System.out.println(studentList);


    }

    /**
     * 从IOC获取controller使用findAll方法
     */
    @Test
    public void testController(){
        //创建IOC容器
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-02.xml");
        //获取组件对象
        StudentController studentController = applicationContext.getBean("StudentController", StudentController.class);
        //使用组件方法
        studentController.findAll();
        //关闭容器
        applicationContext.close();
    }
}
