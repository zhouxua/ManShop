package com.zhouxuan.manshop.utils;



import com.zhouxuan.manshop.home.bean.HomeBean;
import com.zhouxuan.manshop.mine.bean.dengluBean;
import com.zhouxuan.manshop.mine.bean.zhuceBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    @GET("/yunifang/mobile/home")
    Observable<HomeBean> getHome();

    @FormUrlEncoded
    @POST("user/login")
    Observable<dengluBean> login(@Field("mobile") String mobile, @Field("password") String password);

 @FormUrlEncoded
    @POST("user/reg")
    Observable<zhuceBean> logina(@Field("mobile") String mobile, @Field("password") String password);
}
