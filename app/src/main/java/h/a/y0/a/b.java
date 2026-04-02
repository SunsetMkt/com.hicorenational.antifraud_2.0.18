package h.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CancellableDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends AtomicReference<h.a.x0.f> implements h.a.u0.c {
    private static final long serialVersionUID = 5718521705281392066L;

    public b(h.a.x0.f fVar) {
        super(fVar);
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.x0.f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            h.a.v0.b.b(e2);
            h.a.c1.a.b(e2);
        }
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return get() == null;
    }
}
