package h.a.y0.h;

import i.q2.t.m0;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingBaseSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends CountDownLatch implements h.a.q<T> {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f12013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j.d.d f12014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f12015d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                j.d.d dVar = this.f12014c;
                this.f12014c = h.a.y0.i.j.CANCELLED;
                if (dVar != null) {
                    dVar.cancel();
                }
                throw h.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f12013b;
        if (th == null) {
            return this.a;
        }
        throw h.a.y0.j.k.c(th);
    }

    @Override // j.d.c
    public final void onComplete() {
        countDown();
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.validate(this.f12014c, dVar)) {
            this.f12014c = dVar;
            if (this.f12015d) {
                return;
            }
            dVar.request(m0.f12222b);
            if (this.f12015d) {
                this.f12014c = h.a.y0.i.j.CANCELLED;
                dVar.cancel();
            }
        }
    }
}
