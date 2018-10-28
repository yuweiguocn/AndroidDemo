package io.github.yuweiguocn.dagger.home;

import io.github.yuweiguocn.dagger.base.BasePresenter;
import io.github.yuweiguocn.dagger.base.BaseView;

public interface HomeContract {

    interface View extends BaseView{
        void logout();
    }


    interface Presenter extends BasePresenter<View> {
        void logout();
    }
}
