package h.a.y0.e.c;

/* JADX INFO: compiled from: MaybeJust.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> extends h.a.s<T> implements h.a.y0.c.m<T> {
    final T a;

    public s0(T t) {
        this.a = t;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        vVar.onSubscribe(h.a.u0.d.a());
        vVar.onSuccess(this.a);
    }

    @Override // h.a.y0.c.m, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }
}
