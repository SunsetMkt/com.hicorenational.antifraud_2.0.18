package h.a;

/* JADX INFO: compiled from: ObservableEmitter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d0<T> extends k<T> {
    boolean isDisposed();

    @h.a.t0.f
    d0<T> serialize();

    void setCancellable(@h.a.t0.g h.a.x0.f fVar);

    void setDisposable(@h.a.t0.g h.a.u0.c cVar);

    @h.a.t0.e
    boolean tryOnError(@h.a.t0.f Throwable th);
}
