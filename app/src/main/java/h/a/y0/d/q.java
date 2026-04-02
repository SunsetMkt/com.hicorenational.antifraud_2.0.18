package h.a.y0.d;

import h.a.i0;

/* JADX INFO: compiled from: FullArbiterObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> implements i0<T> {
    final h.a.y0.a.j<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    h.a.u0.c f10476b;

    public q(h.a.y0.a.j<T> jVar) {
        this.a = jVar;
    }

    @Override // h.a.i0
    public void onComplete() {
        this.a.a(this.f10476b);
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        this.a.a(th, this.f10476b);
    }

    @Override // h.a.i0
    public void onNext(T t) {
        this.a.a(t, this.f10476b);
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.f10476b, cVar)) {
            this.f10476b = cVar;
            this.a.b(cVar);
        }
    }
}
