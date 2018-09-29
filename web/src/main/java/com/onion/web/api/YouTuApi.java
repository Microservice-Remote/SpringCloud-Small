package com.onion.web.api;

import com.onion.retrofit.api.annotation.ApiAnnotation;
import com.onion.retrofit.api.annotation.Parse;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * Created by zhangqi on 2018/8/23.
 */
@ApiAnnotation(baseUrl = "test",
        timeOut = {100,100,100},parseType = Parse.JSON,note = "悠兔")
public interface YouTuApi {

    /**
     * 开户注册
     * @return
     */
    @POST("loan/getCity.action")
    Call<String> getCity();

    /**
     * 用户还款
     * @return
     */
    @FormUrlEncoded
    @POST("interface/repayment")
    Call<String> repayment(@FieldMap Map<String, String> map);
}
