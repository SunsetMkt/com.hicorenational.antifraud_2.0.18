package h.a.y0.e.d;

/* JADX INFO: compiled from: AbstractObservableWithUpstream.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<T, U> extends h.a.b0<U> implements h.a.y0.c.g<T> {
    protected final h.a.g0<T> a;

    a(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // h.a.y0.c.g
    public final h.a.g0<T> source() {
        return this.a;
    }
}
