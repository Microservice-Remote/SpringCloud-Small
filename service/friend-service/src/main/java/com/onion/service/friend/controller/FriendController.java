package com.onion.service.friend.controller;

import com.onion.api.friendapi.FriendServiceApi;
import com.onion.pojo.user.Friend;
import com.onion.service.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OnionMac on 2018/2/8.
 */
@RestController
public class FriendController implements FriendServiceApi{

    @Autowired
    FriendService friendService;

    @Override
    public Friend findFriendById(@PathVariable("id") int id) {
        return friendService.findFriendById(id);
    }
}
