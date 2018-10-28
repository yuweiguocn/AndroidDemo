package io.github.yuweiguocn.dagger.base;

public interface BasePresenter<T>{


    void takeView(T view);

    void dropView();
}
