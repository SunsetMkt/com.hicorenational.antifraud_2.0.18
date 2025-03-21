package com.vivo.push.util;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: SharePreferenceManager.java */
/* loaded from: classes2.dex */
public final class ad extends c {

    /* renamed from: b, reason: collision with root package name */
    private static ad f12239b;

    public static synchronized ad b() {
        ad adVar;
        synchronized (ad.class) {
            if (f12239b == null) {
                f12239b = new ad();
            }
            adVar = f12239b;
        }
        return adVar;
    }

    public final synchronized void a(Context context) {
        if (this.f12260a == null) {
            this.f12260a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] b2 = b(b("com.vivo.push.secure_cache_iv", ""));
        return (b2 == null || b2.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : b2;
    }

    public final byte[] d() {
        byte[] b2 = b(b("com.vivo.push.secure_cache_key", ""));
        return (b2 == null || b2.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : b2;
    }

    private static byte[] b(String str) {
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
            u.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
