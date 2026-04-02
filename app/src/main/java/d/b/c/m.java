package d.b.c;

/* JADX INFO: compiled from: NotFoundException.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends q {
    private static final m a = new m();

    static {
        a.setStackTrace(q.NO_TRACE);
    }

    private m() {
    }

    public static m getNotFoundInstance() {
        return a;
    }
}
