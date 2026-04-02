package h.a.y0.d;

import h.a.i0;

/* JADX INFO: compiled from: DisposableLambdaObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n<T> implements i0<T>, h.a.u0.c {
    final i0<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.g<? super h.a.u0.c> f10473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.a f10474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    h.a.u0.c f10475d;

    public n(i0<? super T> i0Var, h.a.x0.g<? super h.a.u0.c> gVar, h.a.x0.a aVar) {
        this.a = i0Var;
        this.f10473b = gVar;
        this.f10474c = aVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        try {
            this.f10474c.run();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
        this.f10475d.dispose();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f10475d.isDisposed();
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10475d != h.a.y0.a.d.DISPOSED) {
            this.a.onComplete();
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.f10475d != h.a.y0.a.d.DISPOSED) {
            this.a.onError(th);
        } else {
            h.a.c1.a.b(th);
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        try {
            this.f10473b.accept(cVar);
            if (h.a.y0.a.d.validate(this.f10475d, cVar)) {
                this.f10475d = cVar;
                this.a.onSubscribe(this);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            cVar.dispose();
            this.f10475d = h.a.y0.a.d.DISPOSED;
            h.a.y0.a.e.error(th, this.a);
        }
    }
}
