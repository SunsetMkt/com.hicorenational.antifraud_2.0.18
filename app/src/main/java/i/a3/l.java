package i.a3;

import i.a3.p;
import i.q2.t.i0;
import i.t0;
import i.y1;

/* JADX INFO: compiled from: measureTime.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @j
    @t0(version = "1.3")
    public static final double a(@j.c.a.d i.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        o oVarA = p.b.f12061c.a();
        aVar.invoke();
        return oVarA.a();
    }

    @j
    @t0(version = "1.3")
    @j.c.a.d
    public static final <T> s<T> b(@j.c.a.d i.q2.s.a<? extends T> aVar) {
        i0.f(aVar, "block");
        return new s<>(aVar.invoke(), p.b.f12061c.a().a(), null);
    }

    @j
    @t0(version = "1.3")
    public static final double a(@j.c.a.d p pVar, @j.c.a.d i.q2.s.a<y1> aVar) {
        i0.f(pVar, "$this$measureTime");
        i0.f(aVar, "block");
        o oVarA = pVar.a();
        aVar.invoke();
        return oVarA.a();
    }

    @j
    @t0(version = "1.3")
    @j.c.a.d
    public static final <T> s<T> b(@j.c.a.d p pVar, @j.c.a.d i.q2.s.a<? extends T> aVar) {
        i0.f(pVar, "$this$measureTimedValue");
        i0.f(aVar, "block");
        return new s<>(aVar.invoke(), pVar.a().a(), null);
    }
}
