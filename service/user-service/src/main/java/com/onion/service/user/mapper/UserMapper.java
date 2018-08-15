package com.onion.service.user.mapper;

import com.onion.pojo.news.Tab;
import com.onion.pojo.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Repository
public interface UserMapper {

    User findUserById(int id);

    int insertUser(User user);

    User findUserByPhone(@Param("phone") String phone);

    List<Tab> findTabs();
}
