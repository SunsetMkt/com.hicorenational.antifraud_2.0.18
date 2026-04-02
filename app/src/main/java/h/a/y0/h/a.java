package h.a.y0.h;

/* JADX INFO: compiled from: BasicFuseableConditionalSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T, R> implements h.a.y0.c.a<T>, h.a.y0.c.l<R> {
    protected final h.a.y0.c.a<? super R> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected j.d.d f12005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected h.a.y0.c.l<T> f12006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12008e;

    public a(h.a.y0.c.a<? super R> aVar) {
        this.a = aVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        h.a.v0.b.b(th);
        this.f12005b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // j.d.d
    public void cancel() {
        this.f12005b.cancel();
    }

    @Override // h.a.y0.c.o
    public void clear() {
        this.f12006c.clear();
    }

    @Override // h.a.y0.c.o
    public boolean isEmpty() {
        return this.f12006c.isEmpty();
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f12007d) {
            return;
        }
        this.f12007d = true;
        this.a.onComplete();
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f12007d) {
            h.a.c1.a.b(th);
        } else {
            this.f12007d = true;
            this.a.onError(th);
        }
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.validate(this.f12005b, dVar)) {
            this.f12005b = dVar;
            if (dVar instanceof h.a.y0.c.l) {
                this.f12006c = (h.a.y0.c.l) dVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        this.f12005b.request(j2);
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        h.a.y0.c.l<T> lVar = this.f12006c;
        if (lVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f12008e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
