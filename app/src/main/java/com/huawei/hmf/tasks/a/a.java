package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final a a = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f4357e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f4358b = new ExecutorC0090a(0);

    /* JADX INFO: renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    static class ExecutorC0090a implements Executor {
        private ExecutorC0090a() {
        }

        /* synthetic */ ExecutorC0090a(byte b2) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4355c = iAvailableProcessors;
        f4356d = iAvailableProcessors + 1;
        f4357e = (f4355c * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f4356d, f4357e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return a.f4358b;
    }
}
