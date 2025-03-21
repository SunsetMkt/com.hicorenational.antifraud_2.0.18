package com.alibaba.sdk.android.utils.crashdefend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashDispatcher.java */
/* renamed from: com.alibaba.sdk.android.utils.crashdefend.f */
/* loaded from: classes.dex */
final class C1572f {

    /* renamed from: a */
    private final ThreadFactory f4059a = new ThreadFactory() { // from class: com.alibaba.sdk.android.utils.crashdefend.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    /* renamed from: b */
    private ExecutorService f4060b;

    C1572f() {
    }

    /* renamed from: a */
    synchronized ExecutorService m3625a() {
        if (this.f4060b == null) {
            this.f4060b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f4059a);
        }
        return this.f4060b;
    }
}
