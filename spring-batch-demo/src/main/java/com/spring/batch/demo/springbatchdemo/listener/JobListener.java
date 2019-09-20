package com.spring.batch.demo.springbatchdemo.listener;

import org.apache.tomcat.jni.Local;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author LiuZj
 * @date 2019/9/18 8:44
 */
@Component
public class JobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        Date startTime = jobExecution.getStartTime();
        Instant instant = startTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId);
        System.out.println("job的开始时间为：" + localDateTime);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String exitCode = jobExecution.getExitStatus().getExitCode();
        System.out.println(exitCode);
    }
}
