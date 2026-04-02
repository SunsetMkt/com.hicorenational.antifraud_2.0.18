package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeDelayWithCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> extends h.a.s<T> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.i f11168b;

    /* JADX INFO: compiled from: MaybeDelayWithCompletable.java */
    static final class a<T> implements h.a.v<T> {
        final AtomicReference<h.a.u0.c> a;

        /* JADX INFO: renamed from: b */
        final h.a.v<? super T> f11169b;

        a(AtomicReference<h.a.u0.c> atomicReference, h.a.v<? super T> vVar) {
            this.a = atomicReference;
            this.f11169b = vVar;
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11169b.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11169b.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this.a, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11169b.onSuccess(t);
        }
    }

    /* JADX INFO: compiled from: MaybeDelayWithCompletable.java */
    static final class b<T> extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
        private static final long serialVersionUID = 703409937383992161L;
        final h.a.v<? super T> actual;
        final h.a.y<T> source;

        b(h.a.v<? super T> vVar, h.a.y<T> yVar) {
            this.actual = vVar;
            this.source = yVar;
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
            this.source.a(new a(this, this.actual));
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public o(h.a.y<T> yVar, h.a.i iVar) {
        this.a = yVar;
        this.f11168b = iVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.f11168b.a(new b(vVar, this.a));
    }
}
