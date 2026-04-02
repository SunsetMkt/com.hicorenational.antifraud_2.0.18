package h.a.y0.d;

/* JADX INFO: compiled from: BlockingFirstObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends e<T> {
    @Override // h.a.i0
    public void onError(Throwable th) {
        if (this.a == null) {
            this.f10467b = th;
        }
        countDown();
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.f10468c.dispose();
            countDown();
        }
    }
}
