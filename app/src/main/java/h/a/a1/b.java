package h.a.a1;

import h.a.i0;

/* JADX INFO: compiled from: DefaultObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements i0<T> {
    private h.a.u0.c a;

    protected final void a() {
        h.a.u0.c cVar = this.a;
        this.a = h.a.y0.a.d.DISPOSED;
        cVar.dispose();
    }

    protected void b() {
    }

    @Override // h.a.i0
    public final void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (h.a.y0.j.i.a(this.a, cVar, getClass())) {
            this.a = cVar;
            b();
        }
    }
}
