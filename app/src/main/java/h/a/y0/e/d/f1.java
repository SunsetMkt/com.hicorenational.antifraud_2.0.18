package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableFromUnsafeSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f1<T> extends h.a.b0<T> {
    final h.a.g0<T> a;

    public f1(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(i0Var);
    }
}
