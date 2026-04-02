package h.a.y0.h;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SubscriberResourceWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u<T> extends AtomicReference<h.a.u0.c> implements h.a.q<T>, h.a.u0.c, j.d.d {
    private static final long serialVersionUID = -8612022020200669122L;
    final j.d.c<? super T> actual;
    final AtomicReference<j.d.d> subscription = new AtomicReference<>();

    public u(j.d.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // j.d.d
    public void cancel() {
        dispose();
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.i.j.cancel(this.subscription);
        h.a.y0.a.d.dispose(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.subscription.get() == h.a.y0.i.j.CANCELLED;
    }

    @Override // j.d.c
    public void onComplete() {
        h.a.y0.a.d.dispose(this);
        this.actual.onComplete();
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        h.a.y0.a.d.dispose(this);
        this.actual.onError(th);
    }

    @Override // j.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.setOnce(this.subscription, dVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        if (h.a.y0.i.j.validate(j2)) {
            this.subscription.get().request(j2);
        }
    }

    public void setResource(h.a.u0.c cVar) {
        h.a.y0.a.d.set(this, cVar);
    }
}
