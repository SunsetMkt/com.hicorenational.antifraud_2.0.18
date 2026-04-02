package com.umeng.message.proguard;

import com.umeng.message.common.UPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ui.activity.SmsRecordSelectActivity;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile ScheduledThreadPoolExecutor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ExecutorService f8020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f8021c;

    static class a implements Runnable {
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
                UPLog.e("Executors", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.b$b, reason: collision with other inner class name */
    static final class ThreadFactoryC0140b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8022b;

        ThreadFactoryC0140b(String str) {
            this.f8022b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f8022b + d.c.a.b.a.a.f10074g + this.a.incrementAndGet());
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), new ThreadFactoryC0140b("pool"));
                    a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }

    private static ExecutorService b() {
        if (f8020b == null) {
            synchronized (b.class) {
                if (f8020b == null) {
                    f8020b = Executors.newSingleThreadExecutor(new ThreadFactoryC0140b(SmsRecordSelectActivity.f13863l));
                }
            }
        }
        return f8020b;
    }

    private static ExecutorService c() {
        if (f8021c == null) {
            synchronized (b.class) {
                if (f8021c == null) {
                    f8021c = Executors.newSingleThreadExecutor(new ThreadFactoryC0140b("msg"));
                }
            }
        }
        return f8021c;
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static Future<?> b(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            c().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static ScheduledFuture<?> a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            return a().schedule(d(runnable), j2, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }
}
