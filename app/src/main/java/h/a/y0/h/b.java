package h.a.y0.h;

/* JADX INFO: compiled from: BasicFuseableSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T, R> implements h.a.q<T>, h.a.y0.c.l<R> {
    protected final j.d.c<? super R> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected j.d.d f12009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected h.a.y0.c.l<T> f12010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12012e;

    public b(j.d.c<? super R> cVar) {
        this.a = cVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        h.a.v0.b.b(th);
        this.f12009b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // j.d.d
    public void cancel() {
        this.f12009b.cancel();
    }

    public void clear() {
        this.f12010c.clear();
    }

    @Override // h.a.y0.c.o
    public boolean isEmpty() {
        return this.f12010c.isEmpty();
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f12011d) {
            return;
        }
        this.f12011d = true;
        this.a.onComplete();
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f12011d) {
            h.a.c1.a.b(th);
        } else {
            this.f12011d = true;
            this.a.onError(th);
        }
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.validate(this.f12009b, dVar)) {
            this.f12009b = dVar;
            if (dVar instanceof h.a.y0.c.l) {
                this.f12010c = (h.a.y0.c.l) dVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        this.f12009b.request(j2);
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        h.a.y0.c.l<T> lVar = this.f12010c;
        if (lVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f12012e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
