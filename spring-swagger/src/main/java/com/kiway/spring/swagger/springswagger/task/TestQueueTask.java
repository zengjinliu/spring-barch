package com.kiway.spring.swagger.springswagger.task;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuZj
 * @date 2019/10/25 11:11
 */
public class TestQueueTask implements Runnable{
    /**共享队列*/
    private ArrayBlockingQueue<User> queue;

    /**机构无界队列，往里面塞数据*/
    private LinkedBlockingQueue<Product> products;

    /**处理的数据量(共享变量)*/
    private AtomicLong processingDataLength;

    /**是否结束（共享变量）*/
    private AtomicBoolean isRunning;

    public TestQueueTask(ArrayBlockingQueue<User> queue, LinkedBlockingQueue<Product> products, AtomicLong processingDataLength, AtomicBoolean isRunning) {
        this.queue = queue;
        this.products = products;
        this.processingDataLength = processingDataLength;
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        List<User> users = new ArrayList<>();
        while (!this.queue.isEmpty()) {
            User user;
            try {
                //队列里面取数据
                user = queue.take();
                users.add(user);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //数据处理(从队列里面取出的数据可能不符合我最终需要的数据,这一步是对数据进行处理，
        // 以达到自己最终想要的数据)
        for (User user : users) {
            Product product = Product.builder().
                    productId(user.getId()).productInfo(user.getUsername()).build();
            try {
                //往队列里面塞数据
                this.products.put(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //处理数据完毕，并且设置是否处理完毕为false
                if (this.processingDataLength.decrementAndGet()==0) {
                    this.isRunning.set(false);
                }
            }
        }
    }
}
