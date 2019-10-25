package com.kiway.spring.swagger.springswagger.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author LiuZj
 * @date 2019/9/26 16:12
 */
@Slf4j
@Component
public class Task2 extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.error("我是task2222 ，我将执行4s钟， 线程名字 == > {} , 现在时间为 == > {}", Thread.currentThread().getId(), LocalDateTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        log.error("我是task2222，我已经执行完成了，线程名字 == > {} , 现在时间为 == > {}",Thread.currentThread().getId(), LocalDateTime.now());
    }
}
