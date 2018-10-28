package io.github.yuweiguocn.dagger.home;

import dagger.Binds;
import dagger.Module;
import io.github.yuweiguocn.dagger.di.ActivityScope;

@Module
public abstract class HomeModule {
    @ActivityScope
    @Binds
    abstract HomeContract.Presenter bindPresenter(HomePresenter presenter);
}
