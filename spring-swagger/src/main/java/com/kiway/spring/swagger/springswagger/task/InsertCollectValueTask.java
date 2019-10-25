package com.kiway.spring.swagger.springswagger.task;

import com.kiway.spring.swagger.springswagger.bean.YJJHCollectValue;
import com.kiway.spring.swagger.springswagger.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author LiuZj
 * @date 2019/10/25 15:10
 */
public class InsertCollectValueTask implements Runnable{

    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserService service;

    /**每条线程处理的数据量*/
    private List<YJJHCollectValue> collectValues;

    /**同步工具类(共享变量)*/
    private CountDownLatch currentLatch;

    /**处理的数据量*/
    private AtomicLong atomicLong;

    @Override
    public void run() {
        DataSourceTransactionManager transactionManager = context.getBean("transactionManager", DataSourceTransactionManager.class);
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            //调用插入的方法
//            collectValues.forEach(service::add);
            this.atomicLong.getAndAdd(this.collectValues.size());
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        } finally {
            //同步计数器减一
            this.currentLatch.countDown();
        }
    }
}
