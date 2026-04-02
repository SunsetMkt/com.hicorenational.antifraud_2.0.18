package com.hihonor.honorid;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: UseCaseThreadPoolScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f4217b = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f4220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static e f4221f;
    private ThreadPoolExecutor a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f4218c = iAvailableProcessors;
        f4219d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f4220e = (f4218c * 2) + 1;
    }

    private e() {
        new Handler(Looper.getMainLooper());
        this.a = new ThreadPoolExecutor(f4219d, f4220e, 30L, TimeUnit.SECONDS, f4217b);
    }

    public static e a() {
        e eVar;
        synchronized (e.class) {
            if (f4221f == null) {
                f4221f = new e();
            }
            eVar = f4221f;
        }
        return eVar;
    }

    @Override // com.hihonor.honorid.c
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}
