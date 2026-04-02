package h.a.a1;

import h.a.i0;
import h.a.y0.j.q;

/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T> implements i0<T>, h.a.u0.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f10243g = 4;
    final i0<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f10244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h.a.u0.c f10245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f10246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    h.a.y0.j.a<Object> f10247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f10248f;

    public m(@h.a.t0.f i0<? super T> i0Var) {
        this(i0Var, false);
    }

    void a() {
        h.a.y0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f10247e;
                if (aVar == null) {
                    this.f10246d = false;
                    return;
                }
                this.f10247e = null;
            }
        } while (!aVar.a((i0) this.a));
    }

    @Override // h.a.u0.c
    public void dispose() {
        this.f10245c.dispose();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10245c.isDisposed();
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10248f) {
            return;
        }
        synchronized (this) {
            if (this.f10248f) {
                return;
            }
            if (!this.f10246d) {
                this.f10248f = true;
                this.f10246d = true;
                this.a.onComplete();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10247e;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10247e = aVar;
                }
                aVar.a(q.complete());
            }
        }
    }

    @Override // h.a.i0
    public void onError(@h.a.t0.f Throwable th) {
        if (this.f10248f) {
            h.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f10248f) {
                if (this.f10246d) {
                    this.f10248f = true;
                    h.a.y0.j.a<Object> aVar = this.f10247e;
                    if (aVar == null) {
                        aVar = new h.a.y0.j.a<>(4);
                        this.f10247e = aVar;
                    }
                    Object objError = q.error(th);
                    if (this.f10244b) {
                        aVar.a(objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f10248f = true;
                this.f10246d = true;
                z = false;
            }
            if (z) {
                h.a.c1.a.b(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // h.a.i0
    public void onNext(@h.a.t0.f T t) {
        if (this.f10248f) {
            return;
        }
        if (t == null) {
            this.f10245c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f10248f) {
                return;
            }
            if (!this.f10246d) {
                this.f10246d = true;
                this.a.onNext(t);
                a();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10247e;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10247e = aVar;
                }
                aVar.a(q.next(t));
            }
        }
    }

    @Override // h.a.i0
    public void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.f10245c, cVar)) {
            this.f10245c = cVar;
            this.a.onSubscribe(this);
        }
    }

    public m(@h.a.t0.f i0<? super T> i0Var, boolean z) {
        this.a = i0Var;
        this.f10244b = z;
    }
}
