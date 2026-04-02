package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableError.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> extends h.a.b0<T> {
    final Callable<? extends Throwable> a;

    public s0(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        try {
            th = (Throwable) h.a.y0.b.b.a(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            h.a.v0.b.b(th);
        }
        h.a.y0.a.e.error(th, i0Var);
    }
}
