package com.spring.batch.demo.springbatchdemo.config;

import com.spring.batch.demo.springbatchdemo.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiuZj
 * @date 2019/9/17 9:09
 */
@Configuration
public class GeneratorIdConfig {



    @Bean
    public SnowflakeIdWorker snowflakeIdWorker(){
        return new SnowflakeIdWorker(1,1);
    }

}
