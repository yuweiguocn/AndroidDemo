package io.github.yuweiguocn.dagger.login;

import io.github.yuweiguocn.dagger.base.BasePresenter;
import io.github.yuweiguocn.dagger.base.BaseView;

public interface LoginContract {

    interface View extends BaseView{
    }


    interface Presenter extends BasePresenter<View> {
        void login(String name, String pwd);
    }
}
