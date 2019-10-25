package com.kiway.spring.swagger.springswagger.service.impl;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.bean.User;
import com.kiway.spring.swagger.springswagger.exception.MyException;
import com.kiway.spring.swagger.springswagger.mapper.ProductMapper;
import com.kiway.spring.swagger.springswagger.mapper.UserMapper;
import com.kiway.spring.swagger.springswagger.service.ProductService;
import com.kiway.spring.swagger.springswagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiuZj
 * @date 2019/9/20 17:50
 */
@Service
@Order(0)
public class UserServiceImpl implements UserService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = MyException.class)
    public boolean add(User user) {
        Product product = new Product();
        product.setProductId(1).setProductInfo("小龙虾");
        return this.addUser(user) && this.addProduct(product);
    }


    private boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    private boolean addProduct(Product product) {
        return productMapper.insert(product) > 0;
    }


}
