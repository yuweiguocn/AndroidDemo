package io.github.yuweiguocn.dagger.login;

import dagger.Binds;
import dagger.Module;
import io.github.yuweiguocn.dagger.di.ActivityScope;

@Module
public abstract class LoginModule {

    @ActivityScope
    @Binds
    abstract LoginContract.Presenter bindPresenter(LoginPresenter presenter);
}
