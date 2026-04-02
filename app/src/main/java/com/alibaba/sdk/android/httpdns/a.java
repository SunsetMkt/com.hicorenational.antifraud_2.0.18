package com.alibaba.sdk.android.httpdns;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
class a {
    private static long a;
    private static String sSecretKey;

    static String a(String str, String str2) {
        if (!l.b(str)) {
            return "";
        }
        try {
            return l.a(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + sSecretKey + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
        } catch (Exception unused) {
            return "";
        }
    }

    static boolean a() {
        return !TextUtils.isEmpty(sSecretKey);
    }

    static String getTimestamp() {
        return String.valueOf((System.currentTimeMillis() / 1000) + a + 600);
    }

    static void setAuthCurrentTime(long j2) {
        a = j2 - (System.currentTimeMillis() / 1000);
    }

    static void setSecretKey(String str) {
        sSecretKey = str;
    }
}
