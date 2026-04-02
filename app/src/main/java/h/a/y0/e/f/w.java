package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleFlatMapCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T> extends h.a.c {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11898b;

    /* JADX INFO: compiled from: SingleFlatMapCompletable.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.f, h.a.u0.c {
        private static final long serialVersionUID = -2177128922851101253L;
        final h.a.f actual;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;

        a(h.a.f fVar, h.a.x0.o<? super T, ? extends h.a.i> oVar) {
            this.actual = fVar;
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

        @Override // h.a.f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.i iVar = (h.a.i) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                iVar.a(this);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    public w(h.a.q0<T> q0Var, h.a.x0.o<? super T, ? extends h.a.i> oVar) {
        this.a = q0Var;
        this.f11898b = oVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar, this.f11898b);
        fVar.onSubscribe(aVar);
        this.a.a(aVar);
    }
}
