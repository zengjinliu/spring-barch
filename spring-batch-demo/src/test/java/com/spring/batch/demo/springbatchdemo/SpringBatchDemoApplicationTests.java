package com.spring.batch.demo.springbatchdemo;

import com.spring.batch.demo.springbatchdemo.bean.TestBatch;
import com.spring.batch.demo.springbatchdemo.mapper.TestBatchMapper;
import com.spring.batch.demo.springbatchdemo.util.SnowflakeIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBatchDemoApplicationTests {

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private TestBatchMapper batchMapper;

    @Test
    public void test1() {
        List<TestBatch> list = new ArrayList<>();
        TestBatch batch = new TestBatch();
        batch.setSeqId(snowflakeIdWorker.nextId())
                .setAge(11)
                .setName("jay")
                .setCreateDate(new Date());
        list.add(batch);
        int result = batchMapper.batchInsert(batch);
        System.out.println(result);
    }

}
