package h.a.y0.e.c;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MaybeFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0<T> extends h.a.s<T> implements Callable<T> {
    final Callable<? extends T> a;

    public i0(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            T tCall = this.a.call();
            if (cVarB.isDisposed()) {
                return;
            }
            if (tCall == null) {
                vVar.onComplete();
            } else {
                vVar.onSuccess(tCall);
            }
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
        return this.a.call();
    }
}
