package h.a;

/* JADX INFO: compiled from: SingleEmitter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface m0<T> {
    boolean isDisposed();

    void onError(@h.a.t0.f Throwable th);

    void onSuccess(@h.a.t0.f T t);

    void setCancellable(@h.a.t0.g h.a.x0.f fVar);

    void setDisposable(@h.a.t0.g h.a.u0.c cVar);

    @h.a.t0.e
    boolean tryOnError(@h.a.t0.f Throwable th);
}
