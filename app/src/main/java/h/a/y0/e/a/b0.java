package h.a.y0.e.a;

import h.a.y0.e.a.a0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableMergeDelayErrorIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends h.a.c {
    final Iterable<? extends h.a.i> a;

    public b0(Iterable<? extends h.a.i> iterable) {
        this.a = iterable;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        h.a.u0.b bVar = new h.a.u0.b();
        fVar.onSubscribe(bVar);
        try {
            Iterator it = (Iterator) h.a.y0.b.b.a(this.a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            h.a.y0.j.c cVar = new h.a.y0.j.c();
            while (!bVar.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (bVar.isDisposed()) {
                            return;
                        }
                        try {
                            h.a.i iVar = (h.a.i) h.a.y0.b.b.a(it.next(), "The iterator returned a null CompletableSource");
                            if (bVar.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            iVar.a(new a0.a(fVar, bVar, cVar, atomicInteger));
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            cVar.addThrowable(th);
                        }
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    cVar.addThrowable(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable thTerminate = cVar.terminate();
                    if (thTerminate == null) {
                        fVar.onComplete();
                        return;
                    } else {
                        fVar.onError(thTerminate);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            fVar.onError(th3);
        }
    }
}
