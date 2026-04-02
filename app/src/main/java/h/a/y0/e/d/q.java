package h.a.y0.e.d;

import h.a.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableBufferTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T, U extends Collection<? super T>> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f11565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Callable<U> f11566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f11567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f11568h;

    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class a<T, U extends Collection<? super T>> extends h.a.y0.d.w<T, U, U> implements Runnable, h.a.u0.c {
        final Callable<U> K;
        final long L;
        final TimeUnit M;
        final int N;
        final boolean O;
        final j0.c b0;
        U c0;
        h.a.u0.c d0;
        h.a.u0.c e0;
        long f0;
        long g0;

        a(h.a.i0<? super U> i0Var, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, j0.c cVar) {
            super(i0Var, new h.a.y0.f.a());
            this.K = callable;
            this.L = j2;
            this.M = timeUnit;
            this.N = i2;
            this.O = z;
            this.b0 = cVar;
        }

        @Override // h.a.y0.d.w, h.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(h.a.i0 i0Var, Object obj) {
            a((h.a.i0<? super Collection>) i0Var, (Collection) obj);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            this.e0.dispose();
            this.b0.dispose();
            synchronized (this) {
                this.c0 = null;
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            U u;
            this.b0.dispose();
            synchronized (this) {
                u = this.c0;
                this.c0 = null;
            }
            this.G.offer(u);
            this.I = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) this.G, (h.a.i0) this.F, false, (h.a.u0.c) this, (h.a.y0.j.r) this);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.c0 = null;
            }
            this.F.onError(th);
            this.b0.dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.c0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.N) {
                    return;
                }
                this.c0 = null;
                this.f0++;
                if (this.O) {
                    this.d0.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.c0 = u2;
                        this.g0++;
                    }
                    if (this.O) {
                        j0.c cVar = this.b0;
                        long j2 = this.L;
                        this.d0 = cVar.a(this, j2, j2, this.M);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.F.onError(th);
                    dispose();
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.e0, cVar)) {
                this.e0 = cVar;
                try {
                    this.c0 = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.F.onSubscribe(this);
                    j0.c cVar2 = this.b0;
                    long j2 = this.L;
                    this.d0 = cVar2.a(this, j2, j2, this.M);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cVar.dispose();
                    h.a.y0.a.e.error(th, this.F);
                    this.b0.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) h.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.c0;
                    if (u2 != null && this.f0 == this.g0) {
                        this.c0 = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dispose();
                this.F.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(h.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }
    }

    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class b<T, U extends Collection<? super T>> extends h.a.y0.d.w<T, U, U> implements Runnable, h.a.u0.c {
        final Callable<U> K;
        final long L;
        final TimeUnit M;
        final h.a.j0 N;
        h.a.u0.c O;
        U b0;
        final AtomicReference<h.a.u0.c> c0;

        b(h.a.i0<? super U> i0Var, Callable<U> callable, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(i0Var, new h.a.y0.f.a());
            this.c0 = new AtomicReference<>();
            this.K = callable;
            this.L = j2;
            this.M = timeUnit;
            this.N = j0Var;
        }

        @Override // h.a.y0.d.w, h.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(h.a.i0 i0Var, Object obj) {
            a((h.a.i0<? super Collection>) i0Var, (Collection) obj);
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.c0);
            this.O.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.c0.get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.i0
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.b0;
                this.b0 = null;
            }
            if (u != null) {
                this.G.offer(u);
                this.I = true;
                if (b()) {
                    h.a.y0.j.v.a((h.a.y0.c.n) this.G, (h.a.i0) this.F, false, (h.a.u0.c) this, (h.a.y0.j.r) this);
                }
            }
            h.a.y0.a.d.dispose(this.c0);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            synchronized (this) {
                this.b0 = null;
            }
            this.F.onError(th);
            h.a.y0.a.d.dispose(this.c0);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.b0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                try {
                    this.b0 = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.F.onSubscribe(this);
                    if (this.H) {
                        return;
                    }
                    h.a.j0 j0Var = this.N;
                    long j2 = this.L;
                    h.a.u0.c cVarA = j0Var.a(this, j2, j2, this.M);
                    if (this.c0.compareAndSet(null, cVarA)) {
                        return;
                    }
                    cVarA.dispose();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    dispose();
                    h.a.y0.a.e.error(th, this.F);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) h.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.b0;
                    if (u != null) {
                        this.b0 = u2;
                    }
                }
                if (u == null) {
                    h.a.y0.a.d.dispose(this.c0);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.F.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(h.a.i0<? super U> i0Var, U u) {
            this.F.onNext((Object) u);
        }
    }

    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class c<T, U extends Collection<? super T>> extends h.a.y0.d.w<T, U, U> implements Runnable, h.a.u0.c {
        final Callable<U> K;
        final long L;
        final long M;
        final TimeUnit N;
        final j0.c O;
        final List<U> b0;
        h.a.u0.c c0;

        /* JADX INFO: compiled from: ObservableBufferTimed.java */
        final class a implements Runnable {
            private final U a;

            a(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.b0.remove(this.a);
                }
                c cVar = c.this;
                cVar.b(this.a, false, cVar.O);
            }
        }

        /* JADX INFO: compiled from: ObservableBufferTimed.java */
        final class b implements Runnable {
            private final U a;

            b(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.b0.remove(this.a);
                }
                c cVar = c.this;
                cVar.b(this.a, false, cVar.O);
            }
        }

        c(h.a.i0<? super U> i0Var, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, j0.c cVar) {
            super(i0Var, new h.a.y0.f.a());
            this.K = callable;
            this.L = j2;
            this.M = j3;
            this.N = timeUnit;
            this.O = cVar;
            this.b0 = new LinkedList();
        }

        @Override // h.a.y0.d.w, h.a.y0.j.r
        public /* bridge */ /* synthetic */ void a(h.a.i0 i0Var, Object obj) {
            a((h.a.i0<? super Collection>) i0Var, (Collection) obj);
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.H) {
                return;
            }
            this.H = true;
            f();
            this.c0.dispose();
            this.O.dispose();
        }

        void f() {
            synchronized (this) {
                this.b0.clear();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.b0);
                this.b0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.G.offer((U) ((Collection) it.next()));
            }
            this.I = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) this.G, (h.a.i0) this.F, false, (h.a.u0.c) this.O, (h.a.y0.j.r) this);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.I = true;
            f();
            this.F.onError(th);
            this.O.dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.c0, cVar)) {
                this.c0 = cVar;
                try {
                    Collection collection = (Collection) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    this.b0.add((U) collection);
                    this.F.onSubscribe(this);
                    j0.c cVar2 = this.O;
                    long j2 = this.M;
                    cVar2.a(this, j2, j2, this.N);
                    this.O.a(new b(collection), this.L, this.N);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cVar.dispose();
                    h.a.y0.a.e.error(th, this.F);
                    this.O.dispose();
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.H) {
                return;
            }
            try {
                Collection collection = (Collection) h.a.y0.b.b.a(this.K.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.H) {
                        return;
                    }
                    this.b0.add((U) collection);
                    this.O.a(new a(collection), this.L, this.N);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.F.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(h.a.i0<? super U> i0Var, U u) {
            i0Var.onNext(u);
        }
    }

    public q(h.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, Callable<U> callable, int i2, boolean z) {
        super(g0Var);
        this.f11562b = j2;
        this.f11563c = j3;
        this.f11564d = timeUnit;
        this.f11565e = j0Var;
        this.f11566f = callable;
        this.f11567g = i2;
        this.f11568h = z;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        if (this.f11562b == this.f11563c && this.f11567g == Integer.MAX_VALUE) {
            this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11566f, this.f11562b, this.f11564d, this.f11565e));
            return;
        }
        j0.c cVarA = this.f11565e.a();
        if (this.f11562b == this.f11563c) {
            this.a.subscribe(new a(new h.a.a1.m(i0Var), this.f11566f, this.f11562b, this.f11564d, this.f11567g, this.f11568h, cVarA));
        } else {
            this.a.subscribe(new c(new h.a.a1.m(i0Var), this.f11566f, this.f11562b, this.f11563c, this.f11564d, cVarA));
        }
    }
}
