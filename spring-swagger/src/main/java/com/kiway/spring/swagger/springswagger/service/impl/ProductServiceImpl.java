package com.kiway.spring.swagger.springswagger.service.impl;

import com.kiway.spring.swagger.springswagger.bean.Product;
import com.kiway.spring.swagger.springswagger.mapper.ProductMapper;
import com.kiway.spring.swagger.springswagger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuZj
 * @date 2019/9/20 17:51
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
        return this.addProduct(product);
    }

    private boolean addProduct(Product product){
        return productMapper.insert(product) > 0;
    }
}
