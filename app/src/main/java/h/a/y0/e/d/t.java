package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableCollectSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t<T, U> extends h.a.k0<U> implements h.a.y0.c.d<U> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f11625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.b<? super U, ? super T> f11626c;

    /* JADX INFO: compiled from: ObservableCollectSingle.java */
    static final class a<T, U> implements h.a.i0<T>, h.a.u0.c {
        final h.a.n0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.b<? super U, ? super T> f11627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f11628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11630e;

        a(h.a.n0<? super U> n0Var, U u, h.a.x0.b<? super U, ? super T> bVar) {
            this.a = n0Var;
            this.f11627b = bVar;
            this.f11628c = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11629d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11629d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11630e) {
                return;
            }
            this.f11630e = true;
            this.a.onSuccess(this.f11628c);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11630e) {
                h.a.c1.a.b(th);
            } else {
                this.f11630e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11630e) {
                return;
            }
            try {
                this.f11627b.a(this.f11628c, t);
            } catch (Throwable th) {
                this.f11629d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11629d, cVar)) {
                this.f11629d = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public t(h.a.g0<T> g0Var, Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        this.a = g0Var;
        this.f11625b = callable;
        this.f11626c = bVar;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<U> a() {
        return h.a.c1.a.a(new s(this.a, this.f11625b, this.f11626c));
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super U> n0Var) {
        try {
            this.a.subscribe(new a(n0Var, h.a.y0.b.b.a(this.f11625b.call(), "The initialSupplier returned a null value"), this.f11626c));
        } catch (Throwable th) {
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
