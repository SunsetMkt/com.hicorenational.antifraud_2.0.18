package h.a.y0.h;

/* JADX INFO: compiled from: InnerQueuedSubscriberSupport.java */
/* JADX INFO: loaded from: classes2.dex */
public interface k<T> {
    void drain();

    void innerComplete(j<T> jVar);

    void innerError(j<T> jVar, Throwable th);

    void innerNext(j<T> jVar, T t);
}
