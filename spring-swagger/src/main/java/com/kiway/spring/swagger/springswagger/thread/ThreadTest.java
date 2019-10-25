package com.kiway.spring.swagger.springswagger.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuZj
 * @date 2019/10/25 16:00
 */
public class ThreadTest {


    public static void main(String[] args) {
        //线程个数
        int threadNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {

        }

    }

    class TestTask implements Runnable{

        /**每条线程处理的数据*/
        private List<Integer> num;

        /**线程同步计数器*/
        private CountDownLatch countDownLatch;

        /**每条线程处理的数据*/
        private AtomicLong atomicLong;

        public TestTask(List<Integer> num, CountDownLatch countDownLatch, AtomicLong atomicLong) {
            this.num = num;
            this.countDownLatch = countDownLatch;
            this.atomicLong = atomicLong;
        }

        @Override
        public void run() {

        }
    }

}
