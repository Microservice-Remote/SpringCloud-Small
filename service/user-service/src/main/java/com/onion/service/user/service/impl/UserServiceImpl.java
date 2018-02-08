package com.onion.service.user.service.impl;

import com.onion.pojo.user.Author;
import com.onion.pojo.user.User;
import com.onion.service.user.mapper.UserMapper;
import com.onion.service.user.service.UserService;
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
