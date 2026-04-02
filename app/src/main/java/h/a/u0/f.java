package h.a.u0;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ReferenceDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class f<T> extends AtomicReference<T> implements c {
    private static final long serialVersionUID = 6537757548749041217L;

    f(T t) {
        super(h.a.y0.b.b.a((Object) t, "value is null"));
    }

    @Override // h.a.u0.c
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return get() == null;
    }

    protected abstract void onDisposed(@h.a.t0.f T t);
}
