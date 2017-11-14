package com.zhouxuan.manshop.mine.parsenter;

import com.zhouxuan.manshop.mine.bean.User;
import com.zhouxuan.manshop.mine.bean.dengluBean;
import com.zhouxuan.manshop.mine.bean.zhuceBean;
import com.zhouxuan.manshop.mine.model.ZuserModel;
import com.zhouxuan.manshop.mine.view.zview;

/**
 * 周旋
 * 2017/11/13  20:27
 */

public class ZuserPresenter implements ZuserModel.OnFinish{
    private final zview userView;
    private final ZuserModel userMode;

    public ZuserPresenter(zview iview) {
        this.userView = iview;
        this.userMode = new ZuserModel();
        userMode.setOnFinish(this);
    }
    public void login(final User user) {
        userMode.login(user);
    }

    @Override
    public void OnFinishListener(zhuceBean zhuceBean) {
        String code = zhuceBean.getCode();
        if (code.equals("0")) {
            userView.onLoginSuccess();
        } else {
            userView.onLoginFailed("请求失败");

        }
    }
}
