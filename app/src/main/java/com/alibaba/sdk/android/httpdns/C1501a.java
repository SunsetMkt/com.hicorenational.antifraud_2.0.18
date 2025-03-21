package com.alibaba.sdk.android.httpdns;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.alibaba.sdk.android.httpdns.a */
/* loaded from: classes.dex */
class C1501a {

    /* renamed from: a */
    private static long f3837a;
    private static String sSecretKey;

    /* renamed from: a */
    static String m3414a(String str, String str2) {
        if (!C1525l.m3531b(str)) {
            return "";
        }
        try {
            return C1525l.m3530a(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sSecretKey + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    static boolean m3415a() {
        return !TextUtils.isEmpty(sSecretKey);
    }

    static String getTimestamp() {
        return String.valueOf((System.currentTimeMillis() / 1000) + f3837a + 600);
    }

    static void setAuthCurrentTime(long j2) {
        f3837a = j2 - (System.currentTimeMillis() / 1000);
    }

    static void setSecretKey(String str) {
        sSecretKey = str;
    }
}
