package h.a.y0.j;

import h.a.i0;
import h.a.n0;

/* JADX INFO: compiled from: EmptyComponent.java */
/* JADX INFO: loaded from: classes2.dex */
public enum h implements h.a.q<Object>, i0<Object>, h.a.v<Object>, n0<Object>, h.a.f, j.d.d, h.a.u0.c {
    INSTANCE;

    public static <T> i0<T> asObserver() {
        return INSTANCE;
    }

    public static <T> j.d.c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // j.d.d
    public void cancel() {
    }

    @Override // h.a.u0.c
    public void dispose() {
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return true;
    }

    @Override // j.d.c
    public void onComplete() {
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        h.a.c1.a.b(th);
    }

    @Override // j.d.c
    public void onNext(Object obj) {
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        cVar.dispose();
    }

    @Override // h.a.v, h.a.n0
    public void onSuccess(Object obj) {
    }

    @Override // j.d.d
    public void request(long j2) {
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        dVar.cancel();
    }
}
