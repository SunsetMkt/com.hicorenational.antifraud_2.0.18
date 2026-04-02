package i;

/* JADX INFO: compiled from: AssertionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class l0 {
    @i.m2.f
    private static final void a(boolean z) {
        if (e2.a && !z) {
            throw new AssertionError("Assertion failed");
        }
    }

    @i.m2.f
    private static final void a(boolean z, i.q2.s.a<? extends Object> aVar) {
        if (e2.a && !z) {
            throw new AssertionError(aVar.invoke());
        }
    }
}
