package com.bumptech.glide.load.p;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
final class a {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f2767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<com.bumptech.glide.load.g, d> f2768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f2769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p.a f2770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f2771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile c f2772g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    class ThreadFactoryC0044a implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.p.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActiveResources.java */
        class RunnableC0045a implements Runnable {
            final /* synthetic */ Runnable a;

            RunnableC0045a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        ThreadFactoryC0044a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0045a(runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    interface c {
        void a();
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    static final class d extends WeakReference<p<?>> {
        final com.bumptech.glide.load.g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f2774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        v<?> f2775c;

        d(@NonNull com.bumptech.glide.load.g gVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.a = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar);
            this.f2775c = (pVar.e() && z) ? (v) com.bumptech.glide.util.j.a(pVar.d()) : null;
            this.f2774b = pVar.e();
        }

        void a() {
            this.f2775c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0044a()));
    }

    void a(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f2770e = aVar;
            }
        }
    }

    @Nullable
    synchronized p<?> b(com.bumptech.glide.load.g gVar) {
        d dVar = this.f2768c.get(gVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar == null) {
            a(dVar);
        }
        return pVar;
    }

    @VisibleForTesting
    a(boolean z, Executor executor) {
        this.f2768c = new HashMap();
        this.f2769d = new ReferenceQueue<>();
        this.a = z;
        this.f2767b = executor;
        executor.execute(new b());
    }

    @VisibleForTesting
    void b() {
        this.f2771f = true;
        Executor executor = this.f2767b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.d.a((ExecutorService) executor);
        }
    }

    synchronized void a(com.bumptech.glide.load.g gVar, p<?> pVar) {
        d dVarPut = this.f2768c.put(gVar, new d(gVar, pVar, this.f2769d, this.a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    synchronized void a(com.bumptech.glide.load.g gVar) {
        d dVarRemove = this.f2768c.remove(gVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    void a(@NonNull d dVar) {
        synchronized (this) {
            this.f2768c.remove(dVar.a);
            if (dVar.f2774b && dVar.f2775c != null) {
                this.f2770e.a(dVar.a, new p<>(dVar.f2775c, true, false, dVar.a, this.f2770e));
            }
        }
    }

    void a() {
        while (!this.f2771f) {
            try {
                a((d) this.f2769d.remove());
                c cVar = this.f2772g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    void a(c cVar) {
        this.f2772g = cVar;
    }
}
