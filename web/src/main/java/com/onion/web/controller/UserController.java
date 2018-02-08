package com.onion.web.controller;

import com.onion.pojo.user.Author;
import com.onion.pojo.user.Friend;
import com.onion.pojo.user.User;
import com.onion.web.api.FriendApi;
import com.onion.web.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OnionMac on 2018/2/6.
 */
@RestController
@RequestMapping("web-user")
public class UserController {

    @Autowired
    Author author;

    @Autowired
    UserApi userService;

    @Autowired
    FriendApi friendApi;

    @GetMapping("/getName")
    public String getName(){
        return author.getName();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.findUserById(id);
    }

    @GetMapping("/getFriend/{id}")
    public Friend getFriend(@PathVariable("id") int id){
        return friendApi.findFriendById(id);
    }
}
