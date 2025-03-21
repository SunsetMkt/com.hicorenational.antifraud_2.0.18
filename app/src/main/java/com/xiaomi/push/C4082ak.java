package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.ak */
/* loaded from: classes2.dex */
class C4082ak {

    /* renamed from: a */
    private static volatile boolean f14531a = false;

    /* renamed from: a */
    private static void m13750a(Class<?> cls, Context context) {
        if (f14531a) {
            return;
        }
        try {
            f14531a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            AbstractC4022b.m13347a("mdid:load lib error " + th);
        }
    }

    /* renamed from: a */
    public static boolean m13751a(Context context) {
        try {
            Class<?> m15716a = C4309r.m15716a(context, "com.bun.miitmdid.core.JLibrary");
            if (m15716a == null) {
                return false;
            }
            m13750a(m15716a, context);
            return true;
        } catch (Throwable th) {
            AbstractC4022b.m13347a("mdid:check error " + th);
            return false;
        }
    }
}
