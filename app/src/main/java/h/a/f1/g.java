package h.a.f1;

import h.a.i0;
import h.a.y0.j.a;
import h.a.y0.j.q;

/* JADX INFO: compiled from: SerializedSubject.java */
/* JADX INFO: loaded from: classes2.dex */
final class g<T> extends i<T> implements a.InterfaceC0233a<Object> {
    final i<T> a;

    /* JADX INFO: renamed from: b */
    boolean f10372b;

    /* JADX INFO: renamed from: c */
    h.a.y0.j.a<Object> f10373c;

    /* JADX INFO: renamed from: d */
    volatile boolean f10374d;

    g(i<T> iVar) {
        this.a = iVar;
    }

    @Override // h.a.f1.i
    public Throwable O() {
        return this.a.O();
    }

    @Override // h.a.f1.i
    public boolean P() {
        return this.a.P();
    }

    @Override // h.a.f1.i
    public boolean Q() {
        return this.a.Q();
    }

    @Override // h.a.f1.i
    public boolean R() {
        return this.a.R();
    }

    void T() {
        h.a.y0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f10373c;
                if (aVar == null) {
                    this.f10372b = false;
                    return;
                }
                this.f10373c = null;
            }
            aVar.a((a.InterfaceC0233a<? super Object>) this);
        }
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        this.a.subscribe(i0Var);
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10374d) {
            return;
        }
        synchronized (this) {
            if (this.f10374d) {
                return;
            }
            this.f10374d = true;
            if (!this.f10372b) {
                this.f10372b = true;
                this.a.onComplete();
                return;
            }
            h.a.y0.j.a<Object> aVar = this.f10373c;
            if (aVar == null) {
                aVar = new h.a.y0.j.a<>(4);
                this.f10373c = aVar;
            }
            aVar.a(q.complete());
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        boolean z;
        if (this.f10374d) {
            h.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f10374d) {
                z = true;
            } else {
                this.f10374d = true;
                if (this.f10372b) {
                    h.a.y0.j.a<Object> aVar = this.f10373c;
                    if (aVar == null) {
                        aVar = new h.a.y0.j.a<>(4);
                        this.f10373c = aVar;
                    }
                    aVar.b(q.error(th));
                    return;
                }
                z = false;
                this.f10372b = true;
            }
            if (z) {
                h.a.c1.a.b(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.f10374d) {
            return;
        }
        synchronized (this) {
            if (this.f10374d) {
                return;
            }
            if (!this.f10372b) {
                this.f10372b = true;
                this.a.onNext(t);
                T();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10373c;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10373c = aVar;
                }
                aVar.a(q.next(t));
            }
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        boolean z = true;
        if (!this.f10374d) {
            synchronized (this) {
                if (!this.f10374d) {
                    if (this.f10372b) {
                        h.a.y0.j.a<Object> aVar = this.f10373c;
                        if (aVar == null) {
                            aVar = new h.a.y0.j.a<>(4);
                            this.f10373c = aVar;
                        }
                        aVar.a(q.disposable(cVar));
                        return;
                    }
                    this.f10372b = true;
                    z = false;
                }
            }
        }
        if (z) {
            cVar.dispose();
        } else {
            this.a.onSubscribe(cVar);
            T();
        }
    }

    @Override // h.a.y0.j.a.InterfaceC0233a, h.a.x0.r
    public boolean test(Object obj) {
        return q.acceptFull(obj, this.a);
    }
}
