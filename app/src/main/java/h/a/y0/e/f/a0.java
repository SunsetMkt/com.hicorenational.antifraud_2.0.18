package h.a.y0.e.f;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SingleFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0<T> extends h.a.k0<T> {
    final Callable<? extends T> a;

    public a0(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        h.a.u0.c cVarB = h.a.u0.d.b();
        n0Var.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            defpackage.a aVar = (Object) h.a.y0.b.b.a((Object) this.a.call(), "The callable returned a null value");
            if (cVarB.isDisposed()) {
                return;
            }
            n0Var.onSuccess(aVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (cVarB.isDisposed()) {
                h.a.c1.a.b(th);
            } else {
                n0Var.onError(th);
            }
        }
    }
}
