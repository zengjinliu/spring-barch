package com.kiway.spring.swagger.springswagger.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 采集值表
 * @author 肖宇文
 * @date 2019/7/9/9:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class YJJHCollectValue {
    /**
     * 主键
     */
    private String rId;
    /**
     * 采集项Id
     */
    private String cId;
    /**
     * 采集项代码
     */
    private String cDm;
    /**
     * 采集的值
     */
    private String content;
    /**
     * 新增人
     */
    private String xzr;
    /**
     * 新增时间
     */
    private Date xzsj;
    /**
     * 更新人
     */
    private String gxr;
    /**
     * 更新时间
     */
    private Date gxsj;
    /**
     * 关联 批次表jc_batch 主键 bid
     */
    private String bId;
    /**
     * 上报组织Id
     */
    private String upOrgId;
    /**
     *该学校办学类型： 使用kwm 公用的办学代码
     */
    private String schoolRunningType;

}
