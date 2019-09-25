package com.spring.dynamicdatasource.springdynamicdatasource.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LiuZj
 * @date 2019/9/20 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    private Integer id;

    private String username;

    private String password;


}
