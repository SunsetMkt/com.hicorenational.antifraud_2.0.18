package h.a.y0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g4 extends h.a.l<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f10684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10686d;

    /* JADX INFO: compiled from: FlowableTimer.java */
    static final class a extends AtomicReference<h.a.u0.c> implements j.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final j.d.c<? super Long> actual;
        volatile boolean requested;

        a(j.d.c<? super Long> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != h.a.y0.a.d.DISPOSED) {
                if (!this.requested) {
                    lazySet(h.a.y0.a.e.INSTANCE);
                    this.actual.onError(new h.a.v0.c("Can't deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(0L);
                    lazySet(h.a.y0.a.e.INSTANCE);
                    this.actual.onComplete();
                }
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.trySet(this, cVar);
        }
    }

    public g4(long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f10685c = j2;
        this.f10686d = timeUnit;
        this.f10684b = j0Var;
    }

    @Override // h.a.l
    public void d(j.d.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        aVar.setResource(this.f10684b.a(aVar, this.f10685c, this.f10686d));
    }
}
