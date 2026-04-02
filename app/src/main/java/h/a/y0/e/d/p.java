package h.a.y0.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T, U extends Collection<? super T>, B> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<B> f11545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f11546c;

    /* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
    static final class a<T, U extends Collection<? super T>, B> extends h.a.a1.e<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f11547b;

        a(b<T, U, B> bVar) {
            this.f11547b = bVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11547b.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11547b.onError(th);
        }

        @Override // h.a.i0
        public void onNext(B b2) {
            this.f11547b.f();
        }
    }

    /* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
    static final class b<T, U extends Collection<? super T>, B> extends h.a.y0.d.w<T, U, U> implements h.a.i0<T>, h.a.u0.c {
        final Callable<U> K;
        final h.a.g0<B> L;
        h.a.u0.c M;
        h.a.u0.c N;
        U O;

        b(h.a.i0<? super U> i0Var, Callable<U> callable, h.a.g0<B> g0Var) {
            super(i0Var, new h.a.y0.f.a());
            this.K = callable;
            this.L = g0Var;
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
            this.N.dispose();
            this.M.dispose();
            if (b()) {
                this.G.clear();
            }
        }

        void f() {
            try {
                U u = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.O;
                    if (u2 == null) {
                        return;
                    }
                    this.O = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dispose();
                this.F.onError(th);
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
                try {
                    this.O = (U) h.a.y0.b.b.a(this.K.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.N = aVar;
                    this.F.onSubscribe(this);
                    if (this.H) {
                        return;
                    }
                    this.L.subscribe(aVar);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.H = true;
                    cVar.dispose();
                    h.a.y0.a.e.error(th, this.F);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(h.a.i0<? super U> i0Var, U u) {
            this.F.onNext((Object) u);
        }
    }

    public p(h.a.g0<T> g0Var, h.a.g0<B> g0Var2, Callable<U> callable) {
        super(g0Var);
        this.f11545b = g0Var2;
        this.f11546c = callable;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11546c, this.f11545b));
    }
}
