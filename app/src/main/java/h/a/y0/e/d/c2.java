package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservablePublishSelector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c2<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super h.a.b0<T>, ? extends h.a.g0<R>> f11270b;

    /* JADX INFO: compiled from: ObservablePublishSelector.java */
    static final class a<T, R> implements h.a.i0<T> {
        final h.a.f1.e<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11271b;

        a(h.a.f1.e<T> eVar, AtomicReference<h.a.u0.c> atomicReference) {
            this.a = eVar;
            this.f11271b = atomicReference;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.f11271b, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservablePublishSelector.java */
    static final class b<T, R> extends AtomicReference<h.a.u0.c> implements h.a.i0<R>, h.a.u0.c {
        private static final long serialVersionUID = 854110278590336484L;
        final h.a.i0<? super R> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11272d;

        b(h.a.i0<? super R> i0Var) {
            this.actual = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11272d.dispose();
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11272d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.y0.a.d.dispose(this);
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this);
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11272d, cVar)) {
                this.f11272d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public c2(h.a.g0<T> g0Var, h.a.x0.o<? super h.a.b0<T>, ? extends h.a.g0<R>> oVar) {
        super(g0Var);
        this.f11270b = oVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        h.a.f1.e eVarT = h.a.f1.e.T();
        try {
            h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.f11270b.apply(eVarT), "The selector returned a null ObservableSource");
            b bVar = new b(i0Var);
            g0Var.subscribe(bVar);
            this.a.subscribe(new a(eVarT, bVar));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
