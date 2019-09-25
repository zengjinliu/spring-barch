package com.spring.dynamicdatasource.springdynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试同一个mysql数据源两个不同的数据库+
 * 测试一个数据库是oracle,一个是mysql数据库
 *
 */

@SpringBootApplication
public class SpringDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDynamicDatasourceApplication.class, args);
    }

}
