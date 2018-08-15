package com.onion.service.user.service.impl;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.ReturnCode;
import com.onion.pojo.news.Tab;
import com.onion.pojo.news.TabNews;
import com.onion.service.user.mapper.NewsMapper;
import com.onion.service.user.service.NewsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OnionMac on 2018/5/21.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public HttpWrapper<List<Tab>> getNewTabs(@NotNull String userId) {
        HttpWrapper<List<Tab>> wrapper = new HttpWrapper<>();

        List<Tab> tab = newsMapper.findTabs();

        if(tab != null){
            wrapper.setCode(ReturnCode.SUCCESS);
            wrapper.setData(tab);
            wrapper.setInfo("请求成功");
            return wrapper;
        }

        wrapper.setCode(ReturnCode.SYSTEM_ERROR);
        wrapper.setInfo("系统错误");
        return wrapper;

    }

    @Override
    public HttpWrapper<List<TabNews>> getTabNews(@NotNull String userId, int newsType) {
        HttpWrapper<List<TabNews>> wrapper = new HttpWrapper<>();
        List<TabNews> list = newsMapper.findTabNews(newsType);
        wrapper.setData(list);

        List<Tab> list1 = new ArrayList<>();

        String[] mTitles = new String[list1.size()];
        for (int i = 0; i < mTitles.length; i++) {
            mTitles[i] = list1.get(i).getTypeName();
        }
        return wrapper;
    }
}
