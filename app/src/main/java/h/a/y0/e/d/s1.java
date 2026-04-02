package h.a.y0.e.d;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableLastSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s1<T> extends h.a.k0<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f11613b;

    /* JADX INFO: compiled from: ObservableLastSingle.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f11614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f11616d;

        a(h.a.n0<? super T> n0Var, T t) {
            this.a = n0Var;
            this.f11614b = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11615c.dispose();
            this.f11615c = h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11615c == h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11615c = h.a.y0.a.d.DISPOSED;
            T t = this.f11616d;
            if (t != null) {
                this.f11616d = null;
                this.a.onSuccess(t);
                return;
            }
            T t2 = this.f11614b;
            if (t2 != null) {
                this.a.onSuccess(t2);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11615c = h.a.y0.a.d.DISPOSED;
            this.f11616d = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11616d = t;
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11615c, cVar)) {
                this.f11615c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public s1(h.a.g0<T> g0Var, T t) {
        this.a = g0Var;
        this.f11613b = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.subscribe(new a(n0Var, this.f11613b));
    }
}
