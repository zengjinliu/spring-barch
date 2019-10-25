package com.kiway.spring.swagger.springswagger.config;

import com.kiway.spring.swagger.springswagger.task.Task1;
import com.kiway.spring.swagger.springswagger.task.Task2;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.simpl.SimpleThreadPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author LiuZj
 * @date 2019/9/26 15:55
 */
//@Configuration
@Slf4j
public class QuartzConfig {

//    protected static final Level OPERATING = Level.forName("BUS", 250);

    //配置具体任务

//    @Bean
    public JobDetail task1JobDetail() {
        return JobBuilder.newJob(Task1.class)
                .withIdentity("task1")
                .storeDurably(true)
                .build();
    }
//    @Bean
    public JobDetail task2JobDetail() {
        return JobBuilder.newJob(Task2.class)
                .withIdentity("task2")
                .storeDurably(true)
                .build();
    }

    //配置触发间隔

//    @Bean
    public Trigger task1Trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(task1JobDetail())
                .withIdentity("task1")
                .withSchedule(scheduleBuilder)
                .build();
    }

//    @Bean
    public Trigger task2Trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/4 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(task2JobDetail())
                .withIdentity("task2")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
