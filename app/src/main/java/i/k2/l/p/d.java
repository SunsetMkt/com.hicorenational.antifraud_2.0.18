package i.k2.l.p;

import i.q2.s.l;
import i.q2.s.p;
import i.q2.s.q;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @t0(version = "1.3")
    @j.c.a.d
    public static final <T> i.k2.l.c<T> a(@j.c.a.d i.k2.d<? super T> dVar) {
        i.k2.l.c<T> cVarA;
        i0.f(dVar, "$this$toExperimentalContinuation");
        c cVar = (c) (!(dVar instanceof c) ? null : dVar);
        return (cVar == null || (cVarA = cVar.a()) == null) ? new g(dVar) : cVarA;
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final <T> i.k2.d<T> a(@j.c.a.d i.k2.l.c<? super T> cVar) {
        i.k2.d<T> dVarA;
        i0.f(cVar, "$this$toContinuation");
        g gVar = (g) (!(cVar instanceof g) ? null : cVar);
        return (gVar == null || (dVarA = gVar.a()) == null) ? new c(cVar) : dVarA;
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final i.k2.l.e a(@j.c.a.d i.k2.g gVar) {
        i.k2.l.e eVarA;
        i0.f(gVar, "$this$toExperimentalCoroutineContext");
        i.k2.e eVar = (i.k2.e) gVar.get(i.k2.e.V);
        a aVar = (a) gVar.get(a.f12147c);
        i.k2.g gVarMinusKey = gVar.minusKey(i.k2.e.V).minusKey(a.f12147c);
        if (aVar == null || (eVarA = aVar.a()) == null) {
            eVarA = i.k2.l.g.f12127b;
        }
        if (gVarMinusKey != i.k2.i.INSTANCE) {
            eVarA = eVarA.a(new e(gVarMinusKey));
        }
        return eVar == null ? eVarA : eVarA.a(a(eVar));
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final i.k2.g a(@j.c.a.d i.k2.l.e eVar) {
        i.k2.g gVarPlus;
        i0.f(eVar, "$this$toCoroutineContext");
        i.k2.l.d dVar = (i.k2.l.d) eVar.a(i.k2.l.d.a);
        e eVar2 = (e) eVar.a(e.f12150d);
        i.k2.l.e eVarB = eVar.b(i.k2.l.d.a).b(e.f12150d);
        if (eVar2 == null || (gVarPlus = eVar2.a()) == null) {
            gVarPlus = i.k2.i.INSTANCE;
        }
        if (eVarB != i.k2.l.g.f12127b) {
            gVarPlus = gVarPlus.plus(new a(eVarB));
        }
        return dVar == null ? gVarPlus : gVarPlus.plus(a(dVar));
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final i.k2.l.d a(@j.c.a.d i.k2.e eVar) {
        i.k2.l.d dVarA;
        i0.f(eVar, "$this$toExperimentalContinuationInterceptor");
        b bVar = (b) (!(eVar instanceof b) ? null : eVar);
        return (bVar == null || (dVarA = bVar.a()) == null) ? new f(eVar) : dVarA;
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final i.k2.e a(@j.c.a.d i.k2.l.d dVar) {
        i.k2.e eVarA;
        i0.f(dVar, "$this$toContinuationInterceptor");
        f fVar = (f) (!(dVar instanceof f) ? null : dVar);
        return (fVar == null || (eVarA = fVar.a()) == null) ? new b(dVar) : eVarA;
    }

    @j.c.a.d
    public static final <R> l<i.k2.l.c<? super R>, Object> a(@j.c.a.d l<? super i.k2.d<? super R>, ? extends Object> lVar) {
        i0.f(lVar, "$this$toExperimentalSuspendFunction");
        return new h(lVar);
    }

    @j.c.a.d
    public static final <T1, R> p<T1, i.k2.l.c<? super R>, Object> a(@j.c.a.d p<? super T1, ? super i.k2.d<? super R>, ? extends Object> pVar) {
        i0.f(pVar, "$this$toExperimentalSuspendFunction");
        return new i(pVar);
    }

    @j.c.a.d
    public static final <T1, T2, R> q<T1, T2, i.k2.l.c<? super R>, Object> a(@j.c.a.d q<? super T1, ? super T2, ? super i.k2.d<? super R>, ? extends Object> qVar) {
        i0.f(qVar, "$this$toExperimentalSuspendFunction");
        return new j(qVar);
    }
}
