package io.github.yuweiguocn.dagger.home;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import javax.inject.Inject;

import io.github.yuweiguocn.dagger.App;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void takeView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void logout() {
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getApp()));
        cookieJar.clear();
        App.getApp().getSpUtil().setLogin(false);
        if (mView != null) {
            mView.logout();
        }
    }
}
