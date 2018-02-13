package com.onion.service.friend.api;

import com.onion.api.userapi.UserServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by OnionMac on 2018/2/8.
 */
@FeignClient("user-service")
public interface UserApi extends UserServiceApi{

}
