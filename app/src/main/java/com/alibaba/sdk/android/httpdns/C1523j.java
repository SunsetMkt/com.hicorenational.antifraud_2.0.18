package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.alibaba.sdk.android.httpdns.j */
/* loaded from: classes.dex */
public class C1523j {

    /* renamed from: a */
    private static ScheduledExecutorService f3933a;

    /* renamed from: a */
    private static final ThreadFactory f3934a = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.j.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("httpdns worker");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new C1524k());
            return thread;
        }
    };

    /* renamed from: a */
    public static synchronized ScheduledExecutorService m3528a() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (C1523j.class) {
            if (f3933a == null) {
                f3933a = new ScheduledThreadPoolExecutor(1, f3934a);
            }
            scheduledExecutorService = f3933a;
        }
        return scheduledExecutorService;
    }
}
