package com.zhouxuan.manshop.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 周旋
 * 2017/11/9  14:21
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
