package i.k2.l.p;

import i.q0;
import i.q2.t.i0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c<T> implements i.k2.d<T> {

    @j.c.a.d
    private final i.k2.g a;

    /* JADX INFO: renamed from: b */
    @j.c.a.d
    private final i.k2.l.c<T> f12149b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@j.c.a.d i.k2.l.c<? super T> cVar) {
        i0.f(cVar, "continuation");
        this.f12149b = cVar;
        this.a = d.a(this.f12149b.getContext());
    }

    @j.c.a.d
    public final i.k2.l.c<T> a() {
        return this.f12149b;
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        return this.a;
    }

    @Override // i.k2.d
    public void resumeWith(@j.c.a.d Object obj) {
        if (q0.m778isSuccessimpl(obj)) {
            this.f12149b.resume(obj);
        }
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl != null) {
            this.f12149b.resumeWithException(thM775exceptionOrNullimpl);
        }
    }
}
