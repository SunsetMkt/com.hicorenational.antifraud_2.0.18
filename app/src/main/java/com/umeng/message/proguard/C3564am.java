package com.umeng.message.proguard;

import android.os.Build;

/* renamed from: com.umeng.message.proguard.am */
/* loaded from: classes2.dex */
public final class C3564am {
    /* renamed from: a */
    public static void m12269a(C3554ac c3554ac) {
        if (Build.VERSION.SDK_INT < 23 || c3554ac == null || c3554ac.f13151b == null) {
            return;
        }
        Object obj = c3554ac.f13152c;
        if (obj instanceof AbstractRunnableC3583c) {
            ((AbstractRunnableC3583c) obj).m12341c();
        }
        c3554ac.f13152c = null;
    }
}
