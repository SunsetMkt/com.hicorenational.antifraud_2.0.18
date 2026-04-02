package h.a;

/* JADX INFO: compiled from: MaybeObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v<T> {
    void onComplete();

    void onError(@h.a.t0.f Throwable th);

    void onSubscribe(@h.a.t0.f h.a.u0.c cVar);

    void onSuccess(@h.a.t0.f T t);
}
