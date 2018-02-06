package com.onion.userservice.mapper;

import com.onion.pojo.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Repository
public interface UserMapper {

    User findUserById(int id);

}
