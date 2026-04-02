package h.a.y0.d;

import h.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BiConsumerSingleObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends AtomicReference<h.a.u0.c> implements n0<T>, h.a.u0.c {
    private static final long serialVersionUID = 4943102778943297569L;
    final h.a.x0.b<? super T, ? super Throwable> onCallback;

    public d(h.a.x0.b<? super T, ? super Throwable> bVar) {
        this.onCallback = bVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.n0
    public void onError(Throwable th) {
        try {
            lazySet(h.a.y0.a.d.DISPOSED);
            this.onCallback.a(null, th);
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
        try {
            lazySet(h.a.y0.a.d.DISPOSED);
            this.onCallback.a(t, null);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.c1.a.b(th);
        }
    }
}
