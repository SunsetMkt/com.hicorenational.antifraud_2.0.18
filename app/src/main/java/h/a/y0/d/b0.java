package h.a.y0.d;

/* JADX INFO: compiled from: SubscriberCompletableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0<T> implements h.a.f, j.d.d {
    final j.d.c<? super T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    h.a.u0.c f10466b;

    public b0(j.d.c<? super T> cVar) {
        this.a = cVar;
    }

    @Override // j.d.d
    public void cancel() {
        this.f10466b.dispose();
    }

    @Override // h.a.f
    public void onComplete() {
        this.a.onComplete();
    }

    @Override // h.a.f
    public void onError(Throwable th) {
        this.a.onError(th);
    }

    @Override // h.a.f
    public void onSubscribe(h.a.u0.c cVar) {
        if (h.a.y0.a.d.validate(this.f10466b, cVar)) {
            this.f10466b = cVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // j.d.d
    public void request(long j2) {
    }
}
