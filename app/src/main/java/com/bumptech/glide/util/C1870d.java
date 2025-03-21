package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Executors.java */
/* renamed from: com.bumptech.glide.util.d */
/* loaded from: classes.dex */
public final class C1870d {

    /* renamed from: a */
    private static final Executor f5481a = new a();

    /* renamed from: b */
    private static final Executor f5482b = new b();

    /* compiled from: Executors.java */
    /* renamed from: com.bumptech.glide.util.d$a */
    class a implements Executor {

        /* renamed from: a */
        private final Handler f5483a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f5483a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* renamed from: com.bumptech.glide.util.d$b */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private C1870d() {
    }

    /* renamed from: a */
    public static Executor m4966a() {
        return f5482b;
    }

    /* renamed from: b */
    public static Executor m4968b() {
        return f5481a;
    }

    @VisibleForTesting
    /* renamed from: a */
    public static void m4967a(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
            } else {
                throw new RuntimeException("Failed to shutdown");
            }
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
