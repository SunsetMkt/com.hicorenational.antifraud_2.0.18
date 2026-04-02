package h.a.y0.e.d;

import h.a.y0.e.d.s2;

/* JADX INFO: compiled from: ObservableJust.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q1<T> extends h.a.b0<T> implements h.a.y0.c.m<T> {
    private final T a;

    public q1(T t) {
        this.a = t;
    }

    @Override // h.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        s2.a aVar = new s2.a(i0Var, this.a);
        i0Var.onSubscribe(aVar);
        aVar.run();
    }
}
