package com.onion.userservice.service.impl;

import com.onion.api.userapi.UserServiceApi;
import com.onion.pojo.user.Author;
import com.onion.pojo.user.User;
import com.onion.userservice.mapper.UserMapper;
import com.onion.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Author author;

    @Autowired
    UserMapper userMapper;

    @Override
    public String getName() {
        return author.getName();
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }


}
