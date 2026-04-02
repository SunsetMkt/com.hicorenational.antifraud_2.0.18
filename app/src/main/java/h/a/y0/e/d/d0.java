package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableDefer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0<T> extends h.a.b0<T> {
    final Callable<? extends h.a.g0<? extends T>> a;

    public d0(Callable<? extends h.a.g0<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        try {
            ((h.a.g0) h.a.y0.b.b.a(this.a.call(), "null ObservableSource supplied")).subscribe(i0Var);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }
}
