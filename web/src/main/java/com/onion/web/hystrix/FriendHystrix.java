package com.onion.web.hystrix;

import com.onion.pojo.user.Friend;
import com.onion.web.api.FriendApi;

/**
 * Created by OnionMac on 2018/2/11.
 */
public class FriendHystrix implements FriendApi {

    @Override
    public Friend findFriendById(int id) {
        Friend friend = new Friend();
        friend.setId(222+id);
        return friend;
    }

    @Override
    public String find(int id) {
        return null;
    }
}
