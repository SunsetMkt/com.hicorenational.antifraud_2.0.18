package com.alibaba.sdk.android.httpdns.p114d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alibaba.sdk.android.httpdns.d.a */
/* loaded from: classes.dex */
final class C1514a {

    /* renamed from: b */
    private ExecutorService f3878b;

    /* renamed from: b */
    private final ThreadFactory f3879b = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.d.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "report_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    C1514a() {
    }

    /* renamed from: b */
    synchronized ExecutorService m3485b() {
        if (this.f3878b == null) {
            this.f3878b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f3879b);
        }
        return this.f3878b;
    }
}
