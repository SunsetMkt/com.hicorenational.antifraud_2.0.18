package com.umeng.message.proguard;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static String a;

    public static Uri a(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgAlias");
        return builder.build();
    }

    public static Uri b(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgAliasDeleteAll");
        return builder.build();
    }

    public static Uri c(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("sp");
        return builder.build();
    }

    public static Uri d(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgLogStores");
        return builder.build();
    }

    public static Uri e(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("InAppLogStores");
        return builder.build();
    }

    public static String f(Context context) {
        if (a == null) {
            a = context.getPackageName() + ".umeng.message";
        }
        return a;
    }
}
