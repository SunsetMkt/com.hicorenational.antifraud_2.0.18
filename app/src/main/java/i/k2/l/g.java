package i.k2.l;

import i.k2.l.e;
import i.q2.s.p;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
public final class g implements e {

    /* JADX INFO: renamed from: b */
    public static final g f12127b = new g();

    private g() {
    }

    @Override // i.k2.l.e
    @j.c.a.e
    public <E extends e.b> E a(@j.c.a.d e.c<E> cVar) {
        i0.f(cVar, "key");
        return null;
    }

    @Override // i.k2.l.e
    @j.c.a.d
    public e a(@j.c.a.d e eVar) {
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        return eVar;
    }

    @Override // i.k2.l.e
    @j.c.a.d
    public e b(@j.c.a.d e.c<?> cVar) {
        i0.f(cVar, "key");
        return this;
    }

    @Override // i.k2.l.e
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super e.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return r;
    }

    public int hashCode() {
        return 0;
    }

    @j.c.a.d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
