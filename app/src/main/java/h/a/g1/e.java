package h.a.g1;

import h.a.q;
import h.a.y0.i.j;

/* JADX INFO: compiled from: SerializedSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> implements q<T>, j.d.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f10393g = 4;
    final j.d.c<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f10394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j.d.d f10395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f10396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    h.a.y0.j.a<Object> f10397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f10398f;

    public e(j.d.c<? super T> cVar) {
        this(cVar, false);
    }

    void a() {
        h.a.y0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f10397e;
                if (aVar == null) {
                    this.f10396d = false;
                    return;
                }
                this.f10397e = null;
            }
        } while (!aVar.a((j.d.c) this.a));
    }

    @Override // j.d.d
    public void cancel() {
        this.f10395c.cancel();
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10398f) {
            return;
        }
        synchronized (this) {
            if (this.f10398f) {
                return;
            }
            if (!this.f10396d) {
                this.f10398f = true;
                this.f10396d = true;
                this.a.onComplete();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10397e;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10397e = aVar;
                }
                aVar.a(h.a.y0.j.q.complete());
            }
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.f10398f) {
            h.a.c1.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f10398f) {
                if (this.f10396d) {
                    this.f10398f = true;
                    h.a.y0.j.a<Object> aVar = this.f10397e;
                    if (aVar == null) {
                        aVar = new h.a.y0.j.a<>(4);
                        this.f10397e = aVar;
                    }
                    Object objError = h.a.y0.j.q.error(th);
                    if (this.f10394b) {
                        aVar.a(objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f10398f = true;
                this.f10396d = true;
                z = false;
            }
            if (z) {
                h.a.c1.a.b(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10398f) {
            return;
        }
        if (t == null) {
            this.f10395c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f10398f) {
                return;
            }
            if (!this.f10396d) {
                this.f10396d = true;
                this.a.onNext(t);
                a();
            } else {
                h.a.y0.j.a<Object> aVar = this.f10397e;
                if (aVar == null) {
                    aVar = new h.a.y0.j.a<>(4);
                    this.f10397e = aVar;
                }
                aVar.a(h.a.y0.j.q.next(t));
            }
        }
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (j.validate(this.f10395c, dVar)) {
            this.f10395c = dVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        this.f10395c.request(j2);
    }

    public e(j.d.c<? super T> cVar, boolean z) {
        this.a = cVar;
        this.f10394b = z;
    }
}
