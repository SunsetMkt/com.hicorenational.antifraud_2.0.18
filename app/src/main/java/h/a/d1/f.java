package h.a.d1;

import h.a.y0.j.q;

/* JADX INFO: compiled from: SerializedProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class f<T> extends c<T> {

    /* JADX INFO: renamed from: b */
    final c<T> f10306b;

    /* JADX INFO: renamed from: c */
    boolean f10307c;

    /* JADX INFO: renamed from: d */
    h.a.y0.j.a<Object> f10308d;

    /* JADX INFO: renamed from: e */
    volatile boolean f10309e;

    f(c<T> cVar) {
        this.f10306b = cVar;
    }

    @Override // h.a.d1.c
    public Throwable T() {
        return this.f10306b.T();
    }

    @Override // h.a.d1.c
    public boolean U() {
        return this.f10306b.U();
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10306b.V();
    }

    @Override // h.a.d1.c
    public boolean W() {
        return this.f10306b.W();
    }

    void Y() {
        h.a.y0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f10308d;
                if (aVar == null) {
                    this.f10307c = false;
                    return;
                }
                this.f10308d = null;
            }
            aVar.a((j.d.c) this.f10306b);
        }
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10306b.subscribe(cVar);
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10309e) {
            return;
        }
        synchronized (this) {
            if (this.f10309e) {
                return;
            }
            this.f10309e = true;
            if (!this.f10307c) {
                this.f10307c = true;
                this.f10306b.onComplete();
                return;
            }
            h.a.y0.j.a<Object> aVar = this.f10308d;
            if (aVar == null) {
                aVar = new h.a.y0.j.a<>(4);
                this.f10308d = aVar;
            }
            aVar.a(q.complete());
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        boolean z;
        if (this.f10309e) {
            h.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f10309e) {
                z = true;
            } else {
                this.f10309e = true;
                if (this.f10307c) {
                    h.a.y0.j.a<Object> aVar = this.f10308d;
                    if (aVar == null) {
                        aVar = new h.a.y0.j.a<>(4);
                        this.f10308d = aVar;
                    }
                    aVar.b(q.error(th));
                    return;
                }
                z = false;
                this.f10307c = true;
            }
            if (z) {
                h.a.c1.a.b(th);
            } else {
                this.f10306b.onError(th);
            }
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10309e) {
            return;
        }
        synchronized (this) {
            if (this.f10309e) {
                return;
            }
            if (!this.f10307c) {
                this.f10307c = true;
                this.f10306b.onNext(t);
                Y();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10308d;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10308d = aVar;
                }
                aVar.a(q.next(t));
            }
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        boolean z = true;
        if (!this.f10309e) {
            synchronized (this) {
                if (!this.f10309e) {
                    if (this.f10307c) {
                        h.a.y0.j.a<Object> aVar = this.f10308d;
                        if (aVar == null) {
                            aVar = new h.a.y0.j.a<>(4);
                            this.f10308d = aVar;
                        }
                        aVar.a(q.subscription(dVar));
                        return;
                    }
                    this.f10307c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
        } else {
            this.f10306b.onSubscribe(dVar);
            Y();
        }
    }
}
