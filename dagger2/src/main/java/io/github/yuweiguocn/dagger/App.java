package io.github.yuweiguocn.dagger;

import android.app.Activity;
import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.github.yuweiguocn.dagger.di.DaggerAppComponent;
import io.github.yuweiguocn.dagger.utils.SPUtil;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    private static App app;
    private SPUtil spUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        spUtil=new SPUtil(this,"dagger2");
        Logger.addLogAdapter(new AndroidLogAdapter());
        DaggerAppComponent.create().inject(this);
    }

    public SPUtil getSpUtil() {
        return spUtil;
    }

    public static App getApp() {
        return app;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
