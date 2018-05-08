package com.onion.service.friend.controller;

import com.onion.api.friendapi.FriendServiceApi;
import com.onion.pojo.user.Friend;
import com.onion.service.friend.api.UserApi;
import com.onion.service.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by OnionMac on 2018/2/8.
 */
@RestController
public class FriendController implements FriendServiceApi{

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    FriendService friendService;

    @Autowired
    UserApi userApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Friend findFriendById(@PathVariable("id") int id) {
        discoveryClient.getLocalServiceInstance().getPort();
        return friendService.findFriendById(id);
    }

    @Override
    public String find(@PathVariable("id") int id) {
        return restTemplate.getForObject("http://localhost:8040/user/getName",String.class);
    }

}
