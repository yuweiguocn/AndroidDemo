package io.github.yuweiguocn.dagger.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;


    public SPUtil(Context context, String file) {
		sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	public void setLogin(boolean login){
        editor.putBoolean("login", login);
        editor.commit();
    }

    public boolean isLogin(){
        return sp.getBoolean("login", false);
    }


}
