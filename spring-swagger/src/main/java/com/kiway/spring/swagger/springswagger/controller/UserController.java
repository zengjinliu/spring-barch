package com.kiway.spring.swagger.springswagger.controller;

import com.kiway.spring.swagger.springswagger.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuZj
 * @date 2019/9/20 14:21
 */
@Api(tags = "用户相关接口", description = "")
@RestController
public class UserController {

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public boolean add(@RequestBody User user) {
        return false;
    }

    @GetMapping("/get/{username}")
    public User get(@PathVariable("username") String username) {
        return new User();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    @DeleteMapping("/delete/{username}")
    public boolean delete(@PathVariable("username") String username) {
        return true;
    }


}
