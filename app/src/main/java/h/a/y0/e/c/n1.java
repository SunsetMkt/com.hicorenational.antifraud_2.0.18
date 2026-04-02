package h.a.y0.e.c;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: MaybeToSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n1<T> extends h.a.k0<T> implements h.a.y0.c.f<T> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f11165b;

    /* JADX INFO: compiled from: MaybeToSingle.java */
    static final class a<T> implements h.a.v<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f11166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11167c;

        a(h.a.n0<? super T> n0Var, T t) {
            this.a = n0Var;
            this.f11166b = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11167c.dispose();
            this.f11167c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11167c.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.f11167c = h.a.y0.a.d.DISPOSED;
            T t = this.f11166b;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.f11167c = h.a.y0.a.d.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11167c, cVar)) {
                this.f11167c = cVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.f11167c = h.a.y0.a.d.DISPOSED;
            this.a.onSuccess(t);
        }
    }

    public n1(h.a.y<T> yVar, T t) {
        this.a = yVar;
        this.f11165b = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11165b));
    }

    @Override // h.a.y0.c.f
    public h.a.y<T> source() {
        return this.a;
    }
}
