package com.zhouxuan.manshop.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhouxuan.manshop.R;
import com.zhouxuan.manshop.mine.bean.User;
import com.zhouxuan.manshop.mine.bean.dengluBean;
import com.zhouxuan.manshop.mine.parsenter.UserPresenter;
import com.zhouxuan.manshop.mine.view.Iview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Denglu_yemian extends AppCompatActivity implements Iview {
    //初始化属性
    @BindView(R.id.btn_denglu)
    Button btnDenglu;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    private UserPresenter userPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu_yemian);
        ButterKnife.bind(this);
        userPresenter = new UserPresenter(this);

    }

    //登录按钮和注册的点击事件
    @OnClick({R.id.btn_denglu, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_denglu:
                String username = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                userPresenter.login(new User(username, password));

                break;
            case R.id.tv_register:
                Intent intent = new Intent(Denglu_yemian.this, Register_yemian.class);
                startActivity(intent);

                break;
        }
    }


    @Override
    public void onLoginSuccess() {
        Toast.makeText(getApplicationContext(), "登录成功:", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed(String error) {
        Toast.makeText(getApplicationContext(), "登录失败:" + error, Toast.LENGTH_SHORT).show();
    }
}
