package io.github.yuweiguocn.dagger.register;

import javax.inject.Inject;

import io.github.yuweiguocn.dagger.bean.LoginResult;
import io.github.yuweiguocn.dagger.bean.Result;
import io.github.yuweiguocn.dagger.net.Api;
import io.github.yuweiguocn.dagger.net.RetrofitManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;

    @Inject
    public RegisterPresenter() {
    }

    @Override
    public void takeView(RegisterContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void register(String name, String pwd, String repwd) {
        if (!pwd.equals(repwd)) {
            if (mView != null) {
                mView.failed("两次密码输入不一致");
            }
            return;
        }

        if (mView != null) {
            mView.showLoading();
        }
        RetrofitManager.create(Api.class).register(name, pwd,repwd)
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
                            mView.success();
                        } else {
                            mView.failed(loginResultResult.errorMsg);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (mView == null) {
                            return;
                        }
                        mView.hideLoading();
                        mView.failed("注册失败");
                    }
                });
    }
}
