package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ao */
/* loaded from: classes2.dex */
public class C3152ao {

    /* renamed from: a */
    private static Proxy f10573a;

    /* renamed from: a */
    public static void m9926a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f10573a = null;
        } else {
            f10573a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    /* renamed from: a */
    public static void m9927a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f10573a = null;
        } else {
            f10573a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    /* renamed from: a */
    public static Proxy m9925a() {
        return f10573a;
    }
}
