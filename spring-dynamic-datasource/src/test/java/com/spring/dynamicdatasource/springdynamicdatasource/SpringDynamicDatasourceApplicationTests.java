package com.spring.dynamicdatasource.springdynamicdatasource;

import com.spring.dynamicdatasource.springdynamicdatasource.bean.Bus;
import com.spring.dynamicdatasource.springdynamicdatasource.bean.JcUser;
import com.spring.dynamicdatasource.springdynamicdatasource.bean.User;
import com.spring.dynamicdatasource.springdynamicdatasource.firstmapper.UserMapper;
import com.spring.dynamicdatasource.springdynamicdatasource.secondmapper.BusMapper;
import com.spring.dynamicdatasource.springdynamicdatasource.thirdmapper.TestJcUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDynamicDatasourceApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusMapper busMapper;
    @Autowired
    private TestJcUserMapper batchMapper;

    @Test
    public void test1() {
        User user = new User();
        user.setId(1).setUsername("james").setPassword("123456");
        int result = userMapper.insert(user);
        Assert.assertNotEquals("【新增失败】", 0, result);
    }

    @Test
    public void test2() {
        Bus bus = new Bus();
        bus.setId(1).setNum("M240").setAge(12);
        int result = busMapper.insert(bus);
        Assert.assertNotEquals("【新增失败】", 0, result);
    }

    @Test
    public void test3(){
        JcUser user = new JcUser();
        user.setUId("111111").setUUsername("aaa").setUUserid("222222222");
        int result = batchMapper.insert(user);
        Assert.assertNotEquals("【新增失败】", 0, result);
    }


}
