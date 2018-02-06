package com.onion.userservice.service;

import com.onion.pojo.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/2/6 0006.
 */
public interface UserService {

    String getName();

    User findUserById(int id);
}
