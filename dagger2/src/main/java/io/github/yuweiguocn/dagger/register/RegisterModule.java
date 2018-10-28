package io.github.yuweiguocn.dagger.register;

import dagger.Binds;
import dagger.Module;
import io.github.yuweiguocn.dagger.di.ActivityScope;

@Module
public abstract class RegisterModule {

    @ActivityScope
    @Binds
    abstract RegisterContract.Presenter bindPresenter(RegisterPresenter presenter);
}
