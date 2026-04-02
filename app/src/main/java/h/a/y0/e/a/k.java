package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableDoFinally.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class k extends h.a.c {
    final h.a.i a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.a f10542b;

    /* JADX INFO: compiled from: CompletableDoFinally.java */
    static final class a extends AtomicInteger implements h.a.f, h.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final h.a.f actual;

        /* JADX INFO: renamed from: d */
        h.a.u0.c f10543d;
        final h.a.x0.a onFinally;

        a(h.a.f fVar, h.a.x0.a aVar) {
            this.actual = fVar;
            this.onFinally = aVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10543d.dispose();
            runFinally();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10543d.isDisposed();
        }

        @Override // h.a.f
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f10543d, cVar)) {
                this.f10543d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }
    }

    public k(h.a.i iVar, h.a.x0.a aVar) {
        this.a = iVar;
        this.f10542b = aVar;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a(new a(fVar, this.f10542b));
    }
}
