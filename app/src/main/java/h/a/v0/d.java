package h.a.v0;

/* JADX INFO: compiled from: OnErrorNotImplementedException.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.c
public final class d extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public d(String str, @h.a.t0.f Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public d(@h.a.t0.f Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
