package io.github.yuweiguocn.dagger.register;

import io.github.yuweiguocn.dagger.base.BasePresenter;
import io.github.yuweiguocn.dagger.base.BaseView;

public interface RegisterContract {

    interface View extends BaseView{
        void failed(String tips);
        void success();
    }


    interface Presenter extends BasePresenter<View> {
        void register(String name, String pwd, String repwd);
    }
}
