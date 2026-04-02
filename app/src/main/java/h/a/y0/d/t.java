package h.a.y0.d;

import h.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: InnerQueuedObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t<T> extends AtomicReference<h.a.u0.c> implements i0<T>, h.a.u0.c {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final u<T> parent;
    final int prefetch;
    h.a.y0.c.o<T> queue;

    public t(u<T> uVar, int i2) {
        this.parent = uVar;
        this.prefetch = i2;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return h.a.y0.a.d.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // h.a.i0
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.setOnce(this, cVar)) {
            if (cVar instanceof h.a.y0.c.j) {
                h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                int iRequestFusion = jVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = jVar;
                    return;
                }
            }
            this.queue = h.a.y0.j.v.a(-this.prefetch);
        }
    }

    public h.a.y0.c.o<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
