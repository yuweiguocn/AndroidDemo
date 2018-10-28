package io.github.yuweiguocn.dagger.register;

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
import io.github.yuweiguocn.dagger.R;
import io.github.yuweiguocn.dagger.base.BaseActivity;
import io.github.yuweiguocn.dagger.home.HomeActivity;
import io.github.yuweiguocn.dagger.utils.TT;

public class RegisterActivity extends BaseActivity implements RegisterContract.View{

    @Inject
    RegisterContract.Presenter mPresenter;

    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.et_pwd)
    EditText et_pwd;

    @BindView(R.id.et_repwd)
    EditText et_repwd;

    @BindView(R.id.btn_register)
    Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.takeView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @OnTextChanged({R.id.et_name, R.id.et_pwd, R.id.et_repwd})
    public void textChanged() {
        if (TextUtils.isEmpty(et_name.getText().toString()) || TextUtils.isEmpty(et_pwd.getText().toString()) || TextUtils.isEmpty(et_repwd.getText().toString())) {
            btn_register.setEnabled(false);
        } else {
            btn_register.setEnabled(true);
        }
    }

    @OnClick(R.id.btn_register)
    public void register(){
        mPresenter.register(et_name.getText().toString(),et_pwd.getText().toString(),et_repwd.getText().toString());
    }

    @Override
    public void failed(String tips) {
        TT.s(tips);
    }

    @Override
    public void success() {
        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
    }
}
