package j.d;

/* JADX INFO: compiled from: Subscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(d dVar);
}
