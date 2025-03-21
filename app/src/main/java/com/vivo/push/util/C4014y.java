package com.vivo.push.util;

import com.vivo.push.p232b.C3831c;

/* compiled from: OperateUtil.java */
/* renamed from: com.vivo.push.util.y */
/* loaded from: classes2.dex */
public final class C4014y {
    /* renamed from: a */
    public static int m13316a(C3831c c3831c) {
        C3987ad m13198b = C3987ad.m13198b();
        int m13325b = c3831c.m13325b();
        long currentTimeMillis = System.currentTimeMillis();
        int m13244b = m13198b.m13244b("com.vivo.push_preferences.operate." + m13325b + "OPERATE_COUNT", 0);
        long m13245b = currentTimeMillis - m13198b.m13245b("com.vivo.push_preferences.operate." + m13325b + "START_TIME", 0L);
        if (m13245b > 86400000 || m13245b < 0) {
            m13198b.m13242a("com.vivo.push_preferences.operate." + m13325b + "START_TIME", System.currentTimeMillis());
            m13198b.m13241a("com.vivo.push_preferences.operate." + m13325b + "OPERATE_COUNT", 1);
        } else {
            if (m13244b >= c3831c.m12840d()) {
                return 1001;
            }
            m13198b.m13241a("com.vivo.push_preferences.operate." + m13325b + "OPERATE_COUNT", m13244b + 1);
        }
        return 0;
    }
}
