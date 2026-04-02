package h.a;

/* JADX INFO: compiled from: FlowableEmitter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n<T> extends k<T> {
    boolean isCancelled();

    long requested();

    @h.a.t0.f
    n<T> serialize();

    void setCancellable(@h.a.t0.g h.a.x0.f fVar);

    void setDisposable(@h.a.t0.g h.a.u0.c cVar);

    @h.a.t0.e
    boolean tryOnError(@h.a.t0.f Throwable th);
}
