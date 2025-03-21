package com.tencent.bugly.proguard;

import com.tencent.bugly.C3072b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.am */
/* loaded from: classes2.dex */
public class C3150am {

    /* renamed from: a */
    private static final AtomicInteger f10566a = new AtomicInteger(1);

    /* renamed from: b */
    private static C3150am f10567b;

    /* renamed from: c */
    private ScheduledExecutorService f10568c;

    protected C3150am() {
        this.f10568c = null;
        this.f10568c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.am.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + C3150am.f10566a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f10568c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            C3151an.m9922d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C3150am m9906a() {
        C3150am c3150am;
        synchronized (C3150am.class) {
            if (f10567b == null) {
                f10567b = new C3150am();
            }
            c3150am = f10567b;
        }
        return c3150am;
    }

    /* renamed from: b */
    public synchronized void m9910b() {
        if (this.f10568c != null && !this.f10568c.isShutdown()) {
            C3151an.m9921c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f10568c.shutdownNow();
        }
    }

    /* renamed from: c */
    public synchronized boolean m9911c() {
        boolean z;
        if (this.f10568c != null) {
            z = this.f10568c.isShutdown() ? false : true;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m9909a(Runnable runnable, long j2) {
        if (!m9911c()) {
            C3151an.m9922d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C3151an.m9922d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        C3151an.m9921c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f10568c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (C3072b.f9834c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public synchronized boolean m9908a(Runnable runnable) {
        if (!m9911c()) {
            C3151an.m9922d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            C3151an.m9922d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        C3151an.m9921c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f10568c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (C3072b.f9834c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
