package i.k2.l.p;

import i.q2.s.p;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class i<T1, R> implements p<T1, i.k2.l.c<? super R>, Object> {

    @j.c.a.d
    private final p<T1, i.k2.d<? super R>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@j.c.a.d p<? super T1, ? super i.k2.d<? super R>, ? extends Object> pVar) {
        i0.f(pVar, "function");
        this.a = pVar;
    }

    @j.c.a.d
    public final p<T1, i.k2.d<? super R>, Object> a() {
        return this.a;
    }

    @Override // i.q2.s.p
    @j.c.a.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, @j.c.a.d i.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.a.invoke(t1, d.a(cVar));
    }
}
