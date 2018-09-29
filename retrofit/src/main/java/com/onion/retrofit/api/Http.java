package com.onion.retrofit.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangqi on 2018/9/21.
 */
@Component
@ConfigurationProperties(prefix = "retrofit")
@Setter
@Getter
public class Http {

    private Map<String,String> baseUrl;

}
