package com.onion.pojo.user;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by OnionMac on 2018/2/6.
 */
@Component
@ConfigurationProperties(prefix = "author")
public class Author {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
