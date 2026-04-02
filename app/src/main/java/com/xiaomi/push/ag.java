package com.xiaomi.push;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class ag {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
