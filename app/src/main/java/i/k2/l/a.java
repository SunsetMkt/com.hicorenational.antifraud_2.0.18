package i.k2.l;

import i.k2.l.e;
import i.q2.s.p;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
public abstract class a implements e.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final e.c<?> f12124b;

    public a(@j.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        this.f12124b = cVar;
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    @j.c.a.e
    public <E extends e.b> E a(@j.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) e.b.a.a(this, cVar);
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    @j.c.a.d
    public e b(@j.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return e.b.a.b(this, cVar);
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) e.b.a.a(this, r, pVar);
    }

    @Override // i.k2.l.e.b
    @j.c.a.d
    public e.c<?> getKey() {
        return this.f12124b;
    }

    @Override // i.k2.l.e
    @j.c.a.d
    public e a(@j.c.a.d e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return e.b.a.a(this, eVar);
    }
}
