package h.a.y0.h;

/* JADX INFO: compiled from: BlockingLastSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends c<T> {
    @Override // j.d.c
    public void onError(Throwable th) {
        this.a = null;
        this.f12013b = th;
        countDown();
    }

    @Override // j.d.c
    public void onNext(T t) {
        this.a = t;
    }
}
