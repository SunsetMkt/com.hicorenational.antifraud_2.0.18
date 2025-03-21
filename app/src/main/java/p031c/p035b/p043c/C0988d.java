package p031c.p035b.p043c;

/* compiled from: ChecksumException.java */
/* renamed from: c.b.c.d */
/* loaded from: classes.dex */
public final class C0988d extends AbstractC1106q {

    /* renamed from: a */
    private static final C0988d f1773a = new C0988d();

    static {
        f1773a.setStackTrace(AbstractC1106q.NO_TRACE);
    }

    private C0988d() {
    }

    public static C0988d getChecksumInstance() {
        return AbstractC1106q.isStackTrace ? new C0988d() : f1773a;
    }

    private C0988d(Throwable th) {
        super(th);
    }

    public static C0988d getChecksumInstance(Throwable th) {
        return AbstractC1106q.isStackTrace ? new C0988d(th) : f1773a;
    }
}
