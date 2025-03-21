package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.just.agentweb.DefaultWebClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.sdk.android.httpdns.f */
/* loaded from: classes.dex */
class C1519f {

    /* renamed from: c */
    static String f3924c;

    /* renamed from: a */
    static String[] f3922a = {"203.107.1.1"};

    /* renamed from: b */
    static final String[] f3923b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* renamed from: c */
    static final String[] f3925c = new String[0];

    /* renamed from: d */
    static String f3926d = "80";
    static String PROTOCOL = DefaultWebClient.HTTP_SCHEME;

    /* renamed from: a */
    static int f3920a = 15000;
    static Map<String, String> extra = new HashMap();

    /* renamed from: a */
    static List<IPProbeItem> f3921a = null;

    /* renamed from: a */
    static synchronized void m3519a(List<IPProbeItem> list) {
        synchronized (C1519f.class) {
            f3921a = list;
        }
    }

    /* renamed from: a */
    static synchronized boolean m3520a(String[] strArr) {
        boolean z;
        synchronized (C1519f.class) {
            if (strArr != null) {
                if (strArr.length != 0) {
                    f3922a = strArr;
                    C1522i.m3525d("serverIps:" + Arrays.toString(f3922a));
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    static synchronized void m3521c(String str) {
        synchronized (C1519f.class) {
            f3924c = str;
        }
    }

    static synchronized void clearSdnsGlobalParams() {
        synchronized (C1519f.class) {
            extra.clear();
        }
    }

    static synchronized void setHTTPSRequestEnabled(boolean z) {
        String str;
        synchronized (C1519f.class) {
            if (z) {
                PROTOCOL = DefaultWebClient.HTTPS_SCHEME;
                str = "443";
            } else {
                PROTOCOL = DefaultWebClient.HTTP_SCHEME;
                str = "80";
            }
            f3926d = str;
        }
    }

    static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        synchronized (C1519f.class) {
            extra.putAll(map);
        }
    }

    static synchronized void setTimeoutInterval(int i2) {
        synchronized (C1519f.class) {
            if (i2 > 0) {
                f3920a = i2;
            }
        }
    }
}
