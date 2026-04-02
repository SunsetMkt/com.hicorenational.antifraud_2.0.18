package h.a.y0.e.f;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends h.a.k0<Long> {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f11872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f11873c;

    /* JADX INFO: compiled from: SingleTimer.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final h.a.n0<? super Long> actual;

        a(h.a.n0<? super Long> n0Var) {
            this.actual = n0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.actual.onSuccess(0L);
        }

        void setFuture(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this, cVar);
        }
    }

    public p0(long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.a = j2;
        this.f11872b = timeUnit;
        this.f11873c = j0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Long> n0Var) {
        a aVar = new a(n0Var);
        n0Var.onSubscribe(aVar);
        aVar.setFuture(this.f11873c.a(aVar, this.a, this.f11872b));
    }
}
