package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class am {
    private static final AtomicInteger a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static am f6408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f6409c;

    protected am() {
        this.f6409c = null;
        this.f6409c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.am.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + am.a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f6409c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            an.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized am a() {
        if (f6408b == null) {
            f6408b = new am();
        }
        return f6408b;
    }

    public synchronized void b() {
        if (this.f6409c != null && !this.f6409c.isShutdown()) {
            an.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f6409c.shutdownNow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean c() {
        boolean z;
        if (this.f6409c != null) {
            z = !this.f6409c.isShutdown();
        }
        return z;
    }

    public synchronized boolean a(Runnable runnable, long j2) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        an.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f6409c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f5995c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        an.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f6409c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f5995c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
