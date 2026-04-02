package h.a.y0.e.c;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MaybeFromAction.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0<T> extends h.a.s<T> implements Callable<T> {
    final h.a.x0.a a;

    public h0(h.a.x0.a aVar) {
        this.a = aVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            this.a.run();
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onComplete();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                h.a.c1.a.b(th);
            } else {
                vVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.a.run();
        return null;
    }
}
