package i.k2.l.p;

import i.k2.l.d;
import i.k2.l.e;
import i.q2.s.p;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class f implements i.k2.l.d {

    /* JADX INFO: renamed from: b */
    @j.c.a.d
    private final i.k2.e f12152b;

    public f(@j.c.a.d i.k2.e eVar) {
        i0.f(eVar, "interceptor");
        this.f12152b = eVar;
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    @j.c.a.e
    public <E extends e.b> E a(@j.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return (E) d.a.a(this, cVar);
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    @j.c.a.d
    public i.k2.l.e b(@j.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return d.a.b(this, cVar);
    }

    @Override // i.k2.l.e.b, i.k2.l.e
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return (R) d.a.a(this, r, pVar);
    }

    @Override // i.k2.l.e.b
    @j.c.a.d
    public e.c<?> getKey() {
        return i.k2.l.d.a;
    }

    @j.c.a.d
    public final i.k2.e a() {
        return this.f12152b;
    }

    @Override // i.k2.l.e
    @j.c.a.d
    public i.k2.l.e a(@j.c.a.d i.k2.l.e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return d.a.a(this, eVar);
    }

    @Override // i.k2.l.d
    @j.c.a.d
    public <T> i.k2.l.c<T> a(@j.c.a.d i.k2.l.c<? super T> cVar) {
        i0.f(cVar, "continuation");
        return d.a(this.f12152b.b(d.a(cVar)));
    }
}
