package com.huawei.hms.framework.network.grs.p178h;

import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.framework.network.grs.h.e */
/* loaded from: classes.dex */
public class C2386e {

    /* renamed from: a */
    private static final String f7445a = "e";

    /* renamed from: a */
    public static boolean m6984a(Long l2) {
        if (l2 == null) {
            Logger.m6801v(f7445a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
        } catch (NumberFormatException unused) {
            Logger.m6801v(f7445a, "isSpExpire spValue NumberFormatException.");
        }
        if (l2.longValue() - System.currentTimeMillis() >= 0) {
            Logger.m6799i(f7445a, "isSpExpire false.");
            return false;
        }
        Logger.m6799i(f7445a, "isSpExpire true.");
        return true;
    }

    /* renamed from: a */
    public static boolean m6985a(Long l2, long j2) {
        if (l2 == null) {
            Logger.m6801v(f7445a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l2.longValue() - (System.currentTimeMillis() + j2) >= 0) {
                Logger.m6801v(f7445a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.m6801v(f7445a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
