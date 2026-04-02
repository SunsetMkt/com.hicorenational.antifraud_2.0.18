package i.k2.l.p;

import i.q0;
import i.q2.t.i0;
import i.r0;

/* JADX INFO: compiled from: CoroutinesMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class g<T> implements i.k2.l.c<T> {

    @j.c.a.d
    private final i.k2.l.e a;

    /* JADX INFO: renamed from: b */
    @j.c.a.d
    private final i.k2.d<T> f12153b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@j.c.a.d i.k2.d<? super T> dVar) {
        i0.f(dVar, "continuation");
        this.f12153b = dVar;
        this.a = d.a(this.f12153b.getContext());
    }

    @j.c.a.d
    public final i.k2.d<T> a() {
        return this.f12153b;
    }

    @Override // i.k2.l.c
    @j.c.a.d
    public i.k2.l.e getContext() {
        return this.a;
    }

    @Override // i.k2.l.c
    public void resume(T t) {
        i.k2.d<T> dVar = this.f12153b;
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(t));
    }

    @Override // i.k2.l.c
    public void resumeWithException(@j.c.a.d Throwable th) {
        i0.f(th, "exception");
        i.k2.d<T> dVar = this.f12153b;
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(r0.a(th)));
    }
}
