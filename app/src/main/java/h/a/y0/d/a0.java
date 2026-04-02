package h.a.y0.d;

import h.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ResumeSingleObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0<T> implements n0<T> {
    final AtomicReference<h.a.u0.c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final n0<? super T> f10465b;

    public a0(AtomicReference<h.a.u0.c> atomicReference, n0<? super T> n0Var) {
        this.a = atomicReference;
        this.f10465b = n0Var;
    }

    @Override // h.a.n0
    public void onError(Throwable th) {
        this.f10465b.onError(th);
    }

    @Override // h.a.n0
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.replace(this.a, cVar);
    }

    @Override // h.a.n0
    public void onSuccess(T t) {
        this.f10465b.onSuccess(t);
    }
}
