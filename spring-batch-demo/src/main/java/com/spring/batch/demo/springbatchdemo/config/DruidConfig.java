package com.spring.batch.demo.springbatchdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.DefaultVFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author LiuZj
 * @date 2019/9/17 9:23
 */
@Configuration
public class DruidConfig {

    @Resource
    private Properties projectInfo;

    @Autowired
    private ApplicationContext applicationContext;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    protected SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
        return sqlSessionTemplate;
    }
    @Bean
    protected SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setVfs(DefaultVFS.class);
        sessionFactoryBean.setConfigurationProperties(projectInfo);
        //加载mybatis配置文件
        sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatisConfiguration.xml"));
        //加载XML文件,用@MapperScan注解，该配置可以忽略
        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        sessionFactoryBean.setPlugins(getMybatisInterceptor());
        return sessionFactoryBean.getObject();
    }
    private Interceptor[] getMybatisInterceptor() {
        Map<String, Interceptor> p = applicationContext.getBeansOfType(Interceptor.class);
        List<Interceptor> ps = new ArrayList<>(p.values());

        return ps.stream().toArray(Interceptor[]::new);

    }

}

