package com.kiway.spring.swagger.springswagger.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;


/**
 * @author LiuZj
 * @date 2019/9/26 14:17
 */
@Configuration
public class ScheduledPoolConfig {


    /**
     * 配置调度池子，控制事务
     * @return
     */
    @Bean("scheduledExecutorService")
    public ScheduledExecutorService scheduledExecutorService(){
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5,threadFactory());
        return service;
    }
    @Bean
    public ThreadFactory threadFactory(){
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setNameFormat("demo-pool-%d");
        return threadFactoryBuilder.build();
    }



}
