package com.hihonor.cloudservice.tasks.p161q;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorSingle.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.g */
/* loaded from: classes.dex */
public class C2146g {

    /* renamed from: b */
    private static final C2146g f6457b = new C2146g();

    /* renamed from: c */
    private static final int f6458c;

    /* renamed from: d */
    static final int f6459d;

    /* renamed from: e */
    static final int f6460e;

    /* renamed from: a */
    private final Executor f6461a = new b();

    /* compiled from: ExecutorSingle.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.g$b */
    private static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }

        private b() {
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6458c = availableProcessors;
        f6459d = availableProcessors + 1;
        f6460e = (availableProcessors * 2) + 1;
    }

    /* renamed from: a */
    public static Executor m6074a() {
        return f6457b.f6461a;
    }

    /* renamed from: b */
    public static ExecutorService m6075b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f6459d, f6460e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
