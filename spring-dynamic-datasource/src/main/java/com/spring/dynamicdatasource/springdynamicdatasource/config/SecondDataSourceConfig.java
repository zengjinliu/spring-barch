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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author LiuZj
 * @date 2019/9/24 16:24
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@MapperScan(basePackages = "com.spring.dynamicdatasource.springdynamicdatasource.secondmapper",
        sqlSessionFactoryRef = "sqlSessionFactory2")
public class SecondDataSourceConfig {

    @Autowired
    private ApplicationContext context;

    @Value("${spring.second.url}")
    private String url;
    @Value("${spring.second.username}")
    private String username;
    @Value("${spring.second.password}")
    private String password;
    @Value("${spring.second.driver-class-name}")
    private String driverClassName;


    @Bean("secondDataSource2")
    public DataSource secondDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(secondDataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:mapper/second/*.xml"));
        return factoryBean.getObject();
    }

    @Bean("sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory2());
        return sqlSessionTemplate;
    }


}
