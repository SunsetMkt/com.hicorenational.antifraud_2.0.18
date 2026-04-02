package h.a.y0.h;

import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ForEachWhileSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends AtomicReference<j.d.d> implements h.a.q<T>, h.a.u0.c {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.r<? super T> onNext;

    public h(h.a.x0.r<? super T> rVar, h.a.x0.g<? super Throwable> gVar, h.a.x0.a aVar) {
        this.onNext = rVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.i.j.cancel(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return h.a.y0.i.j.isCancelled(get());
    }

    @Override // j.d.c
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

    @Override // j.d.c
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

    @Override // j.d.c
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

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.setOnce(this, dVar)) {
            dVar.request(m0.f12222b);
        }
    }
}
