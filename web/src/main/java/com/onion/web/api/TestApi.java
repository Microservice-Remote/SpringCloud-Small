package com.onion.web.api;

import com.onion.pojo.City;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by zhangqi on 2018/2/26.
 */
public interface TestApi {

    /**
     * 得到城市
     * @return
     */
    @POST("loan/getCity.action")
    Call<City> getCity();

}
