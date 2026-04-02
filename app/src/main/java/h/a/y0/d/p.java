package h.a.y0.d;

import h.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ForEachWhileObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T> extends AtomicReference<h.a.u0.c> implements i0<T>, h.a.u0.c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.r<? super T> onNext;

    public p(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar, h.a.x0.a aVar) {
        this.onNext = rVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return h.a.y0.a.d.isDisposed(get());
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.done) {
            h.a.c1.a.b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(th, th2));
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }
}
