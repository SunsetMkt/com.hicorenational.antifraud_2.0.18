package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableScanSeed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u2<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f11651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<R> f11652c;

    /* JADX INFO: compiled from: ObservableScanSeed.java */
    static final class a<T, R> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<R, ? super T, R> f11653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        R f11654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11655d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11656e;

        a(h.a.i0<? super R> i0Var, h.a.x0.c<R, ? super T, R> cVar, R r) {
            this.a = i0Var;
            this.f11653b = cVar;
            this.f11654c = r;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11655d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11655d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11656e) {
                return;
            }
            this.f11656e = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11656e) {
                h.a.c1.a.b(th);
            } else {
                this.f11656e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11656e) {
                return;
            }
            try {
                R r = (R) h.a.y0.b.b.a(this.f11653b.apply(this.f11654c, t), "The accumulator returned a null value");
                this.f11654c = r;
                this.a.onNext(r);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11655d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11655d, cVar)) {
                this.f11655d = cVar;
                this.a.onSubscribe(this);
                this.a.onNext(this.f11654c);
            }
        }
    }

    public u2(h.a.g0<T> g0Var, Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        super(g0Var);
        this.f11651b = cVar;
        this.f11652c = callable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        try {
            this.a.subscribe(new a(i0Var, this.f11651b, h.a.y0.b.b.a(this.f11652c.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
