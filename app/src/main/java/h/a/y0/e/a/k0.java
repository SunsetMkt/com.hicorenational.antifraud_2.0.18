package h.a.y0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends h.a.c {
    final long a;

    /* JADX INFO: renamed from: b */
    final TimeUnit f10544b;

    /* JADX INFO: renamed from: c */
    final h.a.j0 f10545c;

    /* JADX INFO: compiled from: CompletableTimer.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final h.a.f actual;

        a(h.a.f fVar) {
            this.actual = fVar;
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
            this.actual.onComplete();
        }

        void setFuture(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this, cVar);
        }
    }

    public k0(long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.a = j2;
        this.f10544b = timeUnit;
        this.f10545c = j0Var;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        a aVar = new a(fVar);
        fVar.onSubscribe(aVar);
        aVar.setFuture(this.f10545c.a(aVar, this.a, this.f10544b));
    }
}
