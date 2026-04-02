package h.a.y0.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: EmptyCompletableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c, h.a.a1.g {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.a1.g
    public boolean hasCustomOnError() {
        return false;
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.f
    public void onComplete() {
        lazySet(h.a.y0.a.d.DISPOSED);
    }

    @Override // h.a.f
    public void onError(Throwable th) {
        lazySet(h.a.y0.a.d.DISPOSED);
        h.a.c1.a.b(new h.a.v0.d(th));
    }

    @Override // h.a.f
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }
}
