package h.a.y0.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CallbackCompletableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c, h.a.x0.g<Throwable>, h.a.a1.g {
    private static final long serialVersionUID = -4361286194466301354L;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;

    public j(h.a.x0.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.f
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
        lazySet(h.a.y0.a.d.DISPOSED);
    }

    @Override // h.a.f
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(th2);
        }
        lazySet(h.a.y0.a.d.DISPOSED);
    }

    @Override // h.a.f
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }

    @Override // h.a.x0.g
    public void accept(Throwable th) {
        h.a.c1.a.b(new h.a.v0.d(th));
    }

    public j(h.a.x0.g<? super Throwable> gVar, h.a.x0.a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
