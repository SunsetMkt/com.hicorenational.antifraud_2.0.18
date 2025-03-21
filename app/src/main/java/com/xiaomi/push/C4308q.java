package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.q */
/* loaded from: classes2.dex */
public class C4308q {
    /* renamed from: a */
    public static String m15713a(String str, String str2) {
        try {
            return (String) C4309r.m15716a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("SystemProperties.get: " + e2);
            return str2;
        }
    }
}
