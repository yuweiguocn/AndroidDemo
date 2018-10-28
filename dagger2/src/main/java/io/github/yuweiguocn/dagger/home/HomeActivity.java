package io.github.yuweiguocn.dagger.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.OnClick;
import io.github.yuweiguocn.dagger.R;
import io.github.yuweiguocn.dagger.base.BaseActivity;
import io.github.yuweiguocn.dagger.login.LoginActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View{

    @Inject
    HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.btn_logout)
    public void onClick(){
        mPresenter.logout();
    }

    @Override
    public void logout() {
        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        finish();
    }
}
