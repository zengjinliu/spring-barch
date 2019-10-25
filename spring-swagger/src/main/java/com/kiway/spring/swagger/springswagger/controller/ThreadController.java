package com.kiway.spring.swagger.springswagger.controller;

import com.kiway.spring.swagger.springswagger.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuZj
 * @date 2019/9/25 14:49
 */
@RestController
public class ThreadController {


    @Autowired
    private ThreadService threadService;

    @RequestMapping("/sum")
    public String sum() throws Exception{
        String result = threadService.getResult();
        return result;
    }

    @RequestMapping("/queue")
    public String queue() throws Exception {
        threadService.getResult1();
        return "queue";
    }


}
