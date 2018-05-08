package com.onion.service.friend.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient("user-service")
public interface UserApi extends com.onion.api.userapi.UserApi {

}
