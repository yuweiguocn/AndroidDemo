package io.github.yuweiguocn.dagger.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.DaggerActivity;
import io.github.yuweiguocn.dagger.utils.DialogUtils;
import io.github.yuweiguocn.dagger.utils.TT;

public abstract class BaseActivity extends DaggerActivity implements BaseView{

    protected Dialog loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        loading = DialogUtils.getNewLoadingDialog(this);
    }

    @Override
    public void fail(String tips) {
        TT.s(tips);
    }

    @Override
    public void success(String tips) {
        TT.s(tips);
    }

    @Override
    public void showLoading(){
        if (loading != null) {
            loading.show();
        }
    }

    @Override
    public void hideLoading(){
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
    }

    protected abstract int getLayoutId();
}


