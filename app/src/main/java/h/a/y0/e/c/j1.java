package h.a.y0.e.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j1 extends h.a.s<Long> {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f11147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f11148c;

    /* JADX INFO: compiled from: MaybeTimer.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final h.a.v<? super Long> actual;

        a(h.a.v<? super Long> vVar) {
            this.actual = vVar;
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

    public j1(long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.a = j2;
        this.f11147b = timeUnit;
        this.f11148c = j0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super Long> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.setFuture(this.f11148c.a(aVar, this.a, this.f11147b));
    }
}
