package com.zhouxuan.manshop.home.model;

import android.util.Log;

import com.zhouxuan.manshop.home.bean.HomeBean;
import com.zhouxuan.manshop.utils.ApiServer;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 周旋
 * 2017/11/9  14:33
 */

public class UserModel implements Imodel {
    private OnFinish onFinish;

    public interface OnFinish{
        void OnFinishListener(HomeBean list);
    }
    public void setOnFinish(OnFinish finish){
        this.onFinish=finish;
    }
        @Override
        public void getJson(String url) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
            ApiServer apiService = retrofit.create(ApiServer.class);
            final Observable<HomeBean> home = apiService.getHome();
            home.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<HomeBean>() {
                        @Override
                        public void onCompleted() {
                        }
                        @Override
                        public void onError(Throwable e) {
                        }
                        @Override
                        public void onNext(HomeBean homeBean) {
                            Log.e("main","123123123"+homeBean.toString());
                            onFinish.OnFinishListener(homeBean);
                        }
                    });
        }
}
