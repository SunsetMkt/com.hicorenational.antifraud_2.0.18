package h.a.y0.h;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LambdaSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l<T> extends AtomicReference<j.d.d> implements h.a.q<T>, j.d.d, h.a.u0.c, h.a.a1.g {
    private static final long serialVersionUID = -7251123623727029452L;
    final h.a.x0.a onComplete;
    final h.a.x0.g<? super Throwable> onError;
    final h.a.x0.g<? super T> onNext;
    final h.a.x0.g<? super j.d.d> onSubscribe;

    public l(h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.g<? super j.d.d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // j.d.d
    public void cancel() {
        h.a.y0.i.j.cancel(this);
    }

    @Override // h.a.u0.c
    public void dispose() {
        cancel();
    }

    @Override // h.a.a1.g
    public boolean hasCustomOnError() {
        return this.onError != h.a.y0.b.a.f10450f;
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == h.a.y0.i.j.CANCELLED;
    }

    @Override // j.d.c
    public void onComplete() {
        j.d.d dVar = get();
        h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
        if (dVar != jVar) {
            lazySet(jVar);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        j.d.d dVar = get();
        h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
        if (dVar == jVar) {
            h.a.c1.a.b(th);
            return;
        }
        lazySet(jVar);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.c1.a.b(new h.a.v0.a(th, th2));
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // j.d.d
    public void request(long j2) {
        get().request(j2);
    }
}
