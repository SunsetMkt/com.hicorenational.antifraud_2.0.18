package d.b.c;

/* JADX INFO: compiled from: ChecksumException.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends q {
    private static final d a = new d();

    static {
        a.setStackTrace(q.NO_TRACE);
    }

    private d() {
    }

    public static d getChecksumInstance() {
        return q.isStackTrace ? new d() : a;
    }

    private d(Throwable th) {
        super(th);
    }

    public static d getChecksumInstance(Throwable th) {
        return q.isStackTrace ? new d(th) : a;
    }
}
