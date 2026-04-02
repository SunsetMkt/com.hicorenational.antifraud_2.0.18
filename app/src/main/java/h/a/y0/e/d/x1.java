package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableNever.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x1 extends h.a.b0<Object> {
    public static final h.a.b0<Object> a = new x1();

    private x1() {
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super Object> i0Var) {
        i0Var.onSubscribe(h.a.y0.a.e.NEVER);
    }
}
