package h.a.y0.e.b;

/* JADX INFO: compiled from: AbstractFlowableWithUpstream.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<T, R> extends h.a.l<R> implements h.a.y0.c.h<T> {

    /* JADX INFO: renamed from: b */
    protected final h.a.l<T> f10561b;

    a(h.a.l<T> lVar) {
        this.f10561b = (h.a.l) h.a.y0.b.b.a(lVar, "source is null");
    }

    @Override // h.a.y0.c.h
    public final j.d.b<T> source() {
        return this.f10561b;
    }
}
