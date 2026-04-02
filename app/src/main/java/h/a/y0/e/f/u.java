package h.a.y0.e.f;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SingleError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T> extends h.a.k0<T> {
    final Callable<? extends Throwable> a;

    public u(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        try {
            th = (Throwable) h.a.y0.b.b.a(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            h.a.v0.b.b(th);
        }
        h.a.y0.a.e.error(th, n0Var);
    }
}
