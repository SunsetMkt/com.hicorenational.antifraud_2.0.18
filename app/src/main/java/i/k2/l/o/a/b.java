package i.k2.l.o.a;

import i.k2.l.c;
import i.q2.e;
import i.q2.t.i0;
import j.c.a.d;

/* JADX INFO: compiled from: CoroutineIntrinsics.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "CoroutineIntrinsics")
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> c<T> a(@d c<? super T> cVar) {
        c<T> cVar2;
        i0.f(cVar, "continuation");
        a aVar = (a) (!(cVar instanceof a) ? null : cVar);
        return (aVar == null || (cVar2 = (c<T>) aVar.getFacade()) == null) ? cVar : cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> c<T> a(@d i.k2.l.e eVar, @d c<? super T> cVar) {
        c<T> cVarA;
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        i0.f(cVar, "continuation");
        i.k2.l.d dVar = (i.k2.l.d) eVar.a(i.k2.l.d.a);
        return (dVar == null || (cVarA = dVar.a(cVar)) == null) ? cVar : cVarA;
    }
}
