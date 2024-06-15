package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.mapper.TeacherMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() throws IOException {
        //1. 读取外部配置文件（mybatis-config.xml）
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory(全局的)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3. 根据sqlSessionFactory去创建sqlSession（每次业务创建一个用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4. 获取接口的代理对象，调用代理对象的方法就会查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpSalary(888.0);
        employee.setEmpName("yadan");
        System.out.println(employee.getEmpId());
        int rows = mapper.insertEmp(employee);
        System.out.println(employee.getEmpId());
        System.out.println(rows);
        //5. 提交事务（非DQL） 和释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.jupiter.api.Test
    public void test02() throws IOException {
        //1. 读取外部配置文件（mybatis-config.xml）
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建sqlSessionFactory(全局的)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3. 根据sqlSessionFactory去创建sqlSession（每次业务创建一个用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4. 获取接口的代理对象，调用代理对象的方法就会查找mapper接口的方法
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.setTName("李大国");
        //自己维护主键
//        teacher.setTId(UUID.randomUUID().toString().replaceAll("-",""));

        System.out.println("TID--------------:"+teacher.getTId());
        int rows = teacherMapper.insertTeacher(teacher);
        System.out.println("TID--------------:"+teacher.getTId());
        //5. 提交事务（非DQL） 和释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
