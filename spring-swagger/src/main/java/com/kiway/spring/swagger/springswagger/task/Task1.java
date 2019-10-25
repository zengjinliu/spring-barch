package com.kiway.spring.swagger.springswagger.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author LiuZj
 * @date 2019/9/26 15:59
 */
@Slf4j
public class Task1 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.error("我是task1111 ，我将执行1s钟， 线程名字 == > {} , 现在时间为 == > {}", Thread.currentThread().getId(), LocalDateTime.now());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error("我是task1111，我已经执行完成了，线程名字 == > {} , 现在时间为 == > {}",Thread.currentThread().getId(), LocalDateTime.now());

    }
}
