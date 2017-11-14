package com.zhouxuan.manshop.home.parsenter;

import android.util.Log;

import com.zhouxuan.manshop.home.bean.HomeBean;
import com.zhouxuan.manshop.home.model.Imodel;
import com.zhouxuan.manshop.home.model.UserModel;
import com.zhouxuan.manshop.home.view.Iview;

/**
 * 周旋
 * 2017/11/9  14:40
 */

public class Iparsenter implements UserModel.OnFinish {
    private final Iview iview;
    private final UserModel userModel;

    public Iparsenter(Iview iview) {
        this.iview = iview;
        userModel = new UserModel();
        userModel.setOnFinish(this);
    }
   public void setNews(String url){
       userModel.getJson(url);
       Log.e("main","123123123123123123123"+url);
   }
    @Override
    public void OnFinishListener(HomeBean homeData) {
        Log.e("main","123123123123123123123"+homeData.toString()+"123");
    iview.getData(homeData);

    }
}
