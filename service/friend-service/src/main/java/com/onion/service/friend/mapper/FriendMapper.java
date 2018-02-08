package com.onion.service.friend.mapper;

import com.onion.pojo.user.Friend;
import org.apache.ibatis.annotations.Param;

/**
 * Created by OnionMac on 2018/2/8.
 */
public interface FriendMapper {

    Friend findFriendById(@Param("id") int id);

}
