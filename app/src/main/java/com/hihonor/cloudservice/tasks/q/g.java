package com.hihonor.cloudservice.tasks.q;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ExecutorSingle.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f4081b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f4083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f4084e;
    private final Executor a = new b();

    /* JADX INFO: compiled from: ExecutorSingle.java */
    private static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }

        private b() {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4082c = iAvailableProcessors;
        f4083d = iAvailableProcessors + 1;
        f4084e = (iAvailableProcessors * 2) + 1;
    }

    public static Executor a() {
        return f4081b.a;
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f4083d, f4084e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
