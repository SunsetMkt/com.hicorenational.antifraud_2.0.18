package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeCallbackObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c, h.a.a1.g {
    private static final long serialVersionUID = -6076952298809384986L;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.g<? super T> onSuccess;

    public d(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
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
        return h.a.y0.a.d.isDisposed(get());
    }

    @Override // h.a.v
    public void onComplete() {
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }

    @Override // h.a.v
    public void onError(Throwable th) {
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(th, th2));
        }
    }

    @Override // h.a.v
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // h.a.v, h.a.n0
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
