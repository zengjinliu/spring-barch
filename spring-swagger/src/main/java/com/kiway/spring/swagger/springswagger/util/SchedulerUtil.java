package com.kiway.spring.swagger.springswagger.util;

import com.kiway.spring.swagger.springswagger.task.MyJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author LiuZj
 * @date 2019/9/27 8:39
 */
@Slf4j
public class SchedulerUtil {

    /**
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务类
     * @param time             intevalTime时间间隔
     * @param count            执行几次
     */
    public static void handleSimpleTrigger(String jobName, String jobGroupName,
                                           String triggerName, String triggerGroupName, Class jobClass,
                                           int time, int count) throws Exception {
        //1:通过SchedulerFactory获取调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2:创建JobDetail示例，绑定job实现类
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroupName).build();
        //3:定义调度触发规则
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroupName)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(time).withRepeatCount(count))
                .startNow()
                .build();
        //4:把job和trigger注册到任务调度中
        scheduler.scheduleJob(jobDetail, trigger);
        //5:启动调度
        scheduler.start();
    }

    /**
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务类
     * @param cron             执行表达式
     * @throws Exception
     */
    public static void handleCornTrigger(String jobName, String jobGroupName,
                                         String triggerName, String triggerGroupName,
                                         Class jobClass, String cron) throws Exception {
        //1:通过SchedulerFactory获取调度器Scheduler
        JobDataMap jobDataMap = new JobDataMap();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2:创建JobDetail示例，绑定job实现类
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroupName).build();
        //3:定义调度触发规则
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroupName)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .startNow()
                .build();
        //4:把job和trigger注册到任务调度中
        scheduler.scheduleJob(jobDetail, trigger);
        //5:启动调度
        scheduler.start();
    }

    public static void main(String[] args) throws Exception{
        //简单调度
        /*SchedulerUtil.handleSimpleTrigger("jay","jayGroup"
                ,"jayTrigger","jayTriggerGroup", MyJob.class,1,5);*/
        //复杂调度
        SchedulerUtil.handleCornTrigger("jay","jayGroup"
                ,"jayTrigger","jayTriggerGroup", MyJob.class,"*/5 * * * * ?");
    }


}
