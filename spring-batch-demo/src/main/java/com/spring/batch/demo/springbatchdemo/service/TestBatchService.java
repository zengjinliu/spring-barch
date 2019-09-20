package com.spring.batch.demo.springbatchdemo.service;

import com.spring.batch.demo.springbatchdemo.bean.TestBatch;

import java.util.List;

/**
 * @author LiuZj
 * @date 2019/9/17 10:37
 */
public interface TestBatchService {

    void addBatch(List<TestBatch> list);
}
