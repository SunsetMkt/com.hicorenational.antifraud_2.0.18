package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableLift.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w1<R, T> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.p<? extends R, ? super T> f11033c;

    public w1(h.a.l<T> lVar, h.a.p<? extends R, ? super T> pVar) {
        super(lVar);
        this.f11033c = pVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super R> cVar) {
        try {
            j.d.c<? super Object> cVarA = this.f11033c.a(cVar);
            if (cVarA != null) {
                this.f10561b.subscribe(cVarA);
                return;
            }
            throw new NullPointerException("Operator " + this.f11033c + " returned a null Subscriber");
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
