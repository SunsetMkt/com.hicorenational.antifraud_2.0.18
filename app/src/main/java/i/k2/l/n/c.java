package i.k2.l.n;

import i.a0;
import i.m2.f;
import i.q2.s.l;
import i.q2.t.f0;
import i.t0;
import j.c.a.d;

/* JADX INFO: compiled from: Intrinsics.kt */
/* JADX INFO: loaded from: classes2.dex */
class c extends b {
    @t0(version = "1.2")
    @f
    private static final <T> i.k2.l.c<T> a(@d i.k2.l.c<? super T> cVar) {
        throw new a0("Implementation of intercepted is intrinsic");
    }

    @t0(version = "1.1")
    @f
    private static final <T> Object b(l<? super i.k2.l.c<? super T>, ? extends Object> lVar, i.k2.l.c<? super T> cVar) {
        f0.c(0);
        Object objInvoke = lVar.invoke(i.k2.l.o.a.b.a(cVar));
        f0.c(1);
        return objInvoke;
    }

    @t0(version = "1.2")
    @f
    private static final <T> Object c(l<? super i.k2.l.c<? super T>, ? extends Object> lVar, i.k2.l.c<? super T> cVar) {
        throw new a0("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
