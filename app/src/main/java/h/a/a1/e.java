package h.a.a1;

import h.a.i0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DisposableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> implements i0<T>, h.a.u0.c {
    final AtomicReference<h.a.u0.c> a = new AtomicReference<>();

    protected void a() {
    }

    @Override // h.a.u0.c
    public final void dispose() {
        h.a.y0.a.d.dispose(this.a);
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return this.a.get() == h.a.y0.a.d.DISPOSED;
    }

    @Override // h.a.i0
    public final void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (h.a.y0.j.i.a(this.a, cVar, getClass())) {
            a();
        }
    }
}
