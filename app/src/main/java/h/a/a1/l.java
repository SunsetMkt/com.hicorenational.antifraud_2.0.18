package h.a.a1;

import h.a.i0;

/* JADX INFO: compiled from: SafeObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l<T> implements i0<T>, h.a.u0.c {
    final i0<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    h.a.u0.c f10241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10242c;

    public l(@h.a.t0.f i0<? super T> i0Var) {
        this.a = i0Var;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.a.y0.a.e.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(new h.a.v0.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(nullPointerException, th2));
        }
    }

    void b() {
        this.f10242c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.a.y0.a.e.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(new h.a.v0.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(nullPointerException, th2));
        }
    }

    @Override // h.a.u0.c
    public void dispose() {
        this.f10241b.dispose();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10241b.isDisposed();
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10242c) {
            return;
        }
        this.f10242c = true;
        if (this.f10241b == null) {
            a();
            return;
        }
        try {
            this.a.onComplete();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }

    @Override // h.a.i0
    public void onError(@h.a.t0.f Throwable th) {
        if (this.f10242c) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10242c = true;
        if (this.f10241b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.a.onError(th);
                return;
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                h.a.c1.a.b(new h.a.v0.a(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.a.y0.a.e.INSTANCE);
            try {
                this.a.onError(new h.a.v0.a(th, nullPointerException));
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.c1.a.b(new h.a.v0.a(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            h.a.v0.b.b(th4);
            h.a.c1.a.b(new h.a.v0.a(th, nullPointerException, th4));
        }
    }

    @Override // h.a.i0
    public void onNext(@h.a.t0.f T t) {
        if (this.f10242c) {
            return;
        }
        if (this.f10241b == null) {
            b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f10241b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(new h.a.v0.a(nullPointerException, th));
                return;
            }
        }
        try {
            this.a.onNext(t);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            try {
                this.f10241b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                onError(new h.a.v0.a(th2, th3));
            }
        }
    }

    @Override // h.a.i0
    public void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.f10241b, cVar)) {
            this.f10241b = cVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10242c = true;
                try {
                    cVar.dispose();
                    h.a.c1.a.b(th);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.c1.a.b(new h.a.v0.a(th, th2));
                }
            }
        }
    }
}
