package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.huawei.secure.android.common.util.c */
/* loaded from: classes.dex */
public class C2571c {

    /* renamed from: a */
    private static Handler f8300a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m8073a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f8300a.post(runnable);
    }
}
