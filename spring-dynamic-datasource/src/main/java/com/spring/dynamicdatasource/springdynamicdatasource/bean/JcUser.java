package com.spring.dynamicdatasource.springdynamicdatasource.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author LiuZj
 * @date 2019/9/24 17:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JcUser {

    private String uId;
    private String uUserid;
    private String uUsername;

}
