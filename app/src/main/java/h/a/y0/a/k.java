package h.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SequentialDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends AtomicReference<h.a.u0.c> implements h.a.u0.c {
    private static final long serialVersionUID = -754898800686245608L;

    public k() {
    }

    @Override // h.a.u0.c
    public void dispose() {
        d.dispose(this);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return d.isDisposed(get());
    }

    public boolean replace(h.a.u0.c cVar) {
        return d.replace(this, cVar);
    }

    public boolean update(h.a.u0.c cVar) {
        return d.set(this, cVar);
    }

    public k(h.a.u0.c cVar) {
        lazySet(cVar);
    }
}
