package i.k2;

import i.k2.g;
import i.q2.s.p;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public abstract class a implements g.b {

    @j.c.a.d
    private final g.c<?> a;

    public a(@j.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        this.a = cVar;
    }

    @Override // i.k2.g.b, i.k2.g
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) g.b.a.a(this, r, pVar);
    }

    @Override // i.k2.g.b, i.k2.g
    @j.c.a.e
    public <E extends g.b> E get(@j.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) g.b.a.a(this, cVar);
    }

    @Override // i.k2.g.b
    @j.c.a.d
    public g.c<?> getKey() {
        return this.a;
    }

    @Override // i.k2.g.b, i.k2.g
    @j.c.a.d
    public g minusKey(@j.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return g.b.a.b(this, cVar);
    }

    @Override // i.k2.g
    @j.c.a.d
    public g plus(@j.c.a.d g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return g.b.a.a(this, gVar);
    }
}
