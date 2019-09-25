package com.spring.dynamicdatasource.springdynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 第一个数据源的配置
 *
 * @author LiuZj
 * @date 2019/9/24 16:10
 */

@Configuration
@MapperScan(basePackages = "com.spring.dynamicdatasource.springdynamicdatasource.firstmapper",
        sqlSessionFactoryRef = "sqlSessionFactory1")
@PropertySource(value = "classpath:application.properties")
public class FirstDataSourceConfig {

    @Autowired
    private ApplicationContext context;

    @Value("${spring.first.url}")
    private String url;
    @Value("${spring.first.username}")
    private String username;
    @Value("${spring.first.password}")
    private String password;
    @Value("${spring.first.driver-class-name}")
    private String driverClassName;


    @Bean("firstDataSource1")
    @Primary
    public DataSource firstDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(firstDataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:mapper/first/*.xml"));
        return factoryBean.getObject();
    }

    @Bean("sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory1());
        return sqlSessionTemplate;
    }

}
