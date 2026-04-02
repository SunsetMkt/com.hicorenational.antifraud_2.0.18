package h.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWindowBoundarySupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b4<T, B> extends h.a.y0.e.d.a<T, h.a.b0<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends h.a.g0<B>> f11251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11252c;

    /* JADX INFO: compiled from: ObservableWindowBoundarySupplier.java */
    static final class a<T, B> extends h.a.a1.e<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, B> f11253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11254c;

        a(b<T, B> bVar) {
            this.f11253b = bVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11254c) {
                return;
            }
            this.f11254c = true;
            this.f11253b.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11254c) {
                h.a.c1.a.b(th);
            } else {
                this.f11254c = true;
                this.f11253b.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(B b2) {
            if (this.f11254c) {
                return;
            }
            this.f11254c = true;
            dispose();
            this.f11253b.g();
        }
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySupplier.java */
    static final class b<T, B> extends h.a.y0.d.w<T, Object, h.a.b0<T>> implements h.a.u0.c {
        static final Object c0 = new Object();
        final Callable<? extends h.a.g0<B>> K;
        final int L;
        h.a.u0.c M;
        final AtomicReference<h.a.u0.c> N;
        h.a.f1.j<T> O;
        final AtomicLong b0;

        b(h.a.i0<? super h.a.b0<T>> i0Var, Callable<? extends h.a.g0<B>> callable, int i2) {
            super(i0Var, new h.a.y0.f.a());
            this.N = new AtomicReference<>();
            this.b0 = new AtomicLong();
            this.K = callable;
            this.L = i2;
            this.b0.lazySet(1L);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.H = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void f() {
            h.a.y0.f.a aVar = (h.a.y0.f.a) this.G;
            h.a.i0<? super V> i0Var = this.F;
            h.a.f1.j<T> jVar = this.O;
            int iA = 1;
            while (true) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    h.a.y0.a.d.dispose(this.N);
                    Throwable th = this.J;
                    if (th != null) {
                        jVar.onError(th);
                        return;
                    } else {
                        jVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == c0) {
                    jVar.onComplete();
                    if (this.b0.decrementAndGet() == 0) {
                        h.a.y0.a.d.dispose(this.N);
                        return;
                    }
                    if (this.H) {
                        continue;
                    } else {
                        try {
                            h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.K.call(), "The ObservableSource supplied is null");
                            h.a.f1.j<T> jVarI = h.a.f1.j.i(this.L);
                            this.b0.getAndIncrement();
                            this.O = jVarI;
                            i0Var.onNext(jVarI);
                            a aVar2 = new a(this);
                            AtomicReference<h.a.u0.c> atomicReference = this.N;
                            if (atomicReference.compareAndSet(atomicReference.get(), aVar2)) {
                                g0Var.subscribe(aVar2);
                            }
                            jVar = jVarI;
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            h.a.y0.a.d.dispose(this.N);
                            i0Var.onError(th2);
                            return;
                        }
                    }
                } else {
                    jVar.onNext(h.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void g() {
            this.G.offer((U) c0);
            if (b()) {
                f();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.I) {
                return;
            }
            this.I = true;
            if (b()) {
                f();
            }
            if (this.b0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.N);
            }
            this.F.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.I) {
                h.a.c1.a.b(th);
                return;
            }
            this.J = th;
            this.I = true;
            if (b()) {
                f();
            }
            if (this.b0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.N);
            }
            this.F.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (e()) {
                this.O.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.M, cVar)) {
                this.M = cVar;
                h.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                if (this.H) {
                    return;
                }
                try {
                    h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.K.call(), "The first window ObservableSource supplied is null");
                    h.a.f1.j<T> jVarI = h.a.f1.j.i(this.L);
                    this.O = jVarI;
                    i0Var.onNext(jVarI);
                    a aVar = new a(this);
                    if (this.N.compareAndSet(null, aVar)) {
                        this.b0.getAndIncrement();
                        g0Var.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cVar.dispose();
                    i0Var.onError(th);
                }
            }
        }
    }

    public b4(h.a.g0<T> g0Var, Callable<? extends h.a.g0<B>> callable, int i2) {
        super(g0Var);
        this.f11251b = callable;
        this.f11252c = i2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.b0<T>> i0Var) {
        this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11251b, this.f11252c));
    }
}
