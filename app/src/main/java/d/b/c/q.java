package d.b.c;

/* JADX INFO: compiled from: ReaderException.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    q() {
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return null;
    }

    q(Throwable th) {
        super(th);
    }
}
