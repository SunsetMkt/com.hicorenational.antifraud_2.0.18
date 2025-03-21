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

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.l */
/* loaded from: classes2.dex */
public final class C3294l {

    /* renamed from: c */
    private static Handler f11321c;

    /* renamed from: d */
    private static HandlerThread f11322d;

    /* renamed from: b */
    private static Object f11320b = new Object();

    /* renamed from: a */
    public static final Executor f11319a = m10657c();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.l$a */
    private static class a implements Executor {

        /* renamed from: a */
        final Queue<Runnable> f11323a;

        /* renamed from: b */
        Runnable f11324b;

        private a() {
            this.f11323a = new LinkedList();
        }

        /* renamed from: a */
        protected synchronized void m10658a() {
            Runnable poll = this.f11323a.poll();
            this.f11324b = poll;
            if (poll != null) {
                C3294l.f11319a.execute(this.f11324b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f11323a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.m10658a();
                    }
                }
            });
            if (this.f11324b == null) {
                m10658a();
            }
        }
    }

    /* renamed from: a */
    public static void m10654a(Runnable runnable) {
        try {
            f11319a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: b */
    public static void m10656b(Runnable runnable) {
        m10653a().post(runnable);
    }

    /* renamed from: c */
    private static Executor m10657c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* renamed from: a */
    public static Handler m10653a() {
        if (f11321c == null) {
            synchronized (C3294l.class) {
                f11322d = new HandlerThread("SDK_SUB");
                f11322d.start();
                f11321c = new Handler(f11322d.getLooper());
            }
        }
        return f11321c;
    }

    /* renamed from: b */
    public static Executor m10655b() {
        return new a();
    }
}
