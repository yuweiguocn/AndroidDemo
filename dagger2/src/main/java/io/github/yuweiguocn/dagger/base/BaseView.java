package io.github.yuweiguocn.dagger.base;

public interface BaseView {

    void fail(String tips);

    void success(String tips);

    void showLoading();

    void hideLoading();
}
