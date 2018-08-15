package com.onion.service.user.controller

import com.onion.pojo.HttpWrapper
import com.onion.pojo.news.Tab
import com.onion.pojo.news.TabNews
import com.onion.service.user.service.NewsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by OnionMac on 2018/5/18.
 */
@RestController
class NewsController {

    @Autowired
    lateinit var newsService: NewsService

    @GetMapping("news/tab")
    fun register(userId: String): HttpWrapper<List<Tab>>{
        return newsService.getNewTabs(userId)
    }

    @PostMapping("news/tabnews")
    fun register(userId: String,newsType: Int): HttpWrapper<List<TabNews>>{
        return newsService.getTabNews(userId,newsType)
    }
}