package com.zhouxuan.manshop.mine.view;

/**
 * 周旋
 * 2017/11/13  18:33
 */

public interface Iview {
    /**
     * 登录成功
     */
    void onLoginSuccess();

    /**
     * 登录失败
     *
     * @param error
     */
    void onLoginFailed(String error);
}
