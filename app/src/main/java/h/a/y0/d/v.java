package h.a.y0.d;

import h.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LambdaObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T> extends AtomicReference<h.a.u0.c> implements i0<T>, h.a.u0.c, h.a.a1.g {
    private static final long serialVersionUID = -7251123623727029452L;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.g<? super T> onNext;
    final h.a.x0.g<? super h.a.u0.c> onSubscribe;

    public v(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.g<? super h.a.u0.c> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
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

    @Override // h.a.i0
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        lazySet(h.a.y0.a.d.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(th, th2));
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }
}
