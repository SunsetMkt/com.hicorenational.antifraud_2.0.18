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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p388ui.activity.SmsRecordSelectActivity;

/* renamed from: com.umeng.message.proguard.b */
/* loaded from: classes2.dex */
public class C3578b {

    /* renamed from: a */
    private static volatile ScheduledThreadPoolExecutor f13254a;

    /* renamed from: b */
    private static volatile ExecutorService f13255b;

    /* renamed from: c */
    private static volatile ExecutorService f13256c;

    /* renamed from: com.umeng.message.proguard.b$a */
    static class a implements Runnable {

        /* renamed from: a */
        private final Runnable f13257a;

        public a(Runnable runnable) {
            this.f13257a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f13257a != null) {
                    this.f13257a.run();
                }
            } catch (Throwable th) {
                UPLog.m12143e("Executors", th);
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.b$b */
    static final class b implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f13258a = new AtomicInteger();

        /* renamed from: b */
        private final String f13259b;

        b(String str) {
            this.f13259b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f13259b + AbstractC1191a.f2568g + this.f13258a.incrementAndGet());
        }
    }

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor m12322a() {
        if (f13254a == null) {
            synchronized (C3578b.class) {
                if (f13254a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), new b("pool"));
                    f13254a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f13254a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f13254a;
    }

    /* renamed from: b */
    private static ExecutorService m12324b() {
        if (f13255b == null) {
            synchronized (C3578b.class) {
                if (f13255b == null) {
                    f13255b = Executors.newSingleThreadExecutor(new b(SmsRecordSelectActivity.f23205l));
                }
            }
        }
        return f13255b;
    }

    /* renamed from: c */
    private static ExecutorService m12326c() {
        if (f13256c == null) {
            synchronized (C3578b.class) {
                if (f13256c == null) {
                    f13256c = Executors.newSingleThreadExecutor(new b("msg"));
                }
            }
        }
        return f13256c;
    }

    /* renamed from: d */
    private static Runnable m12328d(Runnable runnable) {
        return new a(runnable);
    }

    /* renamed from: b */
    public static Future<?> m12325b(Runnable runnable) {
        try {
            return m12324b().submit(m12328d(runnable));
        } catch (Throwable th) {
            UPLog.m12143e("Executors", th);
            return null;
        }
    }

    /* renamed from: c */
    public static void m12327c(Runnable runnable) {
        try {
            m12322a().execute(m12328d(runnable));
        } catch (Throwable th) {
            UPLog.m12143e("Executors", th);
        }
    }

    /* renamed from: a */
    public static void m12323a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            m12326c().execute(m12328d(runnable));
        } catch (Throwable th) {
            UPLog.m12143e("Executors", th);
        }
    }

    /* renamed from: a */
    public static ScheduledFuture<?> m12321a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            return m12322a().schedule(m12328d(runnable), j2, timeUnit);
        } catch (Throwable th) {
            UPLog.m12143e("Executors", th);
            return null;
        }
    }
}
