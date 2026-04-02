package i.k2.n.a;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements i.k2.d<Object> {
    public static final c a = new c();

    private c() {
    }

    @Override // i.k2.d
    @j.c.a.d
    public i.k2.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // i.k2.d
    public void resumeWith(@j.c.a.d Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @j.c.a.d
    public String toString() {
        return "This continuation is already complete";
    }
}
