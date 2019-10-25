package com.kiway.spring.swagger.springswagger.service;

import java.util.List;
import java.util.Map;

/**
 * @author LiuZj
 * @date 2019/9/25 14:49
 */
public interface ThreadService {

    /**
     * 求和
     * @return
     */
    String getResult() throws Exception;


    void getResult1() throws Exception;


    Map<String,Object> testAsync();

}
