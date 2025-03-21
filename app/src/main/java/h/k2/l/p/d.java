package h.k2.l.p;

import h.q2.s.l;
import h.q2.s.p;
import h.q2.s.q;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
public final class d {
    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> h.k2.l.c<T> a(@i.c.a.d h.k2.d<? super T> dVar) {
        h.k2.l.c<T> a2;
        i0.f(dVar, "$this$toExperimentalContinuation");
        c cVar = (c) (!(dVar instanceof c) ? null : dVar);
        return (cVar == null || (a2 = cVar.a()) == null) ? new g(dVar) : a2;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <T> h.k2.d<T> a(@i.c.a.d h.k2.l.c<? super T> cVar) {
        h.k2.d<T> a2;
        i0.f(cVar, "$this$toContinuation");
        g gVar = (g) (!(cVar instanceof g) ? null : cVar);
        return (gVar == null || (a2 = gVar.a()) == null) ? new c(cVar) : a2;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final h.k2.l.e a(@i.c.a.d h.k2.g gVar) {
        h.k2.l.e eVar;
        i0.f(gVar, "$this$toExperimentalCoroutineContext");
        h.k2.e eVar2 = (h.k2.e) gVar.get(h.k2.e.V);
        a aVar = (a) gVar.get(a.f16285c);
        h.k2.g minusKey = gVar.minusKey(h.k2.e.V).minusKey(a.f16285c);
        if (aVar == null || (eVar = aVar.a()) == null) {
            eVar = h.k2.l.g.f16257b;
        }
        if (minusKey != h.k2.i.INSTANCE) {
            eVar = eVar.a(new e(minusKey));
        }
        return eVar2 == null ? eVar : eVar.a(a(eVar2));
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final h.k2.g a(@i.c.a.d h.k2.l.e eVar) {
        h.k2.g gVar;
        i0.f(eVar, "$this$toCoroutineContext");
        h.k2.l.d dVar = (h.k2.l.d) eVar.a(h.k2.l.d.f16255a);
        e eVar2 = (e) eVar.a(e.f16290d);
        h.k2.l.e b2 = eVar.b(h.k2.l.d.f16255a).b(e.f16290d);
        if (eVar2 == null || (gVar = eVar2.a()) == null) {
            gVar = h.k2.i.INSTANCE;
        }
        if (b2 != h.k2.l.g.f16257b) {
            gVar = gVar.plus(new a(b2));
        }
        return dVar == null ? gVar : gVar.plus(a(dVar));
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final h.k2.l.d a(@i.c.a.d h.k2.e eVar) {
        h.k2.l.d a2;
        i0.f(eVar, "$this$toExperimentalContinuationInterceptor");
        b bVar = (b) (!(eVar instanceof b) ? null : eVar);
        return (bVar == null || (a2 = bVar.a()) == null) ? new f(eVar) : a2;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final h.k2.e a(@i.c.a.d h.k2.l.d dVar) {
        h.k2.e a2;
        i0.f(dVar, "$this$toContinuationInterceptor");
        f fVar = (f) (!(dVar instanceof f) ? null : dVar);
        return (fVar == null || (a2 = fVar.a()) == null) ? new b(dVar) : a2;
    }

    @i.c.a.d
    public static final <R> l<h.k2.l.c<? super R>, Object> a(@i.c.a.d l<? super h.k2.d<? super R>, ? extends Object> lVar) {
        i0.f(lVar, "$this$toExperimentalSuspendFunction");
        return new h(lVar);
    }

    @i.c.a.d
    public static final <T1, R> p<T1, h.k2.l.c<? super R>, Object> a(@i.c.a.d p<? super T1, ? super h.k2.d<? super R>, ? extends Object> pVar) {
        i0.f(pVar, "$this$toExperimentalSuspendFunction");
        return new i(pVar);
    }

    @i.c.a.d
    public static final <T1, T2, R> q<T1, T2, h.k2.l.c<? super R>, Object> a(@i.c.a.d q<? super T1, ? super T2, ? super h.k2.d<? super R>, ? extends Object> qVar) {
        i0.f(qVar, "$this$toExperimentalSuspendFunction");
        return new j(qVar);
    }
}
