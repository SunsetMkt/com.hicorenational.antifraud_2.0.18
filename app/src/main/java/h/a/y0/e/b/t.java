package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableCollectSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t<T, U> extends h.a.k0<U> implements h.a.y0.c.b<U> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f10979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.b<? super U, ? super T> f10980c;

    /* JADX INFO: compiled from: FlowableCollectSingle.java */
    static final class a<T, U> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.b<? super U, ? super T> f10981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f10982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f10983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10984e;

        a(h.a.n0<? super U> n0Var, U u, h.a.x0.b<? super U, ? super T> bVar) {
            this.a = n0Var;
            this.f10981b = bVar;
            this.f10982c = u;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10983d.cancel();
            this.f10983d = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10983d == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10984e) {
                return;
            }
            this.f10984e = true;
            this.f10983d = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(this.f10982c);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10984e) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10984e = true;
            this.f10983d = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10984e) {
                return;
            }
            try {
                this.f10981b.a(this.f10982c, t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10983d.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10983d, dVar)) {
                this.f10983d = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public t(h.a.l<T> lVar, Callable<? extends U> callable, h.a.x0.b<? super U, ? super T> bVar) {
        this.a = lVar;
        this.f10979b = callable;
        this.f10980c = bVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super U> n0Var) {
        try {
            this.a.a((h.a.q) new a(n0Var, h.a.y0.b.b.a(this.f10979b.call(), "The initialSupplier returned a null value"), this.f10980c));
        } catch (Throwable th) {
            h.a.y0.a.e.error(th, n0Var);
        }
    }

    @Override // h.a.y0.c.b
    public h.a.l<U> b() {
        return h.a.c1.a.a(new s(this.a, this.f10979b, this.f10980c));
    }
}
