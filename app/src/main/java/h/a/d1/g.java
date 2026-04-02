package h.a.d1;

import h.a.l;
import h.a.y0.i.j;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UnicastProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y0.f.c<T> f10310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<Runnable> f10311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f10312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f10313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Throwable f10314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<j.d.c<? super T>> f10315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f10316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicBoolean f10317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final h.a.y0.i.c<T> f10318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final AtomicLong f10319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f10320l;

    /* JADX INFO: compiled from: UnicastProcessor.java */
    final class a extends h.a.y0.i.c<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        a() {
        }

        @Override // j.d.d
        public void cancel() {
            if (g.this.f10316h) {
                return;
            }
            g gVar = g.this;
            gVar.f10316h = true;
            gVar.Y();
            g gVar2 = g.this;
            if (gVar2.f10320l || gVar2.f10318j.getAndIncrement() != 0) {
                return;
            }
            g.this.f10310b.clear();
            g.this.f10315g.lazySet(null);
        }

        @Override // h.a.y0.c.o
        public void clear() {
            g.this.f10310b.clear();
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return g.this.f10310b.isEmpty();
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() {
            return g.this.f10310b.poll();
        }

        @Override // j.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                h.a.y0.j.d.a(g.this.f10319k, j2);
                g.this.Z();
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            g.this.f10320l = true;
            return 2;
        }
    }

    g(int i2) {
        this(i2, null, true);
    }

    @h.a.t0.d
    public static <T> g<T> a(int i2, Runnable runnable) {
        h.a.y0.b.b.a(runnable, "onTerminate");
        return new g<>(i2, runnable);
    }

    @h.a.t0.d
    public static <T> g<T> a0() {
        return new g<>(l.Q());
    }

    @h.a.t0.d
    @h.a.t0.e
    public static <T> g<T> b(boolean z) {
        return new g<>(l.Q(), null, z);
    }

    @h.a.t0.d
    public static <T> g<T> m(int i2) {
        return new g<>(i2);
    }

    @Override // h.a.d1.c
    public Throwable T() {
        if (this.f10313e) {
            return this.f10314f;
        }
        return null;
    }

    @Override // h.a.d1.c
    public boolean U() {
        return this.f10313e && this.f10314f == null;
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10315g.get() != null;
    }

    @Override // h.a.d1.c
    public boolean W() {
        return this.f10313e && this.f10314f != null;
    }

    void Y() {
        Runnable runnable = this.f10311c.get();
        if (runnable == null || !this.f10311c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void Z() {
        if (this.f10318j.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        j.d.c<? super T> cVar = this.f10315g.get();
        while (cVar == null) {
            iAddAndGet = this.f10318j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                cVar = this.f10315g.get();
            }
        }
        if (this.f10320l) {
            f((j.d.c) cVar);
        } else {
            g((j.d.c) cVar);
        }
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (this.f10317i.get() || !this.f10317i.compareAndSet(false, true)) {
            h.a.y0.i.g.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.onSubscribe(this.f10318j);
        this.f10315g.set(cVar);
        if (this.f10316h) {
            this.f10315g.lazySet(null);
        } else {
            Z();
        }
    }

    void f(j.d.c<? super T> cVar) {
        h.a.y0.f.c<T> cVar2 = this.f10310b;
        int iAddAndGet = 1;
        boolean z = !this.f10312d;
        while (!this.f10316h) {
            boolean z2 = this.f10313e;
            if (z && z2 && this.f10314f != null) {
                cVar2.clear();
                this.f10315g.lazySet(null);
                cVar.onError(this.f10314f);
                return;
            }
            cVar.onNext(null);
            if (z2) {
                this.f10315g.lazySet(null);
                Throwable th = this.f10314f;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f10318j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        cVar2.clear();
        this.f10315g.lazySet(null);
    }

    void g(j.d.c<? super T> cVar) {
        long j2;
        h.a.y0.f.c<T> cVar2 = this.f10310b;
        boolean z = !this.f10312d;
        int iAddAndGet = 1;
        do {
            long j3 = this.f10319k.get();
            long j4 = 0;
            while (true) {
                if (j3 == j4) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.f10313e;
                T tPoll = cVar2.poll();
                boolean z3 = tPoll == null;
                j2 = j4;
                if (a(z, z2, z3, cVar, cVar2)) {
                    return;
                }
                if (z3) {
                    break;
                }
                cVar.onNext(tPoll);
                j4 = 1 + j2;
            }
            if (j3 == j4 && a(z, this.f10313e, cVar2.isEmpty(), cVar, cVar2)) {
                return;
            }
            if (j2 != 0 && j3 != m0.f12222b) {
                this.f10319k.addAndGet(-j2);
            }
            iAddAndGet = this.f10318j.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10313e || this.f10316h) {
            return;
        }
        this.f10313e = true;
        Y();
        Z();
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f10313e || this.f10316h) {
            h.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f10314f = th;
        this.f10313e = true;
        Y();
        Z();
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10313e || this.f10316h) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f10310b.offer(t);
            Z();
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.f10313e || this.f10316h) {
            dVar.cancel();
        } else {
            dVar.request(m0.f12222b);
        }
    }

    g(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    g(int i2, Runnable runnable, boolean z) {
        this.f10310b = new h.a.y0.f.c<>(h.a.y0.b.b.a(i2, "capacityHint"));
        this.f10311c = new AtomicReference<>(runnable);
        this.f10312d = z;
        this.f10315g = new AtomicReference<>();
        this.f10317i = new AtomicBoolean();
        this.f10318j = new a();
        this.f10319k = new AtomicLong();
    }

    @h.a.t0.d
    @h.a.t0.e
    public static <T> g<T> a(int i2, Runnable runnable, boolean z) {
        h.a.y0.b.b.a(runnable, "onTerminate");
        return new g<>(i2, runnable, z);
    }

    boolean a(boolean z, boolean z2, boolean z3, j.d.c<? super T> cVar, h.a.y0.f.c<T> cVar2) {
        if (this.f10316h) {
            cVar2.clear();
            this.f10315g.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.f10314f != null) {
            cVar2.clear();
            this.f10315g.lazySet(null);
            cVar.onError(this.f10314f);
            return true;
        }
        if (!z3) {
            return false;
        }
        Throwable th = this.f10314f;
        this.f10315g.lazySet(null);
        if (th != null) {
            cVar.onError(th);
        } else {
            cVar.onComplete();
        }
        return true;
    }
}
