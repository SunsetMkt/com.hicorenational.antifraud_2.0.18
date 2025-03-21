package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alibaba.sdk.android.httpdns.c */
/* loaded from: classes.dex */
public class C1511c {

    /* renamed from: a */
    private static final TimeUnit f3869a = TimeUnit.SECONDS;

    /* renamed from: a */
    private static final ThreadFactory f3868a = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.c.1
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
    private static final ExecutorService f3867a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, f3869a, new SynchronousQueue(), f3868a);

    /* renamed from: a */
    public static ExecutorService m3462a() {
        return f3867a;
    }
}
