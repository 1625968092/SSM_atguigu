package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {


    @Test
    public void test() throws IOException {
        //1. 读取外部配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3. 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4. 获取代理Mapper对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.queryById(1);
        System.out.println(employee);
        //5. 关闭资源或者提交事务，JDBC模式是自动提交的
        sqlSession.close();

    }
}
