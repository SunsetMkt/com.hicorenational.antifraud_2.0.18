package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableMergeDelayErrorArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends h.a.c {
    final h.a.i[] a;

    /* JADX INFO: compiled from: CompletableMergeDelayErrorArray.java */
    static final class a implements h.a.f {
        final h.a.f a;

        /* JADX INFO: renamed from: b */
        final h.a.u0.b f10497b;

        /* JADX INFO: renamed from: c */
        final h.a.y0.j.c f10498c;

        /* JADX INFO: renamed from: d */
        final AtomicInteger f10499d;

        a(h.a.f fVar, h.a.u0.b bVar, h.a.y0.j.c cVar, AtomicInteger atomicInteger) {
            this.a = fVar;
            this.f10497b = bVar;
            this.f10498c = cVar;
            this.f10499d = atomicInteger;
        }

        void a() {
            if (this.f10499d.decrementAndGet() == 0) {
                Throwable thTerminate = this.f10498c.terminate();
                if (thTerminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(thTerminate);
                }
            }
        }

        @Override // h.a.f
        public void onComplete() {
            a();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            if (this.f10498c.addThrowable(th)) {
                a();
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.f10497b.b(cVar);
        }
    }

    public a0(h.a.i[] iVarArr) {
        this.a = iVarArr;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        h.a.u0.b bVar = new h.a.u0.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.a.length + 1);
        h.a.y0.j.c cVar = new h.a.y0.j.c();
        fVar.onSubscribe(bVar);
        for (h.a.i iVar : this.a) {
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar == null) {
                cVar.addThrowable(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                iVar.a(new a(fVar, bVar, cVar, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable thTerminate = cVar.terminate();
            if (thTerminate == null) {
                fVar.onComplete();
            } else {
                fVar.onError(thTerminate);
            }
        }
    }
}
