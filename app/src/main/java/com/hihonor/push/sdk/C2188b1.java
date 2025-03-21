package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.hihonor.push.sdk.b1 */
/* loaded from: classes.dex */
public final class C2188b1 {

    /* renamed from: d */
    public static final C2188b1 f6753d = new C2188b1();

    /* renamed from: a */
    public volatile Executor f6754a;

    /* renamed from: b */
    public volatile ExecutorService f6755b;

    /* renamed from: c */
    public final Object f6756c = new Object();

    /* renamed from: com.hihonor.push.sdk.b1$a */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: a */
    public static Executor m6372a() {
        C2188b1 c2188b1 = f6753d;
        if (c2188b1.f6754a == null) {
            synchronized (c2188b1.f6756c) {
                if (c2188b1.f6754a == null) {
                    c2188b1.f6754a = new a();
                }
            }
        }
        return c2188b1.f6754a;
    }

    /* renamed from: c */
    public static ExecutorService m6374c() {
        return f6753d.m6375b();
    }

    /* renamed from: b */
    public final ExecutorService m6375b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static void m6373a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            m6372a().execute(runnable);
        }
    }
}
