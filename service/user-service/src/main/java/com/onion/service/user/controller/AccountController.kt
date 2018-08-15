package com.onion.service.user.controller

import com.onion.pojo.HttpWrapper
import com.onion.pojo.user.User
import com.onion.service.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by OnionMac on 2018/5/18.
 */
@RestController
class AccountController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("account/register")
    fun register(user: User): HttpWrapper<User>{
        return userService.register(user)
    }

    @PostMapping("account/login")
    fun login(user: User): HttpWrapper<User>{
        return userService.login(user)
    }

}