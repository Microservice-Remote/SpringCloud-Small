package com.onion.api.userapi;

import com.onion.pojo.user.User;

/**
 * Created by OnionMac on 2018/2/6.
 * 由service实现 web端不实现
 */
public interface UserService {

    String getName();

    User findUserById(int id);
//
//    MetaData getMetaData();
}
