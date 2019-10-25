package com.kiway.spring.swagger.springswagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户实体")
public class User {
    @ApiModelProperty("主键 id")
    private Integer id;

    @ApiModelProperty("用户名 username")
    private String username;

    @ApiModelProperty("用户密码 password")
    private String password;


}
