package h.a.y0.h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: StrictSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public class t<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
    private static final long serialVersionUID = -4945028590049415624L;
    final j.d.c<? super T> actual;
    volatile boolean done;
    final h.a.y0.j.c error = new h.a.y0.j.c();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<j.d.d> s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public t(j.d.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // j.d.d
    public void cancel() {
        if (this.done) {
            return;
        }
        h.a.y0.i.j.cancel(this.s);
    }

    @Override // j.d.c
    public void onComplete() {
        this.done = true;
        h.a.y0.j.l.a(this.actual, this, this.error);
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        this.done = true;
        h.a.y0.j.l.a((j.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // j.d.c
    public void onNext(T t) {
        h.a.y0.j.l.a(this.actual, t, this, this.error);
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            h.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("\u00a72.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        if (j2 > 0) {
            h.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("\u00a73.9 violated: positive request amount required but it was " + j2));
    }
}
