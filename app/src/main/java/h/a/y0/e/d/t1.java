package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableLift.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t1<R, T> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.f0<? extends R, ? super T> f11633b;

    public t1(h.a.g0<T> g0Var, h.a.f0<? extends R, ? super T> f0Var) {
        super(g0Var);
        this.f11633b = f0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super R> i0Var) {
        try {
            this.a.subscribe((h.a.i0) h.a.y0.b.b.a(this.f11633b.a(i0Var), "Operator " + this.f11633b + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
