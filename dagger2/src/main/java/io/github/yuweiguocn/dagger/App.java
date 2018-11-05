package io.github.yuweiguocn.dagger;

import android.app.Activity;
import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.yuweiguocn.dagger.di.DaggerAppComponent;
import io.github.yuweiguocn.dagger.utils.SPUtil;

public class App extends DaggerApplication {

    private static App app;
    private SPUtil spUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        spUtil=new SPUtil(this,"dagger2");
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.create();
    }

    public SPUtil getSpUtil() {
        return spUtil;
    }

    public static App getApp() {
        return app;
    }

}
