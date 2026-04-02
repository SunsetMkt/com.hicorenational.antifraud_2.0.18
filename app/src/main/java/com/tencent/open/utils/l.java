package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f6924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HandlerThread f6925d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f6923b = new Object();
    public static final Executor a = c();

    /* JADX INFO: compiled from: ProGuard */
    private static class a implements Executor {
        final Queue<Runnable> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f6926b;

        private a() {
            this.a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable runnablePoll = this.a.poll();
            this.f6926b = runnablePoll;
            if (runnablePoll != null) {
                l.a.execute(this.f6926b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f6926b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (f6924c == null) {
            synchronized (l.class) {
                f6925d = new HandlerThread("SDK_SUB");
                f6925d.start();
                f6924c = new Handler(f6925d.getLooper());
            }
        }
        return f6924c;
    }

    public static Executor b() {
        return new a();
    }
}
