package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleFlatMapMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z<T, R> extends h.a.s<R> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> f11904b;

    /* JADX INFO: compiled from: SingleFlatMapMaybe.java */
    static final class a<R> implements h.a.v<R> {
        final AtomicReference<h.a.u0.c> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.v<? super R> f11905b;

        a(AtomicReference<h.a.u0.c> atomicReference, h.a.v<? super R> vVar) {
            this.a = atomicReference;
            this.f11905b = vVar;
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11905b.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11905b.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this.a, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(R r) {
            this.f11905b.onSuccess(r);
        }
    }

    /* JADX INFO: compiled from: SingleFlatMapMaybe.java */
    static final class b<T, R> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = -5843758257109742742L;
        final h.a.v<? super R> actual;
        final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> mapper;

        b(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar) {
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

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.y yVar = (h.a.y) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                yVar.a(new a(this, this.actual));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public z(h.a.q0<? extends T> q0Var, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar) {
        this.f11904b = oVar;
        this.a = q0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new b(vVar, this.f11904b));
    }
}
