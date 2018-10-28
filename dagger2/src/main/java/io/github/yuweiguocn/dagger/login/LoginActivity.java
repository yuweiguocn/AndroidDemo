package io.github.yuweiguocn.dagger.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import io.github.yuweiguocn.dagger.App;
import io.github.yuweiguocn.dagger.R;
import io.github.yuweiguocn.dagger.base.BaseActivity;
import io.github.yuweiguocn.dagger.home.HomeActivity;
import io.github.yuweiguocn.dagger.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @Inject
    LoginContract.Presenter mPresenter;

    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.takeView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @OnTextChanged({R.id.et_name, R.id.et_pwd})
    public void textChanged() {
        if (TextUtils.isEmpty(et_name.getText().toString()) || TextUtils.isEmpty(et_pwd.getText().toString())) {
            btn_login.setEnabled(false);
        } else {
            btn_login.setEnabled(true);
        }
    }


    @OnClick(R.id.btn_register)
    public void register(){
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @OnClick(R.id.btn_login)
    public void onClick(){
        mPresenter.login(et_name.getText().toString().trim(), et_pwd.getText().toString().trim());
    }

    @Override
    public void success(String tips) {
        super.success(tips);
        App.getApp().getSpUtil().setLogin(true);
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        finish();
    }
}
