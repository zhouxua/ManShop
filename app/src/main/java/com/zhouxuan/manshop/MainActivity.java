package com.zhouxuan.manshop;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.zhouxuan.manshop.home.Fragmenter1;
import com.zhouxuan.manshop.sort.Fragmenter2;
import com.zhouxuan.manshop.cart.Fragmenter3;
import com.zhouxuan.manshop.mine.Fragmenter4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Fragmenter1 fragmenter1;
    Fragmenter2 fragmenter2;
    Fragmenter3 fragmenter3;
    Fragmenter4 fragmenter4;
    FragmentManager fm;

    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_sort)
    RadioButton radioSort;
    @BindView(R.id.radio_cart)
    RadioButton radioCart;
    @BindView(R.id.radio_mine)
    RadioButton radioMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toasty.error(MainActivity.this,"这是个错误提示", Toast.LENGTH_SHORT,true).show();
        fragmenter1 = new Fragmenter1();
        fragmenter2 = new Fragmenter2();
        fragmenter3 = new Fragmenter3();
        fragmenter4 = new Fragmenter4();
        fm = getSupportFragmentManager();
        //创建四个fragment页
        fm.beginTransaction().add(R.id.content, fragmenter1)
                .add(R.id.content, fragmenter2)
                .add(R.id.content, fragmenter3)
                .add(R.id.content, fragmenter4).commit();
       //默认显示第一个页面
        fm.beginTransaction().show(fragmenter1)
                .hide(fragmenter2).hide(fragmenter3).hide(fragmenter4).commit();
        radioHome.setChecked(true);

    }

    @OnClick({R.id.radio_home, R.id.radio_sort, R.id.radio_cart, R.id.radio_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_home:
                fm.beginTransaction().show(fragmenter1)
                        .hide(fragmenter2).hide(fragmenter3).hide(fragmenter4).commit();

                break;
            case R.id.radio_sort:
                fm.beginTransaction().show(fragmenter2)
                        .hide(fragmenter1).hide(fragmenter3).hide(fragmenter4).commit();

                break;
            case R.id.radio_cart:
                fm.beginTransaction().show(fragmenter3)
                        .hide(fragmenter2).hide(fragmenter1).hide(fragmenter4).commit();

                break;
            case R.id.radio_mine:
                fm.beginTransaction().show(fragmenter4)
                        .hide(fragmenter2).hide(fragmenter3).hide(fragmenter1).commit();

                break;
        }
    }
}
