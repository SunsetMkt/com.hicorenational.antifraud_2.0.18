package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.p194b.C2923a;
import java.util.List;

/* renamed from: com.sina.weibo.sdk.a */
/* loaded from: classes.dex */
public final class C2906a {

    /* renamed from: a */
    private static boolean f9260a = false;

    /* renamed from: b */
    private static AuthInfo f9261b;

    /* renamed from: a */
    public static void m8802a(AuthInfo authInfo, SdkListener sdkListener) {
        if (f9260a) {
            return;
        }
        if (authInfo == null) {
            throw new RuntimeException("authInfo must not be null.");
        }
        f9261b = authInfo;
        f9260a = true;
        if (sdkListener != null) {
            sdkListener.onInitSuccess();
        }
    }

    /* renamed from: b */
    public static boolean m8804b(Context context) {
        C2923a.a m8826e;
        return m8803a(context) && (m8826e = C2923a.m8826e(context)) != null && m8826e.f9302ah >= 10772;
    }

    /* renamed from: a */
    public static boolean m8803a(Context context) {
        List<ResolveInfo> queryIntentServices;
        String[] strArr = {BuildConfig.APPLICATION_ID, "com.sina.weibog3"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static AuthInfo m8801a() {
        if (f9260a) {
            return f9261b;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}
