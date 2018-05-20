package com.onion.service.user.service;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.user.User;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrator on 2018/2/6 0006.
 */
public interface UserService {

    String getName();

    User findUserById(int id);

    HttpWrapper<User> register(User user,String code,String token);

    HttpWrapper<User> register(User user);

    HttpWrapper<User> login(@NotNull User user);
}
