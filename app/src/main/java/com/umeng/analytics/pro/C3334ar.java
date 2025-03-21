package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMExecutor.java */
/* renamed from: com.umeng.analytics.pro.ar */
/* loaded from: classes2.dex */
public class C3334ar {

    /* renamed from: a */
    private static final String f11478a = "UMExecutor";

    /* renamed from: b */
    private static volatile ScheduledThreadPoolExecutor f11479b;

    /* renamed from: c */
    private static final ThreadFactory f11480c = new ThreadFactory() { // from class: com.umeng.analytics.pro.ar.1

        /* renamed from: a */
        private final AtomicInteger f11481a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f11481a.incrementAndGet());
        }
    };

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor m10860a() {
        if (f11479b == null) {
            synchronized (C3334ar.class) {
                if (f11479b == null) {
                    f11479b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f11480c);
                    f11479b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f11479b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11479b;
    }

    /* renamed from: a */
    public static void m10861a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            m10860a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
