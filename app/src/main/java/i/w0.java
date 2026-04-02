package i;

/* JADX INFO: compiled from: Synchronized.kt */
/* JADX INFO: loaded from: classes2.dex */
class w0 extends v0 {
    @i.m2.f
    private static final <R> R a(Object obj, i.q2.s.a<? extends R> aVar) {
        R rInvoke;
        synchronized (obj) {
            try {
                rInvoke = aVar.invoke();
                i.q2.t.f0.b(1);
            } catch (Throwable th) {
                i.q2.t.f0.b(1);
                i.q2.t.f0.a(1);
                throw th;
            }
        }
        i.q2.t.f0.a(1);
        return rInvoke;
    }
}
