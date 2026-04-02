package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableCollect.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T, U> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f11607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.b<? super U, ? super T> f11608c;

    /* JADX INFO: compiled from: ObservableCollect.java */
    static final class a<T, U> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.b<? super U, ? super T> f11609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f11610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11612e;

        a(h.a.i0<? super U> i0Var, U u, h.a.x0.b<? super U, ? super T> bVar) {
            this.a = i0Var;
            this.f11609b = bVar;
            this.f11610c = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11611d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11611d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11612e) {
                return;
            }
            this.f11612e = true;
            this.a.onNext(this.f11610c);
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11612e) {
                h.a.c1.a.b(th);
            } else {
                this.f11612e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11612e) {
                return;
            }
            try {
                this.f11609b.a(this.f11610c, t);
            } catch (Throwable th) {
                this.f11611d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11611d, cVar)) {
                this.f11611d = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public s(h.a.g0<T> g0Var, Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        super(g0Var);
        this.f11607b = callable;
        this.f11608c = bVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        try {
            this.a.subscribe(new a(i0Var, h.a.y0.b.b.a(this.f11607b.call(), "The initialSupplier returned a null value"), this.f11608c));
        } catch (Throwable th) {
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
