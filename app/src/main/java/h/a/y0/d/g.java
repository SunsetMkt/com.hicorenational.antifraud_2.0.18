package h.a.y0.d;

/* JADX INFO: compiled from: BlockingLastObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends e<T> {
    @Override // h.a.i0
    public void onError(Throwable th) {
        this.a = null;
        this.f10467b = th;
        countDown();
    }

    @Override // h.a.i0
    public void onNext(T t) {
        this.a = t;
    }
}
