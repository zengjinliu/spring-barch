package com.kiway.spring.swagger.springswagger.service.impl;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.bean.User;
import com.kiway.spring.swagger.springswagger.service.ThreadService;
import com.kiway.spring.swagger.springswagger.task.MyTask;
import com.kiway.spring.swagger.springswagger.task.TestQueue1Task;
import com.kiway.spring.swagger.springswagger.task.TestQueueTask;
import com.kiway.spring.swagger.springswagger.util.SplitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuZj
 * @date 2019/9/25 14:50
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;


    @Override
    public String getResult() throws Exception {
        int threadNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        AtomicLong processingDataLength = new AtomicLong();
        List<List<Integer>> list = SplitUtil.split(getList(), 5);
        Integer sum =0;
        for (List<Integer> integers : list) {
            MyTask myTask = new MyTask(integers, countDownLatch, processingDataLength);
            Future<?> submit = taskExecutor.submit(myTask);
            sum = sum + (Integer)submit.get();
            System.out.println("【计算的结果为：】=======================>" + submit.get());
        }
        System.out.println("*************************************************计算的总和为：" + sum);
        countDownLatch.await(20, TimeUnit.MINUTES);
        System.out.println("【执行的数量为：】=============》" + processingDataLength.get());
        boolean flag = 25 == processingDataLength.get();
        System.out.println("【执行的数据量是否一致：】====================>" + flag);
        return "aa";
    }

    @Override
    public void getResult1() throws Exception {
        List<User> users = Arrays.asList(   new User(1,"11","22"),
                                            new User(2,"12","23"),
                                            new User(3,"13","24"),
                                            new User(4,"14","25"),
                                            new User(5,"15","26"),
                                            new User(6,"16","27"));

        int threadNum = users.size()/2 + 1;

        ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<User>(users.size());
        queue.addAll(users);
        //未完成的线程数
        AtomicLong atomicLong = new AtomicLong(threadNum);
        //是否已结束
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        LinkedBlockingQueue<Product> products = new LinkedBlockingQueue<>();
        for (int i = 0; i < threadNum; i++) {
            TestQueueTask task = new TestQueueTask(queue,products,atomicLong,atomicBoolean);
            taskExecutor.execute(task);
        }
        createTestQueue1Task(products,atomicBoolean);
    }

    private void createTestQueue1Task(LinkedBlockingQueue<Product> products,AtomicBoolean atomicBoolean) {
        int threadNum = 2;
        for (int i = 0; i < threadNum; i++) {
            TestQueue1Task task = new TestQueue1Task(products,atomicBoolean);
            taskExecutor.execute(task);
        }
    }

    @Override
    public Map<String, Object> testAsync() {
        this.async1();
        this.async2();
        this.async3();
        Map<String,Object> map = new HashMap<>(3);
        map.put("name","jay");
        map.put("age","40");
        map.put("phone","123456");
        return map;
    }

    @Async
    public void async1() {
        LocalDateTime start = LocalDateTime.now();

        System.out.println("【<开始执行任务1>】");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【任务1耗时为：】" + Duration.between(start,LocalDateTime.now()).toMillis());
    }
    @Async
    public void async2() {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("【<开始执行任务2>】");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【任务2耗时为：】" + Duration.between(start,LocalDateTime.now()).toMillis());
    }
    @Async
    public void async3() {
        LocalDateTime start = LocalDateTime.now();
        System.out.println("【<开始执行任务3>】");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【任务3耗时为：】" + Duration.between(start,LocalDateTime.now()).toMillis());
    }


    private List<Integer> getList() {
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a1.add(6);
        a1.add(7);
        a1.add(8);
        a1.add(9);
        a1.add(10);
        a1.add(11);
        a1.add(12);
        a1.add(13);
        a1.add(14);
        a1.add(15);
        a1.add(16);
        a1.add(17);
        a1.add(18);
        a1.add(19);
        a1.add(20);
        a1.add(21);
        a1.add(22);
        a1.add(23);
        a1.add(24);
        a1.add(25);
        return a1;
    }



}
