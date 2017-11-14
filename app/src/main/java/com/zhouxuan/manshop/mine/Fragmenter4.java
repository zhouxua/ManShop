package com.zhouxuan.manshop.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhouxuan.manshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 周旋
 * 2017/11/9  13:12
 */

public class Fragmenter4 extends Fragment {
    //初始化
    @BindView(R.id.login)
    ImageView login;
    Unbinder unbinder;
   //mine页面
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragmenter_mine, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    //销毁视图
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
     //点击图片登录
    @OnClick(R.id.login)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), Denglu_yemian.class);
        startActivity(intent);

    }
}
