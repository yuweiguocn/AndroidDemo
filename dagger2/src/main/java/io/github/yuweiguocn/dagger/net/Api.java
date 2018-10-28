package io.github.yuweiguocn.dagger.net;

import io.github.yuweiguocn.dagger.bean.LoginResult;
import io.github.yuweiguocn.dagger.bean.Result;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    public String BASE_URL = "http://wanandroid.com/";

    @POST("/user/login")
    @FormUrlEncoded
    Observable<Result<LoginResult>> login(@Field("username") String username, @Field("password") String pwd);


    @POST("/user/register")
    @FormUrlEncoded
    Observable<Result<LoginResult>> register(@Field("username") String username, @Field("password") String pwd,@Field("repassword") String repwd);

}
