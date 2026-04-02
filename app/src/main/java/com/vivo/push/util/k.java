package com.vivo.push.util;

import android.os.Looper;

/* JADX INFO: compiled from: DebugUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static void a(String str) {
        if (u.b() && Looper.myLooper() == Looper.getMainLooper()) {
            String str2 = "Operation: " + str + " in main thread!";
            new Throwable();
        }
    }
}
