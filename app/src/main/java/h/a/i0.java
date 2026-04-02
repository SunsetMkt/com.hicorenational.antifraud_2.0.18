package h.a;

/* JADX INFO: compiled from: Observer.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i0<T> {
    void onComplete();

    void onError(@h.a.t0.f Throwable th);

    void onNext(@h.a.t0.f T t);

    void onSubscribe(@h.a.t0.f h.a.u0.c cVar);
}
