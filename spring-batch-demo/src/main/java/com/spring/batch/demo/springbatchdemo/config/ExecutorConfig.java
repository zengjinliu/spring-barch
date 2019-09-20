package com.spring.batch.demo.springbatchdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author LiuZj
 * @date 2019/9/17 9:25
 */

@Configuration
public class ExecutorConfig {


    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(50);
        threadPoolTaskExecutor.setQueueCapacity(300);
        threadPoolTaskExecutor.setMaxPoolSize(1000);
        threadPoolTaskExecutor.setKeepAliveSeconds(3000);
        threadPoolTaskExecutor.setThreadNamePrefix("spring-batch");
        return threadPoolTaskExecutor;
    }

}
