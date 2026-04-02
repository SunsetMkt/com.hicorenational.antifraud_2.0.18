package h.a.y0.d;

import h.a.i0;

/* JADX INFO: compiled from: BasicFuseableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T, R> implements i0<T>, h.a.y0.c.j<R> {
    protected final i0<? super R> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected h.a.u0.c f10461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected h.a.y0.c.j<T> f10462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f10463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f10464e;

    public a(i0<? super R> i0Var) {
        this.a = i0Var;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        h.a.v0.b.b(th);
        this.f10461b.dispose();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // h.a.y0.c.o
    public void clear() {
        this.f10462c.clear();
    }

    @Override // h.a.u0.c
    public void dispose() {
        this.f10461b.dispose();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10461b.isDisposed();
    }

    @Override // h.a.y0.c.o
    public boolean isEmpty() {
        return this.f10462c.isEmpty();
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10463d) {
            return;
        }
        this.f10463d = true;
        this.a.onComplete();
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.f10463d) {
            h.a.c1.a.b(th);
        } else {
            this.f10463d = true;
            this.a.onError(th);
        }
    }

    @Override // h.a.i0
    public final void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.f10461b, cVar)) {
            this.f10461b = cVar;
            if (cVar instanceof h.a.y0.c.j) {
                this.f10462c = (h.a.y0.c.j) cVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // h.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        h.a.y0.c.j<T> jVar = this.f10462c;
        if (jVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = jVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f10464e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
