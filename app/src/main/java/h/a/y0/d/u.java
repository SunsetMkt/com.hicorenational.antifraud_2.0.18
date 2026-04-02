package h.a.y0.d;

/* JADX INFO: compiled from: InnerQueuedObserverSupport.java */
/* JADX INFO: loaded from: classes2.dex */
public interface u<T> {
    void drain();

    void innerComplete(t<T> tVar);

    void innerError(t<T> tVar, Throwable th);

    void innerNext(t<T> tVar, T t);
}
