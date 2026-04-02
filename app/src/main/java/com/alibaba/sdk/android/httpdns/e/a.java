package com.alibaba.sdk.android.httpdns.e;

import com.taobao.accs.utl.UtilityImpl;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private String t;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.e.a$a, reason: collision with other inner class name */
    private static final class C0041a {
        private static final a a = new a();
    }

    private a() {
        try {
            Random random = new Random();
            char[] cArr = new char[12];
            for (int i2 = 0; i2 < 12; i2++) {
                cArr[i2] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62));
            }
            this.t = new String(cArr);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static a a() {
        return C0041a.a;
    }

    public String getSessionId() {
        return this.t;
    }

    public String l() {
        int networkType = com.alibaba.sdk.android.httpdns.c.a.a().getNetworkType();
        if (networkType != 0) {
            if (networkType == 1) {
                return UtilityImpl.NET_TYPE_WIFI;
            }
            if (networkType == 2) {
                return UtilityImpl.NET_TYPE_2G;
            }
            if (networkType == 3) {
                return UtilityImpl.NET_TYPE_3G;
            }
            if (networkType == 4) {
                return UtilityImpl.NET_TYPE_4G;
            }
            if (networkType != 255) {
                return "unknown";
            }
        }
        return "unknown";
    }
}
