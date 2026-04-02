package h.a.y0.e.c;

/* JADX INFO: compiled from: AbstractMaybeWithUpstream.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<T, R> extends h.a.s<R> implements h.a.y0.c.f<T> {
    protected final h.a.y<T> a;

    a(h.a.y<T> yVar) {
        this.a = yVar;
    }

    @Override // h.a.y0.c.f
    public final h.a.y<T> source() {
        return this.a;
    }
}
