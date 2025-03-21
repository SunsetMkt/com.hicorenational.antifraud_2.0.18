package com.umeng.socialize.p215a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMExecutor.java */
/* renamed from: com.umeng.socialize.a.j */
/* loaded from: classes2.dex */
public class C3624j {

    /* renamed from: a */
    private static final String f13505a = "UMExecutor";

    /* renamed from: b */
    private static volatile ScheduledThreadPoolExecutor f13506b;

    /* renamed from: c */
    private static volatile ExecutorService f13507c;

    /* renamed from: d */
    private static final ThreadFactory f13508d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* renamed from: a */
        private final AtomicInteger f13509a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f13509a.incrementAndGet());
        }
    };

    /* compiled from: UMExecutor.java */
    /* renamed from: com.umeng.socialize.a.j$a */
    private static class a implements Runnable {

        /* renamed from: a */
        private final Runnable f13510a;

        public a(Runnable runnable) {
            this.f13510a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f13510a != null) {
                    this.f13510a.run();
                }
            } catch (Throwable th) {
                C3627m.m12568d(C3624j.f13505a, "error:", th.getMessage());
            }
        }
    }

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor m12541a() {
        if (f13506b == null) {
            synchronized (C3624j.class) {
                if (f13506b == null) {
                    f13506b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f13508d);
                    f13506b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f13506b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f13506b;
    }

    /* renamed from: b */
    private static ExecutorService m12544b() {
        if (f13507c == null) {
            synchronized (C3624j.class) {
                if (f13507c == null) {
                    f13507c = Executors.newSingleThreadExecutor(f13508d);
                }
            }
        }
        return f13507c;
    }

    /* renamed from: c */
    public static Future<?> m12546c(Runnable runnable) {
        try {
            return m12541a().submit(m12547d(runnable));
        } catch (Throwable th) {
            C3627m.m12568d(f13505a, "submit error:", th.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    private static Runnable m12547d(Runnable runnable) {
        return new a(runnable);
    }

    /* renamed from: b */
    public static void m12545b(Runnable runnable) {
        try {
            m12541a().execute(m12547d(runnable));
        } catch (Throwable th) {
            C3627m.m12568d(f13505a, "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    /* renamed from: a */
    public static <Params, Progress, Result> void m12542a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(m12541a(), paramsArr);
        } catch (Throwable th) {
            C3627m.m12568d(f13505a, "executeOnExecutor error:", th.getMessage());
        }
    }

    /* renamed from: a */
    public static Future<?> m12540a(Runnable runnable) {
        try {
            return m12544b().submit(m12547d(runnable));
        } catch (Throwable th) {
            C3627m.m12568d(f13505a, "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static void m12543a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            m12541a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            C3627m.m12568d(f13505a, "schedule error:", th.getMessage());
        }
    }
}
