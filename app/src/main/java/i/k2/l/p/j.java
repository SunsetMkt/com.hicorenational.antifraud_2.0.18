package i.k2.l.p;

import i.q2.s.q;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class j<T1, T2, R> implements q<T1, T2, i.k2.l.c<? super R>, Object> {

    @j.c.a.d
    private final q<T1, T2, i.k2.d<? super R>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@j.c.a.d q<? super T1, ? super T2, ? super i.k2.d<? super R>, ? extends Object> qVar) {
        i0.f(qVar, "function");
        this.a = qVar;
    }

    @j.c.a.d
    public final q<T1, T2, i.k2.d<? super R>, Object> a() {
        return this.a;
    }

    @Override // i.q2.s.q
    @j.c.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, T2 t2, @j.c.a.d i.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.a.invoke(t1, t2, d.a(cVar));
    }
}
