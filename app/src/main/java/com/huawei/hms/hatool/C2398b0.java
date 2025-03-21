package com.huawei.hms.hatool;

import com.heytap.mcssdk.constant.C2084a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.hatool.b0 */
/* loaded from: classes.dex */
public class C2398b0 {

    /* renamed from: b */
    private static C2398b0 f7469b;

    /* renamed from: c */
    private static C2398b0 f7470c;

    /* renamed from: d */
    private static C2398b0 f7471d;

    /* renamed from: a */
    private ThreadPoolExecutor f7472a = new ThreadPoolExecutor(0, 1, C2084a.f6122d, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* renamed from: com.huawei.hms.hatool.b0$a */
    private static class a implements Runnable {

        /* renamed from: a */
        private Runnable f7473a;

        public a(Runnable runnable) {
            this.f7473a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f7473a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    C2452v.m7389e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.hatool.b0$b */
    static class b implements ThreadFactory {

        /* renamed from: d */
        private static final AtomicInteger f7474d = new AtomicInteger(1);

        /* renamed from: a */
        private final ThreadGroup f7475a;

        /* renamed from: b */
        private final AtomicInteger f7476b = new AtomicInteger(1);

        /* renamed from: c */
        private final String f7477c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f7475a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f7477c = "FormalHASDK-base-" + f7474d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f7475a, runnable, this.f7477c + this.f7476b.getAndIncrement(), 0L);
        }
    }

    static {
        new C2398b0();
        new C2398b0();
        f7469b = new C2398b0();
        f7470c = new C2398b0();
        f7471d = new C2398b0();
    }

    private C2398b0() {
    }

    /* renamed from: a */
    public static C2398b0 m7040a() {
        return f7471d;
    }

    /* renamed from: b */
    public static C2398b0 m7041b() {
        return f7470c;
    }

    /* renamed from: c */
    public static C2398b0 m7042c() {
        return f7469b;
    }

    /* renamed from: a */
    public void m7043a(InterfaceRunnableC2412g interfaceRunnableC2412g) {
        try {
            this.f7472a.execute(new a(interfaceRunnableC2412g));
        } catch (RejectedExecutionException unused) {
            C2452v.m7389e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
