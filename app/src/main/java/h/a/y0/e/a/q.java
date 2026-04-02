package h.a.y0.e.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CompletableFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends h.a.c {
    final Callable<?> a;

    public q(Callable<?> callable) {
        this.a = callable;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        fVar.onSubscribe(cVarB);
        try {
            this.a.call();
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onComplete();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                return;
            }
            fVar.onError(th);
        }
    }
}
