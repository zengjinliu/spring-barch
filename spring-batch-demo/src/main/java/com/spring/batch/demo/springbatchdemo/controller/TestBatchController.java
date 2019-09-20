package com.spring.batch.demo.springbatchdemo.controller;

import com.spring.batch.demo.springbatchdemo.bean.TestBatch;
import com.spring.batch.demo.springbatchdemo.service.TestBatchService;
import com.spring.batch.demo.springbatchdemo.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author LiuZj
 * @date 2019/9/17 13:56
 */
@Controller
public class TestBatchController {

    @Autowired
    private TestBatchService testBatchService;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;


    @RequestMapping("/add")
    @ResponseBody
    public Map<String, String> add() {
        List<TestBatch> list = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            TestBatch testBatchModel = new TestBatch();
            testBatchModel.setAge(i);
            testBatchModel.setCreateDate(new Date());
            testBatchModel.setName("jay-" + i);
            testBatchModel.setSeqId(snowflakeIdWorker.nextId());
            list.add(testBatchModel);
        }
        testBatchService.addBatch(list);
        Map<String, String> map = new HashMap<>(2);
        map.put("add", "success");
        return map;
    }

}
