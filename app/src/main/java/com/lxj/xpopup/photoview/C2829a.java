package com.lxj.xpopup.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* compiled from: Compat.java */
/* renamed from: com.lxj.xpopup.photoview.a */
/* loaded from: classes.dex */
class C2829a {

    /* renamed from: a */
    private static final int f8807a = 16;

    C2829a() {
    }

    /* renamed from: a */
    public static void m8504a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            m8505b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    /* renamed from: b */
    private static void m8505b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
