package io.github.yuweiguocn.dagger.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.yuweiguocn.dagger.home.HomeActivity;
import io.github.yuweiguocn.dagger.home.HomeModule;
import io.github.yuweiguocn.dagger.login.LoginActivity;
import io.github.yuweiguocn.dagger.login.LoginModule;
import io.github.yuweiguocn.dagger.register.RegisterActivity;
import io.github.yuweiguocn.dagger.register.RegisterModule;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity contributeLoginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity contributeRegisterActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity contributeHomeActivity();

}
