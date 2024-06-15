package com.atguigu.ioc_01.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 1. 包扫描配置
 * 2. 引用外部文件配置
 * 3. 声明第三方依赖Bean组件
 */

/**
 * 步骤一：添加Configuration注解代表这是配置类
 * 步骤二：实现上面的三个功能注解
 * 步骤三：
 */

@ComponentScan("com.atguigu.ioc_01")
@PropertySource(value="classPath:jdbc.properties")
@Configuration
public class JavaConfiguration {

    /**
     * 问题一：BeanName的问题
     *       默认方法名
     *       指定：name属性
     * 问题二：周期方法的问题
     *      原有注解方案 PostConstruct  + PreDestroy
     *      Bean属性指定：initMethod / destroyMethod 指定
     * 问题三：作用域问题
     *      使用@Scope
     * 问题四：如何引用其他的IOC组件
     *
     *
     */

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi")
    public DruidDataSource druidDataSource() {
        //实现具体的实例化过程
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/studb");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        return druidDataSource;
    }

    @Bean(name = "lvdandan")
    public DruidDataSource druidDataSource2() {
        //实现具体的实例化过程
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/studb");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要引用IOC中的其他组件
        //方案一，其他组件也是@Bean方法,可以从IOC获取组件
        jdbcTemplate.setDataSource(druidDataSource2());
        return null;
    }

    @Bean
    //方案二使用形参列表传值
    public JdbcTemplate jdbcTemplate1(DataSource lvdandan){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要引用IOC中的其他组件
        //方案二使用形参列表传值,可以是一个也可以是多个
        //如果有多个 形参名可以使用对应Bean的id标识
        jdbcTemplate.setDataSource(lvdandan);
        return null;
    }


}
