package com.spring.dynamicdatasource.springdynamicdatasource.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LiuZj
 * @date 2019/9/24 16:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Bus {

    private Integer id;

    private String num;

    private Integer age;
}
