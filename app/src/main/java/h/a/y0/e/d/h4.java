package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObserverResourceWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h4<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
    private static final long serialVersionUID = -8612022020200669122L;
    final h.a.i0<? super T> actual;
    final AtomicReference<h.a.u0.c> subscription = new AtomicReference<>();

    public h4(h.a.i0<? super T> i0Var) {
        this.actual = i0Var;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this.subscription);
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.subscription.get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.i0
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // h.a.i0
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.setOnce(this.subscription, cVar)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(h.a.u0.c cVar) {
        h.a.y0.a.d.set(this, cVar);
    }
}
