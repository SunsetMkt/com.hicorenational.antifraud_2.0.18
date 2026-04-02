package h.a.y0.e.f;

/* JADX INFO: compiled from: SingleJust.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0<T> extends h.a.k0<T> {
    final T a;

    public f0(T t) {
        this.a = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        n0Var.onSubscribe(h.a.u0.d.a());
        n0Var.onSuccess(this.a);
    }
}
