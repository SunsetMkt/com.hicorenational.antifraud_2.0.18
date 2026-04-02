package i.k2.l.p;

import i.k2.e;
import i.k2.g;
import i.q2.s.p;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b implements i.k2.e {

    @j.c.a.d
    private final i.k2.l.d a;

    public b(@j.c.a.d i.k2.l.d dVar) {
        i0.f(dVar, "interceptor");
        this.a = dVar;
    }

    @j.c.a.d
    public final i.k2.l.d a() {
        return this.a;
    }

    @Override // i.k2.e
    @j.c.a.d
    public <T> i.k2.d<T> b(@j.c.a.d i.k2.d<? super T> dVar) {
        i0.f(dVar, "continuation");
        return d.a(this.a.a(d.a(dVar)));
    }

    @Override // i.k2.g.b, i.k2.g
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) e.a.a(this, r, pVar);
    }

    @Override // i.k2.e, i.k2.g.b, i.k2.g
    @j.c.a.e
    public <E extends g.b> E get(@j.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) e.a.a(this, cVar);
    }

    @Override // i.k2.g.b
    @j.c.a.d
    public g.c<?> getKey() {
        return i.k2.e.V;
    }

    @Override // i.k2.e, i.k2.g.b, i.k2.g
    @j.c.a.d
    public i.k2.g minusKey(@j.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return e.a.b(this, cVar);
    }

    @Override // i.k2.g
    @j.c.a.d
    public i.k2.g plus(@j.c.a.d i.k2.g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return e.a.a(this, gVar);
    }

    @Override // i.k2.e
    public void a(@j.c.a.d i.k2.d<?> dVar) {
        i0.f(dVar, "continuation");
        e.a.a(this, dVar);
    }
}
