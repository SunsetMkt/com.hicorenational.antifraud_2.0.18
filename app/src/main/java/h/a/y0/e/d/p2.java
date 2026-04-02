package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableRetryWhen.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super h.a.b0<Throwable>, ? extends h.a.g0<?>> f11557b;

    /* JADX INFO: compiled from: ObservableRetryWhen.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final h.a.i0<? super T> actual;
        final h.a.f1.i<Throwable> signaller;
        final h.a.g0<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final a<T>.C0215a inner = new C0215a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11558d = new AtomicReference<>();

        /* JADX INFO: renamed from: h.a.y0.e.d.p2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableRetryWhen.java */
        final class C0215a extends AtomicReference<h.a.u0.c> implements h.a.i0<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            C0215a() {
            }

            @Override // h.a.i0
            public void onComplete() {
                a.this.innerComplete();
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                a.this.innerError(th);
            }

            @Override // h.a.i0
            public void onNext(Object obj) {
                a.this.innerNext();
            }

            @Override // h.a.i0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }
        }

        a(h.a.i0<? super T> i0Var, h.a.f1.i<Throwable> iVar, h.a.g0<T> g0Var) {
            this.actual = i0Var;
            this.signaller = iVar;
            this.source = g0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.f11558d);
            h.a.y0.a.d.dispose(this.inner);
        }

        void innerComplete() {
            h.a.y0.a.d.dispose(this.f11558d);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        void innerError(Throwable th) {
            h.a.y0.a.d.dispose(this.f11558d);
            h.a.y0.j.l.a((h.a.i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext() {
            subscribeNext();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(this.f11558d.get());
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.y0.a.d.dispose(this.inner);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            h.a.y0.j.l.a(this.actual, t, this, this.error);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this.f11558d, cVar);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public p2(h.a.g0<T> g0Var, h.a.x0.o<? super h.a.b0<Throwable>, ? extends h.a.g0<?>> oVar) {
        super(g0Var);
        this.f11557b = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        h.a.f1.i<T> iVarS = h.a.f1.e.T().S();
        try {
            h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.f11557b.apply(iVarS), "The handler returned a null ObservableSource");
            a aVar = new a(i0Var, iVarS, this.a);
            i0Var.onSubscribe(aVar);
            g0Var.subscribe(aVar.inner);
            aVar.subscribeNext();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
