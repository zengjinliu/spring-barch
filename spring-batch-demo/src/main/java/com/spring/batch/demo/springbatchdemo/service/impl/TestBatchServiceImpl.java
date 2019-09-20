package com.spring.batch.demo.springbatchdemo.service.impl;

import com.spring.batch.demo.springbatchdemo.bean.TestBatch;
import com.spring.batch.demo.springbatchdemo.listener.TestBatchListener;
import com.spring.batch.demo.springbatchdemo.mapper.TestBatchMapper;
import com.spring.batch.demo.springbatchdemo.service.TestBatchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.List;

/**
 * @author LiuZj
 * @date 2019/9/17 10:38
 */
@Service
@Slf4j
public class TestBatchServiceImpl implements TestBatchService {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private SimpleJobLauncher launcher;
    @Autowired
    private TestBatchListener testBatchListener;
    @Autowired
    @Qualifier("testBatchAddItemWriter")
    private MyBatisBatchItemWriter testBatchAddItemWriter;


    @Bean("testBatchAddItemWriter")
    @Autowired
    protected MyBatisBatchItemWriter testBatchAddItemWriter(SqlSessionTemplate sqlSessionTemplate, SqlSessionFactory sqlSessionFactory) {
        MyBatisBatchItemWriter itemWriter = new MyBatisBatchItemWriter();
        itemWriter.setSqlSessionFactory(sqlSessionFactory);
        itemWriter.setSqlSessionTemplate(sqlSessionTemplate);
        itemWriter.setStatementId("com.spring.batch.demo.springbatchdemo.mapper.TestBatchMapper.batchInsert");
        return itemWriter;
    }


    private Job createTestBatchAddJob(Step step) {
        Job job = jobBuilderFactory.get("testBatchAddJob")
                .start(step)
                .build();
        return job;
    }


    /**
     * 构建step
     *
     * @param itemReader
     * @param writer
     * @return
     */
    private Step createTestBatchAddStep(ItemReader<TestBatch> itemReader,ItemWriter<TestBatch> writer) {
        return stepBuilderFactory.get("testBatchAddStep")
                .listener(testBatchListener)
                .<TestBatch, TestBatch>chunk(10000)
                .faultTolerant()
                .retryLimit(5)
                .retry(Exception.class)
                .skipLimit(10)
                .skip(Exception.class)
                .reader(itemReader)
                .writer(writer)
                .build();
    }



    @Override
    public void addBatch(List<TestBatch> list) {
        ListItemReader<TestBatch> listItemReader = new ListItemReader<>(list);
        Step step = this.createTestBatchAddStep(listItemReader, testBatchAddItemWriter);
        Job job = this.createTestBatchAddJob(step);
        JobParametersBuilder jobParameters = new JobParametersBuilder();
        jobParameters.addLong("date", LocalDateTime.now().getLong(ChronoField.MICRO_OF_DAY));
        try {
            this.launcher.run(job, jobParameters.toJobParameters());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }



}
