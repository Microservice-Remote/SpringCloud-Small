package com.onion.api.friendapi;

import com.onion.pojo.user.Friend;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by OnionMac on 2018/2/8.
 */
@RequestMapping("friend")
public interface FriendServiceApi {

    @RequestMapping(value = "/getFriend/{id}",method = RequestMethod.GET)
    Friend findFriendById(@PathVariable("id") int id);

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    String find(@PathVariable("id") int id);

}
