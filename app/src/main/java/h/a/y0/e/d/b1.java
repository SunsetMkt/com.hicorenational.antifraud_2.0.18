package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b1<T> extends h.a.b0<T> implements Callable<T> {
    final Callable<? extends T> a;

    public b1(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) h.a.y0.b.b.a((Object) this.a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.d.l lVar = new h.a.y0.d.l(i0Var);
        i0Var.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            lVar.complete(h.a.y0.b.b.a((Object) this.a.call(), "Callable returned null"));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            if (lVar.isDisposed()) {
                h.a.c1.a.b(th);
            } else {
                i0Var.onError(th);
            }
        }
    }
}
