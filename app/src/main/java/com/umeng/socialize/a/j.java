package com.umeng.socialize.a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final String a = "UMExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f8188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f8189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f8190d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1
        private final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.a.incrementAndGet());
        }
    };

    /* JADX INFO: compiled from: UMExecutor.java */
    private static class a implements Runnable {
        private final Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a != null) {
                    this.a.run();
                }
            } catch (Throwable th) {
                m.d(j.a, "error:", th.getMessage());
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f8188b == null) {
            synchronized (j.class) {
                if (f8188b == null) {
                    f8188b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f8190d);
                    f8188b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f8188b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f8188b;
    }

    private static ExecutorService b() {
        if (f8189c == null) {
            synchronized (j.class) {
                if (f8189c == null) {
                    f8189c = Executors.newSingleThreadExecutor(f8190d);
                }
            }
        }
        return f8189c;
    }

    public static Future<?> c(Runnable runnable) {
        try {
            return a().submit(d(runnable));
        } catch (Throwable th) {
            m.d(a, "submit error:", th.getMessage());
            return null;
        }
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            m.d(a, "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(a(), paramsArr);
        } catch (Throwable th) {
            m.d(a, "executeOnExecutor error:", th.getMessage());
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            m.d(a, "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            m.d(a, "schedule error:", th.getMessage());
        }
    }
}
