package com.onion.service.user.service;

import com.onion.pojo.HttpWrapper;
import com.onion.pojo.news.Tab;
import com.onion.pojo.news.TabNews;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by OnionMac on 2018/5/21.
 */
public interface NewsService {

    HttpWrapper<List<Tab>> getNewTabs(@NotNull String userId);

    HttpWrapper<List<TabNews>> getTabNews(@NotNull String userId, int newsType);
}
