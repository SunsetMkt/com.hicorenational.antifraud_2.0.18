package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleDelayWithObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T, U> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<U> f11843b;

    /* JADX INFO: compiled from: SingleDelayWithObservable.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.i0<U>, h.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final h.a.n0<? super T> actual;
        boolean done;
        final h.a.q0<T> source;

        a(h.a.n0<? super T> n0Var, h.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new h.a.y0.d.a0(this, this.actual));
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.set(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public h(h.a.q0<T> q0Var, h.a.g0<U> g0Var) {
        this.a = q0Var;
        this.f11843b = g0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.f11843b.subscribe(new a(n0Var, this.a));
    }
}
