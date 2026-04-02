package m;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends RuntimeException {
    private final transient m<?> a;
    private final int code;
    private final String message;

    public h(m<?> mVar) {
        super(a(mVar));
        this.code = mVar.b();
        this.message = mVar.f();
        this.a = mVar;
    }

    private static String a(m<?> mVar) {
        p.a(mVar, "response == null");
        return "HTTP " + mVar.b() + d.c.a.b.a.a.f10074g + mVar.f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public m<?> response() {
        return this.a;
    }
}
