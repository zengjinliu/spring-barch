package com.kiway.spring.swagger.springswagger.controller;

import com.kiway.spring.swagger.springswagger.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author LiuZj
 * @date 2019/9/26 10:55
 */
@RestController
public class TestAsyncController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping("/async")
    public Map<String,Object> async(){
        Map<String, Object> map = threadService.testAsync();
        return map;
    }





}
