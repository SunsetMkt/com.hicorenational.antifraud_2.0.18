package com.vivo.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetUtils.java */
/* renamed from: com.vivo.push.util.x */
/* loaded from: classes2.dex */
public final class C4013x {
    /* renamed from: a */
    public static NetworkInfo m13315a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            C4010u.m13294a("NetUtils", e2);
            return null;
        }
    }
}
