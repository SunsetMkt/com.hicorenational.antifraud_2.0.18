package h.a.y0.e.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a4<T, B, V> extends h.a.y0.e.d.a<T, h.a.b0<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<B> f11223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super B, ? extends h.a.g0<V>> f11224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11225d;

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class a<T, V> extends h.a.a1.e<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, ?, V> f11226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.f1.j<T> f11227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11228d;

        a(c<T, ?, V> cVar, h.a.f1.j<T> jVar) {
            this.f11226b = cVar;
            this.f11227c = jVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11228d) {
                return;
            }
            this.f11228d = true;
            this.f11226b.a((a) this);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11228d) {
                h.a.c1.a.b(th);
            } else {
                this.f11228d = true;
                this.f11226b.a(th);
            }
        }

        @Override // h.a.i0
        public void onNext(V v) {
            if (this.f11228d) {
                return;
            }
            this.f11228d = true;
            dispose();
            this.f11226b.a((a) this);
        }
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class b<T, B> extends h.a.a1.e<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, B, ?> f11229b;

        b(c<T, B, ?> cVar) {
            this.f11229b = cVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11229b.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11229b.a(th);
        }

        @Override // h.a.i0
        public void onNext(B b2) {
            this.f11229b.a(b2);
        }
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class d<T, B> {
        final h.a.f1.j<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final B f11230b;

        d(h.a.f1.j<T> jVar, B b2) {
            this.a = jVar;
            this.f11230b = b2;
        }
    }

    public a4(h.a.g0<T> g0Var, h.a.g0<B> g0Var2, h.a.x0.o<? super B, ? extends h.a.g0<V>> oVar, int i2) {
        super(g0Var);
        this.f11223b = g0Var2;
        this.f11224c = oVar;
        this.f11225d = i2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.b0<T>> i0Var) {
        this.a.subscribe(new c(new h.a.a1.m(i0Var), this.f11223b, this.f11224c, this.f11225d));
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class c<T, B, V> extends h.a.y0.d.w<T, Object, h.a.b0<T>> implements h.a.u0.c {
        final h.a.g0<B> K;
        final h.a.x0.o<? super B, ? extends h.a.g0<V>> L;
        final int M;
        final h.a.u0.b N;
        h.a.u0.c O;
        final AtomicReference<h.a.u0.c> b0;
        final List<h.a.f1.j<T>> c0;
        final AtomicLong d0;

        c(h.a.i0<? super h.a.b0<T>> i0Var, h.a.g0<B> g0Var, h.a.x0.o<? super B, ? extends h.a.g0<V>> oVar, int i2) {
            super(i0Var, new h.a.y0.f.a());
            this.b0 = new AtomicReference<>();
            this.d0 = new AtomicLong();
            this.K = g0Var;
            this.L = oVar;
            this.M = i2;
            this.N = new h.a.u0.b();
            this.c0 = new ArrayList();
            this.d0.lazySet(1L);
        }

        @Override // h.a.y0.d.w, h.a.y0.j.r
        public void a(h.a.i0<? super h.a.b0<T>> i0Var, Object obj) {
        }

        void a(Throwable th) {
            this.O.dispose();
            this.N.dispose();
            onError(th);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            this.N.dispose();
            h.a.y0.a.d.dispose(this.b0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            h.a.y0.f.a aVar = (h.a.y0.f.a) this.G;
            h.a.i0<? super V> i0Var = this.F;
            List<h.a.f1.j<T>> list = this.c0;
            int iA = 1;
            while (true) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    f();
                    Throwable th = this.J;
                    if (th != null) {
                        Iterator<h.a.f1.j<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<h.a.f1.j<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    h.a.f1.j<T> jVar = dVar.a;
                    if (jVar != null) {
                        if (list.remove(jVar)) {
                            dVar.a.onComplete();
                            if (this.d0.decrementAndGet() == 0) {
                                f();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.H) {
                        h.a.f1.j<T> jVarI = h.a.f1.j.i(this.M);
                        list.add(jVarI);
                        i0Var.onNext(jVarI);
                        try {
                            h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.L.apply(dVar.f11230b), "The ObservableSource supplied is null");
                            a aVar2 = new a(this, jVarI);
                            if (this.N.b(aVar2)) {
                                this.d0.getAndIncrement();
                                g0Var.subscribe(aVar2);
                            }
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            this.H = true;
                            i0Var.onError(th2);
                        }
                    }
                } else {
                    Iterator<h.a.f1.j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(h.a.y0.j.q.getValue(objPoll));
                    }
                }
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
                g();
            }
            if (this.d0.decrementAndGet() == 0) {
                this.N.dispose();
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
                g();
            }
            if (this.d0.decrementAndGet() == 0) {
                this.N.dispose();
            }
            this.F.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (e()) {
                Iterator<h.a.f1.j<T>> it = this.c0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                this.F.onSubscribe(this);
                if (this.H) {
                    return;
                }
                b bVar = new b(this);
                if (this.b0.compareAndSet(null, bVar)) {
                    this.d0.getAndIncrement();
                    this.K.subscribe(bVar);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(B b2) {
            this.G.offer((U) new d(null, b2));
            if (b()) {
                g();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(a<T, V> aVar) {
            this.N.c(aVar);
            this.G.offer((U) new d(aVar.f11227c, null));
            if (b()) {
                g();
            }
        }
    }
}
