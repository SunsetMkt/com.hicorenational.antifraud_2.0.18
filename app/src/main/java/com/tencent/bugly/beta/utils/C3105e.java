package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.e */
/* loaded from: classes2.dex */
public class C3105e {

    /* renamed from: a */
    private static Handler f10075a;

    /* renamed from: a */
    private static Handler m9460a() {
        if (f10075a == null && Looper.getMainLooper() != null) {
            f10075a = new Handler(Looper.getMainLooper());
        }
        return f10075a;
    }

    /* renamed from: b */
    public static void m9463b(Runnable runnable) {
        if (m9460a() != null) {
            f10075a.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    public static void m9461a(Runnable runnable) {
        if (m9460a() != null) {
            f10075a.post(runnable);
        }
    }

    /* renamed from: a */
    public static void m9462a(Runnable runnable, long j2) {
        if (m9460a() != null) {
            f10075a.postDelayed(runnable, j2);
        }
    }
}
