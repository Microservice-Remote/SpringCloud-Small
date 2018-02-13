package com.onion.web.api;

import com.onion.api.friendapi.FriendServiceApi;
import com.onion.web.hystrix.FriendHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient(value = "friend-service",fallback = FriendHystrix.class)
public interface FriendApi extends FriendServiceApi{

}
