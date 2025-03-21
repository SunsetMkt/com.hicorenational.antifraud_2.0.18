package com.vivo.push.util;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: SharePreferenceManager.java */
/* renamed from: com.vivo.push.util.ad */
/* loaded from: classes2.dex */
public final class C3987ad extends C3992c {

    /* renamed from: b */
    private static C3987ad f14218b;

    /* renamed from: b */
    public static synchronized C3987ad m13198b() {
        C3987ad c3987ad;
        synchronized (C3987ad.class) {
            if (f14218b == null) {
                f14218b = new C3987ad();
            }
            c3987ad = f14218b;
        }
        return c3987ad;
    }

    /* renamed from: a */
    public final synchronized void m13200a(Context context) {
        if (this.f14239a == null) {
            this.f14239a = context;
            m13239a(context, "com.vivo.push_preferences");
        }
    }

    /* renamed from: c */
    public final byte[] m13201c() {
        byte[] m13199b = m13199b(m13246b("com.vivo.push.secure_cache_iv", ""));
        return (m13199b == null || m13199b.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : m13199b;
    }

    /* renamed from: d */
    public final byte[] m13202d() {
        byte[] m13199b = m13199b(m13246b("com.vivo.push.secure_cache_key", ""));
        return (m13199b == null || m13199b.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : m13199b;
    }

    /* renamed from: b */
    private static byte[] m13199b(String str) {
        int i2;
        byte[] bArr = null;
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 0) {
                bArr = new byte[split.length];
                i2 = split.length;
            } else {
                i2 = 0;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
        } catch (Exception e2) {
            C4010u.m13292a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
