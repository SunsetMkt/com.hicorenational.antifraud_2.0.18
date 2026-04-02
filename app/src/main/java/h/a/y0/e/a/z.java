package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableMergeArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z extends h.a.c {
    final h.a.i[] a;

    /* JADX INFO: compiled from: CompletableMergeArray.java */
    static final class a extends AtomicInteger implements h.a.f {
        private static final long serialVersionUID = -8360547806504310570L;
        final h.a.f actual;
        final AtomicBoolean once;
        final h.a.u0.b set;

        a(h.a.f fVar, AtomicBoolean atomicBoolean, h.a.u0.b bVar, int i2) {
            this.actual = fVar;
            this.once = atomicBoolean;
            this.set = bVar;
            lazySet(i2);
        }

        @Override // h.a.f
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.set.b(cVar);
        }
    }

    public z(h.a.i[] iVarArr) {
        this.a = iVarArr;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        h.a.u0.b bVar = new h.a.u0.b();
        a aVar = new a(fVar, new AtomicBoolean(), bVar, this.a.length + 1);
        fVar.onSubscribe(bVar);
        for (h.a.i iVar : this.a) {
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar == null) {
                bVar.dispose();
                aVar.onError(new NullPointerException("A completable source is null"));
                return;
            }
            iVar.a(aVar);
        }
        aVar.onComplete();
    }
}
