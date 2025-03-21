package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.umzid.c */
/* loaded from: classes2.dex */
public class C3794c {

    /* renamed from: a */
    public static volatile ScheduledThreadPoolExecutor f13851a;

    /* renamed from: b */
    public static ThreadFactory f13852b = new a();

    /* renamed from: com.umeng.umzid.c$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public AtomicInteger f13853a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f13853a.addAndGet(1));
            return thread;
        }
    }

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m12734a() {
        if (f13851a == null) {
            synchronized (C3794c.class) {
                if (f13851a == null) {
                    f13851a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f13852b);
                }
            }
        }
        return f13851a;
    }

    /* renamed from: a */
    public static void m12735a(Runnable runnable) {
        try {
            m12734a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
