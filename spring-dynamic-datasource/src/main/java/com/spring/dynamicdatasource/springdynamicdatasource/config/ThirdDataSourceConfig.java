package com.spring.dynamicdatasource.springdynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author LiuZj
 * @date 2019/9/24 17:46
 */
@Configuration
@MapperScan(basePackages = {"com.spring.dynamicdatasource.springdynamicdatasource.thirdmapper"},
        sqlSessionFactoryRef = "sqlSessionFactory3")
@PropertySource(value = "classpath:application.properties")
public class ThirdDataSourceConfig {
    @Autowired
    private ApplicationContext context;

    @Value("${spring.third.url}")
    private String url;
    @Value("${spring.third.username}")
    private String username;
    @Value("${spring.third.password}")
    private String password;
    @Value("${spring.third.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource thirdDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory3() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(thirdDataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:mapper/third/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate3() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory3());
        return sqlSessionTemplate;
    }


}
