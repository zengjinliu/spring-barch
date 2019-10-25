package com.kiway.spring.swagger.springswagger.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author LiuZj
 * @date 2019/9/27 8:36
 */
public class MyJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("【hello myjob】");
    }
}
