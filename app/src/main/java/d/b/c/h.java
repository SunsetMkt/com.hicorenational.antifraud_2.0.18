package d.b.c;

/* JADX INFO: compiled from: FormatException.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends q {
    private static final h a = new h();

    static {
        a.setStackTrace(q.NO_TRACE);
    }

    private h() {
    }

    public static h getFormatInstance() {
        return q.isStackTrace ? new h() : a;
    }

    private h(Throwable th) {
        super(th);
    }

    public static h getFormatInstance(Throwable th) {
        return q.isStackTrace ? new h(th) : a;
    }
}
