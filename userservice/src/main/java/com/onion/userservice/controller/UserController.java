package com.onion.userservice.controller;

import com.onion.api.userapi.UserService;
import com.onion.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getName")
    public String getName(){
        return userService.getName();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.findUserById(id);
    }
}
