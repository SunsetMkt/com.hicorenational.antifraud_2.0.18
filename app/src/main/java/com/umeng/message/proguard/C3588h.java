package com.umeng.message.proguard;

import android.content.Context;
import android.net.Uri;

/* renamed from: com.umeng.message.proguard.h */
/* loaded from: classes2.dex */
public final class C3588h {

    /* renamed from: a */
    private static String f13283a;

    /* renamed from: a */
    public static Uri m12402a(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(m12407f(context));
        builder.path("MsgAlias");
        return builder.build();
    }

    /* renamed from: b */
    public static Uri m12403b(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(m12407f(context));
        builder.path("MsgAliasDeleteAll");
        return builder.build();
    }

    /* renamed from: c */
    public static Uri m12404c(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(m12407f(context));
        builder.path("sp");
        return builder.build();
    }

    /* renamed from: d */
    public static Uri m12405d(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(m12407f(context));
        builder.path("MsgLogStores");
        return builder.build();
    }

    /* renamed from: e */
    public static Uri m12406e(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(m12407f(context));
        builder.path("InAppLogStores");
        return builder.build();
    }

    /* renamed from: f */
    public static String m12407f(Context context) {
        if (f13283a == null) {
            f13283a = context.getPackageName() + ".umeng.message";
        }
        return f13283a;
    }
}
