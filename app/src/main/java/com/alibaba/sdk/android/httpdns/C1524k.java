package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import java.lang.Thread;

/* renamed from: com.alibaba.sdk.android.httpdns.k */
/* loaded from: classes.dex */
public class C1524k implements Thread.UncaughtExceptionHandler {
    /* renamed from: b */
    private void m3529b(Throwable th) {
        C1515b m3486a = C1515b.m3486a();
        if (m3486a != null) {
            m3486a.m3504k(th.getMessage());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String str = "Catch an uncaught exception, " + thread.getName() + ", error message: " + th.getMessage();
            m3529b(th);
            th.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
