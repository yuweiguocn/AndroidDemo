package io.github.yuweiguocn.dagger.utils;

import android.app.Activity;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import io.github.yuweiguocn.dagger.R;

/**
 * Created by growth on 3/10/16.
 */
public class DialogUtils {
    private DialogUtils(){}

    public static Dialog getNewLoadingDialog(Activity context) {
        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        int screenW = getScreenWidth(context);
        lp.width = (int) (0.6 * screenW);
        return dialog;
    }


    public static int getScreenWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
