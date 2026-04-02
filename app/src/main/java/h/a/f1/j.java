package h.a.f1;

import h.a.b0;
import h.a.i0;
import h.a.y0.c.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UnicastSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T> extends i<T> {
    final h.a.y0.f.c<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<i0<? super T>> f10380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<Runnable> f10381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f10383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f10384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Throwable f10385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicBoolean f10386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final h.a.y0.d.b<T> f10387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f10388j;

    /* JADX INFO: compiled from: UnicastSubject.java */
    final class a extends h.a.y0.d.b<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        @Override // h.a.y0.c.o
        public void clear() {
            j.this.a.clear();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (j.this.f10383e) {
                return;
            }
            j jVar = j.this;
            jVar.f10383e = true;
            jVar.T();
            j.this.f10380b.lazySet(null);
            if (j.this.f10387i.getAndIncrement() == 0) {
                j.this.f10380b.lazySet(null);
                j.this.a.clear();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return j.this.f10383e;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return j.this.a.isEmpty();
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            return j.this.a.poll();
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            j.this.f10388j = true;
            return 2;
        }
    }

    j(int i2, boolean z) {
        this.a = new h.a.y0.f.c<>(h.a.y0.b.b.a(i2, "capacityHint"));
        this.f10381c = new AtomicReference<>();
        this.f10382d = z;
        this.f10380b = new AtomicReference<>();
        this.f10386h = new AtomicBoolean();
        this.f10387i = new a();
    }

    @h.a.t0.d
    public static <T> j<T> V() {
        return new j<>(b0.L(), true);
    }

    @h.a.t0.d
    public static <T> j<T> a(int i2, Runnable runnable) {
        return new j<>(i2, runnable, true);
    }

    @h.a.t0.d
    @h.a.t0.e
    public static <T> j<T> b(boolean z) {
        return new j<>(b0.L(), z);
    }

    @h.a.t0.d
    public static <T> j<T> i(int i2) {
        return new j<>(i2, true);
    }

    @Override // h.a.f1.i
    public Throwable O() {
        if (this.f10384f) {
            return this.f10385g;
        }
        return null;
    }

    @Override // h.a.f1.i
    public boolean P() {
        return this.f10384f && this.f10385g == null;
    }

    @Override // h.a.f1.i
    public boolean Q() {
        return this.f10380b.get() != null;
    }

    @Override // h.a.f1.i
    public boolean R() {
        return this.f10384f && this.f10385g != null;
    }

    void T() {
        Runnable runnable = this.f10381c.get();
        if (runnable == null || !this.f10381c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void U() {
        if (this.f10387i.getAndIncrement() != 0) {
            return;
        }
        i0<? super T> i0Var = this.f10380b.get();
        int iAddAndGet = 1;
        while (i0Var == null) {
            iAddAndGet = this.f10387i.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                i0Var = this.f10380b.get();
            }
        }
        if (this.f10388j) {
            f((i0) i0Var);
        } else {
            g((i0) i0Var);
        }
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        if (this.f10386h.get() || !this.f10386h.compareAndSet(false, true)) {
            h.a.y0.a.e.error(new IllegalStateException("Only a single observer allowed."), i0Var);
            return;
        }
        i0Var.onSubscribe(this.f10387i);
        this.f10380b.lazySet(i0Var);
        if (this.f10383e) {
            this.f10380b.lazySet(null);
        } else {
            U();
        }
    }

    void f(i0<? super T> i0Var) {
        h.a.y0.f.c<T> cVar = this.a;
        int iAddAndGet = 1;
        boolean z = !this.f10382d;
        while (!this.f10383e) {
            boolean z2 = this.f10384f;
            if (z && z2 && a((o) cVar, (i0) i0Var)) {
                return;
            }
            i0Var.onNext(null);
            if (z2) {
                h((i0) i0Var);
                return;
            } else {
                iAddAndGet = this.f10387i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f10380b.lazySet(null);
        cVar.clear();
    }

    void g(i0<? super T> i0Var) {
        h.a.y0.f.c<T> cVar = this.a;
        boolean z = !this.f10382d;
        boolean z2 = true;
        int iAddAndGet = 1;
        while (!this.f10383e) {
            boolean z3 = this.f10384f;
            T tPoll = this.a.poll();
            boolean z4 = tPoll == null;
            if (z3) {
                if (z && z2) {
                    if (a((o) cVar, (i0) i0Var)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    h((i0) i0Var);
                    return;
                }
            }
            if (z4) {
                iAddAndGet = this.f10387i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                i0Var.onNext(tPoll);
            }
        }
        this.f10380b.lazySet(null);
        cVar.clear();
    }

    void h(i0<? super T> i0Var) {
        this.f10380b.lazySet(null);
        Throwable th = this.f10385g;
        if (th != null) {
            i0Var.onError(th);
        } else {
            i0Var.onComplete();
        }
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10384f || this.f10383e) {
            return;
        }
        this.f10384f = true;
        T();
        U();
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.f10384f || this.f10383e) {
            h.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f10385g = th;
        this.f10384f = true;
        T();
        U();
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.f10384f || this.f10383e) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.a.offer(t);
            U();
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.f10384f || this.f10383e) {
            cVar.dispose();
        }
    }

    @h.a.t0.d
    @h.a.t0.e
    public static <T> j<T> a(int i2, Runnable runnable, boolean z) {
        return new j<>(i2, runnable, z);
    }

    boolean a(o<T> oVar, i0<? super T> i0Var) {
        Throwable th = this.f10385g;
        if (th == null) {
            return false;
        }
        this.f10380b.lazySet(null);
        oVar.clear();
        i0Var.onError(th);
        return true;
    }

    j(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    j(int i2, Runnable runnable, boolean z) {
        this.a = new h.a.y0.f.c<>(h.a.y0.b.b.a(i2, "capacityHint"));
        this.f10381c = new AtomicReference<>(h.a.y0.b.b.a(runnable, "onTerminate"));
        this.f10382d = z;
        this.f10380b = new AtomicReference<>();
        this.f10386h = new AtomicBoolean();
        this.f10387i = new a();
    }
}
