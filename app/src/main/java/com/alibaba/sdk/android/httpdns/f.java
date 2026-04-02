package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.just.agentweb.DefaultWebClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static String f2573c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static String[] f19a = {"203.107.1.1"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String[] f2572b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    static final String[] f20c = new String[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String f2574d = "80";
    static String PROTOCOL = DefaultWebClient.HTTP_SCHEME;
    static int a = 15000;
    static Map<String, String> extra = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static List<IPProbeItem> f18a = null;

    static synchronized void a(List<IPProbeItem> list) {
        f18a = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static synchronized boolean a(String[] strArr) {
        boolean z;
        if (strArr != null) {
            if (strArr.length != 0) {
                f19a = strArr;
                i.d("serverIps:" + Arrays.toString(f19a));
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    static synchronized void c(String str) {
        f2573c = str;
    }

    static synchronized void clearSdnsGlobalParams() {
        extra.clear();
    }

    static synchronized void setHTTPSRequestEnabled(boolean z) {
        String str;
        if (z) {
            PROTOCOL = DefaultWebClient.HTTPS_SCHEME;
            str = "443";
        } else {
            PROTOCOL = DefaultWebClient.HTTP_SCHEME;
            str = "80";
        }
        f2574d = str;
    }

    static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        extra.putAll(map);
    }

    static synchronized void setTimeoutInterval(int i2) {
        if (i2 > 0) {
            a = i2;
        }
    }
}
