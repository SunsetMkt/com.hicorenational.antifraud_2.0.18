package h.a.y0.d;

import h.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ConsumerSingleObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T> extends AtomicReference<h.a.u0.c> implements n0<T>, h.a.u0.c, h.a.a1.g {
    private static final long serialVersionUID = -7012088219455310787L;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.g<? super T> onSuccess;

    public k(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != h.a.y0.b.a.f10450f;
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.n0
    public void onError(Throwable th) {
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(th, th2));
        }
    }

    @Override // h.a.n0
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // h.a.n0
    public void onSuccess(T t) {
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }
}
