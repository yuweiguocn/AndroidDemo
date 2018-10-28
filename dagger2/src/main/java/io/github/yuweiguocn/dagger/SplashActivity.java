package io.github.yuweiguocn.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.github.yuweiguocn.dagger.home.HomeActivity;
import io.github.yuweiguocn.dagger.login.LoginActivity;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Observable.just(1).delay(3,TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        home();
                    }
                });
    }

    private void home(){
        if (App.getApp().getSpUtil().isLogin()) {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();

    }

}
