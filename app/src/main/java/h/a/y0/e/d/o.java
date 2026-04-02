package h.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T, U extends Collection<? super T>, B> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends h.a.g0<B>> f11521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f11522c;

    /* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
    static final class a<T, U extends Collection<? super T>, B> extends h.a.a1.e<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f11523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11524c;

        a(b<T, U, B> bVar) {
            this.f11523b = bVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11524c) {
                return;
            }
            this.f11524c = true;
            this.f11523b.g();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11524c) {
                h.a.c1.a.b(th);
            } else {
                this.f11524c = true;
                this.f11523b.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(B b2) {
            if (this.f11524c) {
                return;
            }
            this.f11524c = true;
            dispose();
            this.f11523b.g();
        }
    }

    /* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
    static final class b<T, U extends Collection<? super T>, B> extends h.a.y0.d.w<T, U, U> implements h.a.i0<T>, h.a.u0.c {
        final Callable<U> K;
        final Callable<? extends h.a.g0<B>> L;
        h.a.u0.c M;
        final AtomicReference<h.a.u0.c> N;
        U O;

        b(h.a.i0<? super U> i0Var, Callable<U> callable, Callable<? extends h.a.g0<B>> callable2) {
            super(i0Var, new h.a.y0.f.a());
            this.N = new AtomicReference<>();
            this.K = callable;
            this.L = callable2;
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
            this.M.dispose();
            f();
            if (b()) {
                this.G.clear();
            }
        }

        void f() {
            h.a.y0.a.d.dispose(this.N);
        }

        void g() {
            try {
                U u = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                try {
                    h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.L.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (this.N.compareAndSet(this.N.get(), aVar)) {
                        synchronized (this) {
                            U u2 = this.O;
                            if (u2 == null) {
                                return;
                            }
                            this.O = u;
                            g0Var.subscribe(aVar);
                            a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.H = true;
                    this.M.dispose();
                    this.F.onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                dispose();
                this.F.onError(th2);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            synchronized (this) {
                U u = this.O;
                if (u == null) {
                    return;
                }
                this.O = null;
                this.G.offer(u);
                this.I = true;
                if (b()) {
                    h.a.y0.j.v.a((h.a.y0.c.n) this.G, (h.a.i0) this.F, false, (h.a.u0.c) this, (h.a.y0.j.r) this);
                }
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            dispose();
            this.F.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            synchronized (this) {
                U u = this.O;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.M, cVar)) {
                this.M = cVar;
                h.a.i0<? super V> i0Var = this.F;
                try {
                    this.O = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    try {
                        h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.L.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.N.set(aVar);
                        i0Var.onSubscribe(this);
                        if (this.H) {
                            return;
                        }
                        g0Var.subscribe(aVar);
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.H = true;
                        cVar.dispose();
                        h.a.y0.a.e.error(th, i0Var);
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    this.H = true;
                    cVar.dispose();
                    h.a.y0.a.e.error(th2, i0Var);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(h.a.i0<? super U> i0Var, U u) {
            this.F.onNext((Object) u);
        }
    }

    public o(h.a.g0<T> g0Var, Callable<? extends h.a.g0<B>> callable, Callable<U> callable2) {
        super(g0Var);
        this.f11521b = callable;
        this.f11522c = callable2;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11522c, this.f11521b));
    }
}
