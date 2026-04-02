package h.a.y0.h;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BlockingSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends AtomicReference<j.d.d> implements h.a.q<T>, j.d.d {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public f(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // j.d.d
    public void cancel() {
        if (h.a.y0.i.j.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == h.a.y0.i.j.CANCELLED;
    }

    @Override // j.d.c
    public void onComplete() {
        this.queue.offer(h.a.y0.j.q.complete());
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        this.queue.offer(h.a.y0.j.q.error(th));
    }

    @Override // j.d.c
    public void onNext(T t) {
        this.queue.offer(h.a.y0.j.q.next(t));
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.setOnce(this, dVar)) {
            this.queue.offer(h.a.y0.j.q.subscription(this));
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        get().request(j2);
    }
}
