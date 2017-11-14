package com.zhouxuan.manshop.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhouxuan.manshop.R;
import com.zhouxuan.manshop.mine.bean.User;
import com.zhouxuan.manshop.mine.parsenter.ZuserPresenter;
import com.zhouxuan.manshop.mine.view.zview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register_yemian extends AppCompatActivity implements zview {
    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_denglu)
    Button btnDenglu;
    private ZuserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_yemian);
        ButterKnife.bind(this);
        userPresenter = new ZuserPresenter(this);
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getApplicationContext(), "注册成功:", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onLoginFailed(String error) {
        Toast.makeText(getApplicationContext(), "注册失败:", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_denglu)
    public void onViewClicked() {
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        userPresenter.login(new User(username, password));
    }
}
