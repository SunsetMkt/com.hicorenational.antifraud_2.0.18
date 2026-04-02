package i.k2.l;

import i.a0;
import i.e1;
import i.q2.s.p;
import i.q2.t.f0;
import i.q2.t.i0;
import i.t0;
import i.y1;

/* JADX INFO: compiled from: CoroutinesLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "CoroutinesKt")
public final class f {
    @t0(version = "1.1")
    @j.c.a.d
    public static final <R, T> c<y1> a(@j.c.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @j.c.a.d c<? super T> cVar) {
        i0.f(pVar, "$this$createCoroutine");
        i0.f(cVar, "completion");
        return new i(i.k2.l.n.b.a(pVar, r, cVar), i.k2.l.n.b.b());
    }

    @t0(version = "1.2")
    @i.m2.f
    public static /* synthetic */ void a() {
    }

    @t0(version = "1.1")
    public static final <R, T> void b(@j.c.a.d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @j.c.a.d c<? super T> cVar) {
        i0.f(pVar, "$this$startCoroutine");
        i0.f(cVar, "completion");
        i.k2.l.n.b.a(pVar, r, cVar).resume(y1.a);
    }

    @j.c.a.e
    @t0(version = "1.1")
    public static final <T> Object c(@j.c.a.d i.q2.s.l<? super c<? super T>, y1> lVar, @j.c.a.d c<? super T> cVar) {
        i iVar = new i(i.k2.l.o.a.b.a(cVar));
        lVar.invoke(iVar);
        return iVar.a();
    }

    @j.c.a.e
    @t0(version = "1.1")
    private static final Object d(@j.c.a.d i.q2.s.l lVar, @j.c.a.d c cVar) throws Throwable {
        f0.c(0);
        i iVar = new i(i.k2.l.o.a.b.a(cVar));
        lVar.invoke(iVar);
        Object objA = iVar.a();
        f0.c(1);
        return objA;
    }

    @t0(version = "1.1")
    @j.c.a.d
    public static final <T> c<y1> a(@j.c.a.d i.q2.s.l<? super c<? super T>, ? extends Object> lVar, @j.c.a.d c<? super T> cVar) {
        i0.f(lVar, "$this$createCoroutine");
        i0.f(cVar, "completion");
        return new i(i.k2.l.n.b.a(lVar, cVar), i.k2.l.n.b.b());
    }

    @t0(version = "1.1")
    public static final <T> void b(@j.c.a.d i.q2.s.l<? super c<? super T>, ? extends Object> lVar, @j.c.a.d c<? super T> cVar) {
        i0.f(lVar, "$this$startCoroutine");
        i0.f(cVar, "completion");
        i.k2.l.n.b.a(lVar, cVar).resume(y1.a);
    }

    @i.m2.f
    private static final void a(c<?> cVar, i.q2.s.a<? extends Object> aVar) {
        try {
            Object objInvoke = aVar.invoke();
            if (objInvoke != i.k2.l.n.b.b()) {
                if (cVar == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                cVar.resume(objInvoke);
            }
        } catch (Throwable th) {
            cVar.resumeWithException(th);
        }
    }

    private static final e b() {
        throw new a0("Implemented as intrinsic");
    }
}
