package test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void testToOne() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.queryList();

        //调用之前设置分页数据
        PageHelper.startPage(1,2);

        //TODO:不能将两条start装到一个分页插件中，需要重写一个start
        //查询后将数据封装在一个PageInfo的分页实体类中（一共有多少页，多少条等等）
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        //PageInfo获取
        List<Employee> list = pageInfo.getList();
        System.out.println("list = " + list);
        //总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        //总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        //当前第几页
        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        //当前页条数
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);
        //....



        System.out.println(employees);

    }


    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
