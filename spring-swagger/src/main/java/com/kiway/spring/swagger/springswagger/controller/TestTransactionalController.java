package com.kiway.spring.swagger.springswagger.controller;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.bean.User;
import com.kiway.spring.swagger.springswagger.service.ProductService;
import com.kiway.spring.swagger.springswagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuZj
 * @date 2019/9/20 17:53
 */
@RestController
public class TestTransactionalController {


    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @RequestMapping("/add")
    public String add(){
        User user = new User();
        user.setId(1).setUsername("root").setPassword("jin0792");
        boolean add = userService.add(user);
        Product product = new Product();
        product.setProductId(1).setProductInfo("小龙虾");
        boolean add1 = productService.add(product);
        boolean flag = add && add1;
        return "success" + flag;
    }

    @RequestMapping("/adduser")
    public String addUser(){
        User user = new User();
        user.setId(1).setUsername("root").setPassword("jin0792");
        boolean flag = userService.add(user);
        return "success" + flag;
    }


}
