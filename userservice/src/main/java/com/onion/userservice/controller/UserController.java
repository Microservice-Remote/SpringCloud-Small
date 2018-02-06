package com.onion.userservice.controller;

import com.onion.api.userapi.UserServiceApi;
import com.onion.pojo.user.User;
import com.onion.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
public class UserController implements UserServiceApi {

    @Autowired
    UserService userService;

    @Override
    public String getName(){
        return userService.getName();
    }

    @Override
    public User findUserById(int id) {
        return userService.findUserById(id);
    }

}