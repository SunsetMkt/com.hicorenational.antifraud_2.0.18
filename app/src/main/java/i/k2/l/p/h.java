package i.k2.l.p;

import i.q2.s.l;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h<R> implements l<i.k2.l.c<? super R>, Object> {

    @j.c.a.d
    private final l<i.k2.d<? super R>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@j.c.a.d l<? super i.k2.d<? super R>, ? extends Object> lVar) {
        i0.f(lVar, "function");
        this.a = lVar;
    }

    @j.c.a.d
    public final l<i.k2.d<? super R>, Object> a() {
        return this.a;
    }

    @Override // i.q2.s.l
    @j.c.a.e
    /* JADX INFO: renamed from: a */
    public Object invoke(@j.c.a.d i.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.a.invoke(d.a(cVar));
    }
}
