package com.huawei.hmf.tasks.p170a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hmf.tasks.a.a */
/* loaded from: classes.dex */
public final class C2271a {

    /* renamed from: a */
    private static final C2271a f6942a = new C2271a();

    /* renamed from: c */
    private static final int f6943c;

    /* renamed from: d */
    private static final int f6944d;

    /* renamed from: e */
    private static final int f6945e;

    /* renamed from: b */
    private final Executor f6946b = new a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a */
    static class a implements Executor {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6943c = availableProcessors;
        f6944d = availableProcessors + 1;
        f6945e = (f6943c * 2) + 1;
    }

    /* renamed from: a */
    public static ExecutorService m6471a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f6944d, f6945e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static Executor m6472b() {
        return f6942a.f6946b;
    }
}
