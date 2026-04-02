package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleDelayWithPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T, U> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11846b;

    /* JADX INFO: compiled from: SingleDelayWithPublisher.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.q<U>, h.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final h.a.n0<? super T> actual;
        boolean done;
        j.d.d s;
        final h.a.q0<T> source;

        a(h.a.n0<? super T> n0Var, h.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.cancel();
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new h.a.y0.d.a0(this, this.actual));
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(U u) {
            this.s.cancel();
            onComplete();
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public i(h.a.q0<T> q0Var, j.d.b<U> bVar) {
        this.a = q0Var;
        this.f11846b = bVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.f11846b.subscribe(new a(n0Var, this.a));
    }
}
