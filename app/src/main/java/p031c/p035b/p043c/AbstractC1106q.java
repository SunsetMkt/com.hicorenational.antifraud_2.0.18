package p031c.p035b.p043c;

/* compiled from: ReaderException.java */
/* renamed from: c.b.c.q */
/* loaded from: classes.dex */
public abstract class AbstractC1106q extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    AbstractC1106q() {
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return null;
    }

    AbstractC1106q(Throwable th) {
        super(th);
    }
}
