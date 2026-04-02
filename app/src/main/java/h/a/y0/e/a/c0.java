package h.a.y0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableMergeIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends h.a.c {
    final Iterable<? extends h.a.i> a;

    /* JADX INFO: compiled from: CompletableMergeIterable.java */
    static final class a extends AtomicBoolean implements h.a.f {
        private static final long serialVersionUID = -7730517613164279224L;
        final h.a.f actual;
        final h.a.u0.b set;
        final AtomicInteger wip;

        a(h.a.f fVar, h.a.u0.b bVar, AtomicInteger atomicInteger) {
            this.actual = fVar;
            this.set = bVar;
            this.wip = atomicInteger;
        }

        @Override // h.a.f
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
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

    public c0(Iterable<? extends h.a.i> iterable) {
        this.a = iterable;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        h.a.u0.b bVar = new h.a.u0.b();
        fVar.onSubscribe(bVar);
        try {
            Iterator it = (Iterator) h.a.y0.b.b.a(this.a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            a aVar = new a(fVar, bVar, atomicInteger);
            while (!bVar.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        aVar.onComplete();
                        return;
                    }
                    if (bVar.isDisposed()) {
                        return;
                    }
                    try {
                        h.a.i iVar = (h.a.i) h.a.y0.b.b.a(it.next(), "The iterator returned a null CompletableSource");
                        if (bVar.isDisposed()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        iVar.a(aVar);
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        bVar.dispose();
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    bVar.dispose();
                    aVar.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            fVar.onError(th3);
        }
    }
}
