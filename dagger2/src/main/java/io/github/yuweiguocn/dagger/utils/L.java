package io.github.yuweiguocn.dagger.utils;


import android.text.TextUtils;

import com.orhanobut.logger.Logger;


/**
 * 引用新的L日志输出
 *
 */

public class L {


    private L(){}
    /**
     * 是否把Log信息输出到Android日志控制台
     */
    public static boolean IS_OUTPUT_ANDROIDLOG = true;
    private static final String TAG = "ywg";
    /**
     * Send a DEBUG log message.
     *
     * @param msg
     */
    public static void d(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.d(msg);
        }
    }

    public static void d(String tag, String msg) {
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.d(msg);
        }
    }


    public static void i(String tag, String msg) {
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.i(msg);
        }
    }

    public static void w(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.w(msg);
        }
    }

    public static void w(String tag, String msg) {
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.w(msg);
        }
    }


    public static void e(Throwable tr) {
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.e(tr, tr.getMessage());
        }
    }

    public static void e(String tag, String msg) {
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return;
        }
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.e(msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.e(tr,msg);
        }
    }

    public static void v(String tag, String msg) {
        if (IS_OUTPUT_ANDROIDLOG) {
            Logger.t(tag);
            Logger.v(msg);
        }
    }

}
