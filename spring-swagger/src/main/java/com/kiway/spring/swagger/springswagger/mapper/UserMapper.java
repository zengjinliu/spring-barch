package com.kiway.spring.swagger.springswagger.mapper;

import com.kiway.spring.swagger.springswagger.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiuZj
 * @date 2019/9/20 17:12
 */

public interface UserMapper extends ProductMapper{
    int insert(User user);
}
