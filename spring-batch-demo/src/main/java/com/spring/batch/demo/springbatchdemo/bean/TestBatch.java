package com.spring.batch.demo.springbatchdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LiuZj
 * @date 2019/9/17 8:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TestBatch implements Serializable {


    private Long seqId;

    private String name;

    private int age;

    private Date createDate;




}
