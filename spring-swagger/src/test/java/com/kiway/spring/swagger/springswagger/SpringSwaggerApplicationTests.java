package com.kiway.spring.swagger.springswagger;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.bean.User;
import com.kiway.spring.swagger.springswagger.config.DruidConfig;
import com.kiway.spring.swagger.springswagger.mapper.ProductMapper;
import com.kiway.spring.swagger.springswagger.mapper.UserMapper;
import com.kiway.spring.swagger.springswagger.task.AsyncReturnTask;
import com.kiway.spring.swagger.springswagger.task.AsyncTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSwaggerApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private AsyncReturnTask asyncReturnTask;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(1).setUsername("root").setPassword("jin0792");
        int result = userMapper.insert(user);
        Assert.assertNotEquals("failur", 0, result);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setProductId(1).setProductInfo("小龙虾");
        int value = productMapper.insert(product);
        Assert.assertNotEquals("failur", 0, value);
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DruidConfig.class);
        String[] names = context.getBeanDefinitionNames();
    }

    @Test
    public void test2() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    @Test
    public void test3() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        Future<Integer> taskOne = asyncReturnTask.doTaskOne();
        System.out.println(taskOne.get());
        Future<String> taskTwo = asyncReturnTask.doTaskTwo();
        Future<String> taskThree = asyncReturnTask.doTaskThree();
        while (true) {
            if(taskOne.isDone() && taskTwo.isDone() && taskThree.isDone()){
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("--------------->耗时为:" + Duration.between(start,LocalDateTime.now()).toMillis());
    }

}
