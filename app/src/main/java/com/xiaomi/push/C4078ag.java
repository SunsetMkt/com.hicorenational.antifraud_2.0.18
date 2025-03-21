package com.xiaomi.push;

import android.os.Looper;

/* renamed from: com.xiaomi.push.ag */
/* loaded from: classes2.dex */
public class C4078ag {
    /* renamed from: a */
    public static void m13726a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
