package com.onion.web.api;

import com.onion.api.friendapi.FriendServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient("friend-service")
public interface FriendApi extends FriendServiceApi{

}
