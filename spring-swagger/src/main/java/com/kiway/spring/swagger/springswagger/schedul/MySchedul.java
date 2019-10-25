package com.kiway.spring.swagger.springswagger.schedul;

import com.kiway.spring.swagger.springswagger.bean.User;
import com.kiway.spring.swagger.springswagger.service.ProductService;
import com.kiway.spring.swagger.springswagger.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 自定义定时任务
 *
 * @author LiuZj
 * @date 2019/9/23 17:24
 */
//@Component
@Slf4j
public class MySchedul {



    @Scheduled(cron = "*/5 * * * * ?")
    @Async
    public void schedul() {
        log.error("我是task1111，我需要执行 10s 钟的时间，我的线程的 id == > {}，时间 == >{}", Thread.currentThread().getId(), LocalDateTime.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error("task1111 ending ,我的线程的 id == > {} , 时间 == > {}", Thread.currentThread().getId(), LocalDateTime.now());

    }

    @Scheduled(cron = "*/5 * * * * ?")
    @Async
    public void schedul1() {
        log.error("我是task2222，我需要执行 2s 钟的时间，我的线程的 id == > {}，时间 == >{}", Thread.currentThread().getId(), LocalDateTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.error("task2222 ending ,我的线程的 id == > {} , 时间 == > {}", Thread.currentThread().getId(), LocalDateTime.now());
    }



}
