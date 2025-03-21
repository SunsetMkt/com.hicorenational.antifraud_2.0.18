package com.hihonor.honorid;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: UseCaseThreadPoolScheduler.java */
/* renamed from: com.hihonor.honorid.e */
/* loaded from: classes.dex */
public final class C2170e implements InterfaceC2153c {

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f6723b = new LinkedBlockingQueue();

    /* renamed from: c */
    private static final int f6724c;

    /* renamed from: d */
    private static final int f6725d;

    /* renamed from: e */
    private static final int f6726e;

    /* renamed from: f */
    private static C2170e f6727f;

    /* renamed from: a */
    private ThreadPoolExecutor f6728a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6724c = availableProcessors;
        f6725d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f6726e = (f6724c * 2) + 1;
    }

    private C2170e() {
        new Handler(Looper.getMainLooper());
        this.f6728a = new ThreadPoolExecutor(f6725d, f6726e, 30L, TimeUnit.SECONDS, f6723b);
    }

    /* renamed from: a */
    public static C2170e m6315a() {
        C2170e c2170e;
        synchronized (C2170e.class) {
            if (f6727f == null) {
                f6727f = new C2170e();
            }
            c2170e = f6727f;
        }
        return c2170e;
    }

    @Override // com.hihonor.honorid.InterfaceC2153c
    public void execute(Runnable runnable) {
        this.f6728a.execute(runnable);
    }
}
