package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.r0 */
/* loaded from: classes.dex */
public class C2445r0 {

    /* renamed from: a */
    private static final int[] f7605a = {1, 6, 7, 9};

    /* renamed from: b */
    private static final int[] f7606b = {0, 2, 3, 4, 5};

    /* renamed from: c */
    private static final Map<Integer, String> f7607c = new a();

    /* renamed from: com.huawei.hms.hatool.r0$a */
    static class a extends HashMap<Integer, String> {
        a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            if (Build.VERSION.SDK_INT >= 29) {
                put(20, "5G");
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    private static NetworkInfo m7320a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            C2452v.m7382b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static String m7321a(int i2) {
        Map<Integer, String> map = f7607c;
        String str = map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)) : "unknown";
        return (!"unknown".equals(str) || Build.VERSION.SDK_INT < 25) ? str : i2 != 16 ? i2 != 17 ? "unknown" : "3G" : "2G";
    }

    /* renamed from: a */
    private static boolean m7322a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f7606b, networkInfo.getType()) == -1) ? false : true;
    }

    /* renamed from: b */
    public static String m7323b(Context context) {
        NetworkInfo m7320a;
        if (context == null) {
            return "unknown";
        }
        try {
            m7320a = m7320a(context);
        } catch (Throwable unused) {
        }
        if (!m7324b(m7320a)) {
            return "none";
        }
        if (m7325c(m7320a)) {
            return "WIFI";
        }
        if (m7322a(m7320a)) {
            return m7321a(m7320a.getSubtype());
        }
        return "unknown";
    }

    /* renamed from: b */
    private static boolean m7324b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: c */
    private static boolean m7325c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f7605a, networkInfo.getType()) == -1) ? false : true;
    }
}
