package io.github.yuweiguocn.dagger.login;

import javax.inject.Inject;

import io.github.yuweiguocn.dagger.bean.LoginResult;
import io.github.yuweiguocn.dagger.bean.Result;
import io.github.yuweiguocn.dagger.net.Api;
import io.github.yuweiguocn.dagger.net.RetrofitManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void takeView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void login(String name, String pwd) {
        if (mView != null) {
            mView.showLoading();
        }
        RetrofitManager.create(Api.class).login(name, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result<LoginResult>>() {
                    @Override
                    public void accept(Result<LoginResult> loginResultResult) throws Exception {
                        if (mView == null) {
                            return;
                        }
                        mView.hideLoading();

                        if (loginResultResult.errorCode == 0) {
                            mView.success(null);
                        } else {
                            mView.fail(loginResultResult.errorMsg);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (mView == null) {
                            return;
                        }
                        mView.hideLoading();
                        mView.fail("登录失败");
                    }
                });

    }
}
