package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.just.agentweb.DefaultWebClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class f {

    /* renamed from: c, reason: collision with root package name */
    static String f4053c;

    /* renamed from: a, reason: collision with other field name */
    static String[] f19a = {"203.107.1.1"};

    /* renamed from: b, reason: collision with root package name */
    static final String[] f4052b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* renamed from: c, reason: collision with other field name */
    static final String[] f20c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    static String f4054d = "80";
    static String PROTOCOL = DefaultWebClient.HTTP_SCHEME;

    /* renamed from: a, reason: collision with root package name */
    static int f4051a = 15000;
    static Map<String, String> extra = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    static List<IPProbeItem> f18a = null;

    static synchronized void a(List<IPProbeItem> list) {
        synchronized (f.class) {
            f18a = list;
        }
    }

    static synchronized boolean a(String[] strArr) {
        boolean z;
        synchronized (f.class) {
            if (strArr != null) {
                if (strArr.length != 0) {
                    f19a = strArr;
                    i.d("serverIps:" + Arrays.toString(f19a));
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    static synchronized void c(String str) {
        synchronized (f.class) {
            f4053c = str;
        }
    }

    static synchronized void clearSdnsGlobalParams() {
        synchronized (f.class) {
            extra.clear();
        }
    }

    static synchronized void setHTTPSRequestEnabled(boolean z) {
        String str;
        synchronized (f.class) {
            if (z) {
                PROTOCOL = DefaultWebClient.HTTPS_SCHEME;
                str = "443";
            } else {
                PROTOCOL = DefaultWebClient.HTTP_SCHEME;
                str = "80";
            }
            f4054d = str;
        }
    }

    static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        synchronized (f.class) {
            extra.putAll(map);
        }
    }

    static synchronized void setTimeoutInterval(int i2) {
        synchronized (f.class) {
            if (i2 > 0) {
                f4051a = i2;
            }
        }
    }
}
