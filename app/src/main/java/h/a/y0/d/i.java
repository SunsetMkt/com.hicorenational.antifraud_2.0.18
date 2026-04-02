package h.a.y0.d;

import h.a.i0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BlockingObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> extends AtomicReference<h.a.u0.c> implements i0<T>, h.a.u0.c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public i(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // h.a.u0.c
    public void dispose() {
        if (h.a.y0.a.d.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.i0
    public void onComplete() {
        this.queue.offer(h.a.y0.j.q.complete());
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        this.queue.offer(h.a.y0.j.q.error(th));
    }

    @Override // h.a.i0
    public void onNext(T t) {
        this.queue.offer(h.a.y0.j.q.next(t));
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this, cVar);
    }
}
