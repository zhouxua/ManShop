package com.zhouxuan.manshop.mine.model;

import android.util.Log;

import com.zhouxuan.manshop.mine.bean.User;
import com.zhouxuan.manshop.mine.bean.dengluBean;
import com.zhouxuan.manshop.mine.bean.zhuceBean;
import com.zhouxuan.manshop.mine.parsenter.ZuserPresenter;
import com.zhouxuan.manshop.utils.Api;
import com.zhouxuan.manshop.utils.ApiServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 周旋
 * 2017/11/13  20:26
 */

public class ZuserModel implements zmodel {
    private ZuserModel.OnFinish onFinish;

    public interface OnFinish{
        void OnFinishListener(zhuceBean zhuceBean);
    }
    public void setOnFinish(ZuserPresenter finish){
        this.onFinish=finish;
    }
    @Override
    public void login(User user) {
//        if (dengluBean.getCode().equals("0")){
//            return "true";
//        }else{
//            return "false";
//        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.DENGLU_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiService = retrofit.create(ApiServer.class);
//        Map<String ,String> map = new HashMap<>();
//        map.put("mobile",user.getMobile());
//        map.put("password",user.getPassword());
        Observable<zhuceBean> home = apiService.logina(user.getMobile(),user.getPassword());
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<zhuceBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(zhuceBean zhuceBean) {

                        onFinish.OnFinishListener(zhuceBean);

                    }
                });
    }
}
