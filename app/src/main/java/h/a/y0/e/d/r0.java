package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableEmpty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends h.a.b0<Object> implements h.a.y0.c.m<Object> {
    public static final h.a.b0<Object> a = new r0();

    private r0() {
    }

    @Override // h.a.y0.c.m, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super Object> i0Var) {
        h.a.y0.a.e.complete(i0Var);
    }
}
