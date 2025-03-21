package p031c.p035b.p043c;

/* compiled from: FormatException.java */
/* renamed from: c.b.c.h */
/* loaded from: classes.dex */
public final class C1097h extends AbstractC1106q {

    /* renamed from: a */
    private static final C1097h f2197a = new C1097h();

    static {
        f2197a.setStackTrace(AbstractC1106q.NO_TRACE);
    }

    private C1097h() {
    }

    public static C1097h getFormatInstance() {
        return AbstractC1106q.isStackTrace ? new C1097h() : f2197a;
    }

    private C1097h(Throwable th) {
        super(th);
    }

    public static C1097h getFormatInstance(Throwable th) {
        return AbstractC1106q.isStackTrace ? new C1097h(th) : f2197a;
    }
}
