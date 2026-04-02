package h.a.g1;

import h.a.q;
import h.a.y0.i.g;
import h.a.y0.i.j;

/* JADX INFO: compiled from: SafeSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements q<T>, j.d.d {
    final j.d.c<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    j.d.d f10391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10392c;

    public d(j.d.c<? super T> cVar) {
        this.a = cVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(g.INSTANCE);
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
        this.f10392c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(g.INSTANCE);
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

    @Override // j.d.d
    public void cancel() {
        try {
            this.f10391b.cancel();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10392c) {
            return;
        }
        this.f10392c = true;
        if (this.f10391b == null) {
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

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f10392c) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10392c = true;
        if (this.f10391b != null) {
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
            this.a.onSubscribe(g.INSTANCE);
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

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10392c) {
            return;
        }
        if (this.f10391b == null) {
            b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f10391b.cancel();
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
                this.f10391b.cancel();
                onError(th2);
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                onError(new h.a.v0.a(th2, th3));
            }
        }
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (j.validate(this.f10391b, dVar)) {
            this.f10391b = dVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10392c = true;
                try {
                    dVar.cancel();
                    h.a.c1.a.b(th);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.c1.a.b(new h.a.v0.a(th, th2));
                }
            }
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        try {
            this.f10391b.request(j2);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            try {
                this.f10391b.cancel();
                h.a.c1.a.b(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                h.a.c1.a.b(new h.a.v0.a(th, th2));
            }
        }
    }
}
