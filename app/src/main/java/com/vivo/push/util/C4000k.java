package com.vivo.push.util;

import android.os.Looper;

/* compiled from: DebugUtil.java */
/* renamed from: com.vivo.push.util.k */
/* loaded from: classes2.dex */
public final class C4000k {
    /* renamed from: a */
    public static void m13261a(String str) {
        if (C4010u.m13305b() && Looper.myLooper() == Looper.getMainLooper()) {
            String str2 = "Operation: " + str + " in main thread!";
            new Throwable();
        }
    }
}
