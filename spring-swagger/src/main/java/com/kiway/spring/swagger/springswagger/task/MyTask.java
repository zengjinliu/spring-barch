package com.kiway.spring.swagger.springswagger.task;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuZj
 * @date 2019/9/25 10:24
 */
@Slf4j
public class MyTask implements Callable<Integer> {

    /**数字集合*/
    private List<Integer> num;

    /**同步工具类(共享变量)*/
    private CountDownLatch currentLatch;

    /**处理的数据量(共享变量)*/
    private AtomicLong processingDataLength;

    public MyTask(List<Integer> num, CountDownLatch currentLatch, AtomicLong processingDataLength) {
        this.num = num;
        this.currentLatch = currentLatch;
        this.processingDataLength = processingDataLength;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("【当前线程名为:===============>】" + Thread.currentThread().getName());
        Integer sum = null;
        try {
            sum = sum(num);
            long andAdd = this.processingDataLength.getAndAdd(num.size());
            System.out.println("【目前处理的数据为：】============>" + andAdd);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.currentLatch.countDown();
            System.out.println("【当前的线程数：】===============>" + currentLatch.getCount());
        }
        return sum;
    }
    private Integer sum(List<Integer> num) throws Exception{
        Integer sum = num.stream().reduce(0, (x, y) -> x + y);
        return sum;
    }
}
