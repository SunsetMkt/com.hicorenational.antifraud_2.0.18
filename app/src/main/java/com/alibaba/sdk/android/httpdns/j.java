package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class j {
    private static ScheduledExecutorService a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ThreadFactory f22a = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.j.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("httpdns worker");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new k());
            return thread;
        }
    };

    public static synchronized ScheduledExecutorService a() {
        if (a == null) {
            a = new ScheduledThreadPoolExecutor(1, f22a);
        }
        return a;
    }
}
