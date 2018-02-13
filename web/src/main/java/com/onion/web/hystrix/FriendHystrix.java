package com.onion.web.hystrix;

import com.onion.pojo.user.Friend;
import com.onion.web.api.FriendApi;
import org.springframework.stereotype.Component;

/**
 * Created by OnionMac on 2018/2/11.
 */
@Component
public class FriendHystrix implements FriendApi{

    @Override
    public Friend findFriendById(int id){

        return new Friend();
    }

    @Override
    public String find(int id)
    {
        return "1";
    }
}
