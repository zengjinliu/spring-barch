package com.spring.batch.demo.springbatchdemo.mapper;

import com.spring.batch.demo.springbatchdemo.bean.TestBatch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiuZj
 * @date 2019/9/17 9:02
 */
@Mapper
public interface TestBatchMapper {

    int batchInsert(TestBatch batch);

}
