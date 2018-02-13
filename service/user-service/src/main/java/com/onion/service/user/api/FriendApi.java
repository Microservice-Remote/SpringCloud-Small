package com.onion.service.user.api;

import com.onion.api.friendapi.FriendServiceApi;
import com.onion.service.user.FeignLogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient(value = "friend-service",configuration = FeignLogConfiguration.class)
public interface FriendApi extends FriendServiceApi{

}
