package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableConcatArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends h.a.c {
    final h.a.i[] a;

    /* JADX INFO: compiled from: CompletableConcatArray.java */
    static final class a extends AtomicInteger implements h.a.f {
        private static final long serialVersionUID = -7965400327305809232L;
        final h.a.f actual;
        int index;
        final h.a.y0.a.k sd = new h.a.y0.a.k();
        final h.a.i[] sources;

        a(h.a.f fVar, h.a.i[] iVarArr) {
            this.actual = fVar;
            this.sources = iVarArr;
        }

        void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                h.a.i[] iVarArr = this.sources;
                while (!this.sd.isDisposed()) {
                    int i2 = this.index;
                    this.index = i2 + 1;
                    if (i2 == iVarArr.length) {
                        this.actual.onComplete();
                        return;
                    } else {
                        iVarArr[i2].a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // h.a.f
        public void onComplete() {
            next();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.sd.replace(cVar);
        }
    }

    public d(h.a.i[] iVarArr) {
        this.a = iVarArr;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        a aVar = new a(fVar, this.a);
        fVar.onSubscribe(aVar.sd);
        aVar.next();
    }
}
