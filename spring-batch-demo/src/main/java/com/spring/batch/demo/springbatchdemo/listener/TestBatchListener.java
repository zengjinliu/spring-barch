package com.spring.batch.demo.springbatchdemo.listener;

import org.springframework.batch.core.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LiuZj
 * @date 2019/9/17 16:03
 */
@Component
public class TestBatchListener implements StepExecutionListener {

    private Date startTime = null;
    private Date endTime = null;


    @Override
    public void beforeStep(StepExecution stepExecution) {
        startTime = stepExecution.getStartTime();
        System.out.println("step开始时间：" + startTime);

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        ExitStatus exitStatus1 = stepExecution.getExitStatus();
        endTime = new Date();
        System.out.println("step结束时间：" + endTime);
        long time = (endTime.getTime() - startTime.getTime())/1000;
        System.out.println("耗时为：" + time + "秒");
        ExitStatus exitStatus = stepExecution.getExitStatus();
        return exitStatus;
    }
}
