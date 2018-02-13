package com.onion.web.hystrix;

import com.onion.pojo.user.Friend;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by OnionMac on 2018/2/11.
 */
public class FriendHystrix {

    Friend findFriendById(@PathVariable("id") int id){
        return new Friend();
    }

    String find(@PathVariable("id") int id)
    {
        return "1";
    }
}
