package com.onion.service.user.mapper;

import com.onion.pojo.news.Tab;
import com.onion.pojo.news.TabNews;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OnionMac on 2018/5/21.
 */
@Repository
public interface NewsMapper {

    List<Tab> findTabs();

    List<TabNews> findTabNews(@Param("newsType") int newsType);
}
