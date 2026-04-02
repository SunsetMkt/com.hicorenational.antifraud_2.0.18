package h.a.y0.e.f;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SingleDefer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends h.a.k0<T> {
    final Callable<? extends h.a.q0<? extends T>> a;

    public e(Callable<? extends h.a.q0<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        try {
            ((h.a.q0) h.a.y0.b.b.a(this.a.call(), "The singleSupplier returned a null SingleSource")).a(n0Var);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, n0Var);
        }
    }
}
