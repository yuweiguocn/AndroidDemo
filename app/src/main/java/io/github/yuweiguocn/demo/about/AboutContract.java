package io.github.yuweiguocn.demo.about;


import io.github.yuweiguocn.demo.base.BasePresenter;
import io.github.yuweiguocn.demo.base.BaseView;
import io.github.yuweiguocn.demo.bean.About;

/**
 * Created by growth on 7/9/16.
 */
public interface AboutContract {
    interface Presenter extends BasePresenter {
        void loadData();
    }

    interface View extends BaseView<Presenter> {
        void onSucess(About about);
    }
}
