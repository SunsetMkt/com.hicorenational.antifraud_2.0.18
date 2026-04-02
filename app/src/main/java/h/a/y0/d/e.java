package h.a.y0.d;

import h.a.i0;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingBaseObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> extends CountDownLatch implements i0<T>, h.a.u0.c {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f10467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h.a.u0.c f10468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f10469d;

    public e() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                h.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw h.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f10467b;
        if (th == null) {
            return this.a;
        }
        throw h.a.y0.j.k.c(th);
    }

    @Override // h.a.u0.c
    public final void dispose() {
        this.f10469d = true;
        h.a.u0.c cVar = this.f10468c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return this.f10469d;
    }

    @Override // h.a.i0
    public final void onComplete() {
        countDown();
    }

    @Override // h.a.i0
    public final void onSubscribe(h.a.u0.c cVar) {
        this.f10468c = cVar;
        if (this.f10469d) {
            cVar.dispose();
        }
    }
}
