package h.a.y0.i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AsyncSubscription.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends AtomicLong implements j.d.d, h.a.u0.c {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<j.d.d> actual;
    final AtomicReference<h.a.u0.c> resource;

    public b() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // j.d.d
    public void cancel() {
        dispose();
    }

    @Override // h.a.u0.c
    public void dispose() {
        j.cancel(this.actual);
        h.a.y0.a.d.dispose(this.resource);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.actual.get() == j.CANCELLED;
    }

    public boolean replaceResource(h.a.u0.c cVar) {
        return h.a.y0.a.d.replace(this.resource, cVar);
    }

    @Override // j.d.d
    public void request(long j2) {
        j.deferredRequest(this.actual, this, j2);
    }

    public boolean setResource(h.a.u0.c cVar) {
        return h.a.y0.a.d.set(this.resource, cVar);
    }

    public void setSubscription(j.d.d dVar) {
        j.deferredSetOnce(this.actual, this, dVar);
    }

    public b(h.a.u0.c cVar) {
        this();
        this.resource.lazySet(cVar);
    }
}
