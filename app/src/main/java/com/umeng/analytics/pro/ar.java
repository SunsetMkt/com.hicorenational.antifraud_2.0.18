package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public class ar {
    private static final String a = "UMExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f7014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f7015c = new ThreadFactory() { // from class: com.umeng.analytics.pro.ar.1
        private final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f7014b == null) {
            synchronized (ar.class) {
                if (f7014b == null) {
                    f7014b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f7015c);
                    f7014b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f7014b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f7014b;
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
