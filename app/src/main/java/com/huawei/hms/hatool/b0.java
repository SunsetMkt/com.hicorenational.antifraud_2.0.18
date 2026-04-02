package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b0 f4699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b0 f4700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b0 f4701d;
    private ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, com.heytap.mcssdk.constant.a.f3868d, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    private static class a implements Runnable {
        private Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    static class b implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f4702d = new AtomicInteger(1);
        private final ThreadGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f4703b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4704c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f4704c = "FormalHASDK-base-" + f4702d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.a, runnable, this.f4704c + this.f4703b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        f4699b = new b0();
        f4700c = new b0();
        f4701d = new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f4701d;
    }

    public static b0 b() {
        return f4700c;
    }

    public static b0 c() {
        return f4699b;
    }

    public void a(g gVar) {
        try {
            this.a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
