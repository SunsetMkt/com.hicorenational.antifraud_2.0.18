package i.k2;

import i.k2.g;
import i.q2.s.p;
import i.q2.t.i0;
import i.t0;
import java.io.Serializable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.3")
public final class i implements g, Serializable {
    public static final i INSTANCE = new i();
    private static final long serialVersionUID = 0;

    private i() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // i.k2.g
    public <R> R fold(R r, @j.c.a.d p<? super R, ? super g.b, ? extends R> pVar) {
        i0.f(pVar, "operation");
        return r;
    }

    @Override // i.k2.g
    @j.c.a.e
    public <E extends g.b> E get(@j.c.a.d g.c<E> cVar) {
        i0.f(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // i.k2.g
    @j.c.a.d
    public g minusKey(@j.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return this;
    }

    @Override // i.k2.g
    @j.c.a.d
    public g plus(@j.c.a.d g gVar) {
        i0.f(gVar, com.umeng.analytics.pro.d.R);
        return gVar;
    }

    @j.c.a.d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
