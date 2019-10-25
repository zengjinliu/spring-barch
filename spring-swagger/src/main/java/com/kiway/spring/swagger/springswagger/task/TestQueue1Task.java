package com.kiway.spring.swagger.springswagger.task;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuZj
 * @date 2019/10/25 11:49
 */
public class TestQueue1Task implements Runnable {
    /**机构无界队列，往里面塞数据*/
    private LinkedBlockingQueue<Product> products;

    /**是否结束（共享变量）*/
    private AtomicBoolean isRunning;

    public TestQueue1Task(LinkedBlockingQueue<Product> products, AtomicBoolean isRunning) {
        this.products = products;
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        while (!products.isEmpty()) {

            Product product = null;
            try {
                product = products.poll(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("取出的产品为：" + product);

        }
    }
}
