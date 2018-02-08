package com.onion.service.friend.service.impl;

import com.onion.pojo.user.Friend;
import com.onion.service.friend.mapper.FriendMapper;
import com.onion.service.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OnionMac on 2018/2/8.
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    FriendMapper friendMapper;
    @Override
    public Friend findFriendById(int id) {
        return friendMapper.findFriendById(id);
    }
}
