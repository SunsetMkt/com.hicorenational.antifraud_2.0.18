package h.a.y0.h;

/* JADX INFO: compiled from: BlockingFirstSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends c<T> {
    @Override // j.d.c
    public void onError(Throwable th) {
        if (this.a == null) {
            this.f12013b = th;
        } else {
            h.a.c1.a.b(th);
        }
        countDown();
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.f12014c.cancel();
            countDown();
        }
    }
}
