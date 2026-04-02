package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeFlatMapSingleElement.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class f0<T, R> extends h.a.s<R> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> f11131b;

    /* JADX INFO: compiled from: MaybeFlatMapSingleElement.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4827726964688405508L;
        final h.a.v<? super R> actual;
        final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> mapper;

        a(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
            this.actual = vVar;
            this.mapper = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                ((h.a.q0) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource")).a(new b(this, this.actual));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: MaybeFlatMapSingleElement.java */
    static final class b<R> implements h.a.n0<R> {
        final AtomicReference<h.a.u0.c> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.v<? super R> f11132b;

        b(AtomicReference<h.a.u0.c> atomicReference, h.a.v<? super R> vVar) {
            this.a = atomicReference;
            this.f11132b = vVar;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11132b.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this.a, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(R r) {
            this.f11132b.onSuccess(r);
        }
    }

    public f0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        this.a = yVar;
        this.f11131b = oVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new a(vVar, this.f11131b));
    }
}
