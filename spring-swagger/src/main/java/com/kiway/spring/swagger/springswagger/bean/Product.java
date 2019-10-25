package com.kiway.spring.swagger.springswagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LiuZj
 * @date 2019/9/20 17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("商品实体")
@Builder
public class Product {

    @ApiModelProperty("用户的主键 productId")
    private Integer productId;

    @ApiModelProperty("商品信息 productInfo")
    private String productInfo;
}
