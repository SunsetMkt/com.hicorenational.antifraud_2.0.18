package com.alibaba.sdk.android.httpdns.p115e;

import com.alibaba.sdk.android.httpdns.p113c.C1512a;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Random;

/* renamed from: com.alibaba.sdk.android.httpdns.e.a */
/* loaded from: classes.dex */
public class C1518a {

    /* renamed from: t */
    private String f3918t;

    /* renamed from: com.alibaba.sdk.android.httpdns.e.a$a */
    private static final class a {

        /* renamed from: a */
        private static final C1518a f3919a = new C1518a();
    }

    private C1518a() {
        try {
            Random random = new Random();
            char[] cArr = new char[12];
            for (int i2 = 0; i2 < 12; i2++) {
                cArr[i2] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62));
            }
            this.f3918t = new String(cArr);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    /* renamed from: a */
    public static C1518a m3516a() {
        return a.f3919a;
    }

    public String getSessionId() {
        return this.f3918t;
    }

    /* renamed from: l */
    public String m3517l() {
        int networkType = C1512a.m3464a().getNetworkType();
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
