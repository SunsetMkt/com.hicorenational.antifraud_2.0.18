package com.bumptech.glide.load.p118p;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.C1671p;
import com.bumptech.glide.util.C1870d;
import com.bumptech.glide.util.C1876j;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources.java */
/* renamed from: com.bumptech.glide.load.p.a */
/* loaded from: classes.dex */
final class C1621a {

    /* renamed from: a */
    private final boolean f4261a;

    /* renamed from: b */
    private final Executor f4262b;

    /* renamed from: c */
    @VisibleForTesting
    final Map<InterfaceC1593g, d> f4263c;

    /* renamed from: d */
    private final ReferenceQueue<C1671p<?>> f4264d;

    /* renamed from: e */
    private C1671p.a f4265e;

    /* renamed from: f */
    private volatile boolean f4266f;

    /* renamed from: g */
    @Nullable
    private volatile c f4267g;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.p.a$a */
    class a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.p.a$a$a, reason: collision with other inner class name */
        class RunnableC7358a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f4268a;

            RunnableC7358a(Runnable runnable) {
                this.f4268a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f4268a.run();
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC7358a(runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.p.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1621a.this.m3891a();
        }
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a$c */
    interface c {
        /* renamed from: a */
        void m3899a();
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a$d */
    static final class d extends WeakReference<C1671p<?>> {

        /* renamed from: a */
        final InterfaceC1593g f4271a;

        /* renamed from: b */
        final boolean f4272b;

        /* renamed from: c */
        @Nullable
        InterfaceC1677v<?> f4273c;

        d(@NonNull InterfaceC1593g interfaceC1593g, @NonNull C1671p<?> c1671p, @NonNull ReferenceQueue<? super C1671p<?>> referenceQueue, boolean z) {
            super(c1671p, referenceQueue);
            this.f4271a = (InterfaceC1593g) C1876j.m4985a(interfaceC1593g);
            this.f4273c = (c1671p.m4187e() && z) ? (InterfaceC1677v) C1876j.m4985a(c1671p.m4186d()) : null;
            this.f4272b = c1671p.m4187e();
        }

        /* renamed from: a */
        void m3900a() {
            this.f4273c = null;
            clear();
        }
    }

    C1621a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a()));
    }

    /* renamed from: a */
    void m3896a(C1671p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f4265e = aVar;
            }
        }
    }

    @Nullable
    /* renamed from: b */
    synchronized C1671p<?> m3897b(InterfaceC1593g interfaceC1593g) {
        d dVar = this.f4263c.get(interfaceC1593g);
        if (dVar == null) {
            return null;
        }
        C1671p<?> c1671p = dVar.get();
        if (c1671p == null) {
            m3895a(dVar);
        }
        return c1671p;
    }

    @VisibleForTesting
    C1621a(boolean z, Executor executor) {
        this.f4263c = new HashMap();
        this.f4264d = new ReferenceQueue<>();
        this.f4261a = z;
        this.f4262b = executor;
        executor.execute(new b());
    }

    @VisibleForTesting
    /* renamed from: b */
    void m3898b() {
        this.f4266f = true;
        Executor executor = this.f4262b;
        if (executor instanceof ExecutorService) {
            C1870d.m4967a((ExecutorService) executor);
        }
    }

    /* renamed from: a */
    synchronized void m3893a(InterfaceC1593g interfaceC1593g, C1671p<?> c1671p) {
        d put = this.f4263c.put(interfaceC1593g, new d(interfaceC1593g, c1671p, this.f4264d, this.f4261a));
        if (put != null) {
            put.m3900a();
        }
    }

    /* renamed from: a */
    synchronized void m3892a(InterfaceC1593g interfaceC1593g) {
        d remove = this.f4263c.remove(interfaceC1593g);
        if (remove != null) {
            remove.m3900a();
        }
    }

    /* renamed from: a */
    void m3895a(@NonNull d dVar) {
        synchronized (this) {
            this.f4263c.remove(dVar.f4271a);
            if (dVar.f4272b && dVar.f4273c != null) {
                this.f4265e.mo4150a(dVar.f4271a, new C1671p<>(dVar.f4273c, true, false, dVar.f4271a, this.f4265e));
            }
        }
    }

    /* renamed from: a */
    void m3891a() {
        while (!this.f4266f) {
            try {
                m3895a((d) this.f4264d.remove());
                c cVar = this.f4267g;
                if (cVar != null) {
                    cVar.m3899a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    void m3894a(c cVar) {
        this.f4267g = cVar;
    }
}
