package h.a.y0.e.d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t3 extends h.a.b0<Long> {
    final h.a.j0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11640c;

    /* JADX INFO: compiled from: ObservableTimer.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final h.a.i0<? super Long> actual;

        a(h.a.i0<? super Long> i0Var) {
            this.actual = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.actual.onNext(0L);
            lazySet(h.a.y0.a.e.INSTANCE);
            this.actual.onComplete();
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.trySet(this, cVar);
        }
    }

    public t3(long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f11639b = j2;
        this.f11640c = timeUnit;
        this.a = j0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super Long> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        aVar.setResource(this.a.a(aVar, this.f11639b, this.f11640c));
    }
}
