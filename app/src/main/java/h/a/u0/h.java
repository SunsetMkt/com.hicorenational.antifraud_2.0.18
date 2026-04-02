package h.a.u0;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SerialDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements c {
    final AtomicReference<c> a;

    public h() {
        this.a = new AtomicReference<>();
    }

    public boolean a(@h.a.t0.g c cVar) {
        return h.a.y0.a.d.replace(this.a, cVar);
    }

    public boolean b(@h.a.t0.g c cVar) {
        return h.a.y0.a.d.set(this.a, cVar);
    }

    @Override // h.a.u0.c
    public void dispose() {
        h.a.y0.a.d.dispose(this.a);
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return h.a.y0.a.d.isDisposed(this.a.get());
    }

    @h.a.t0.g
    public c a() {
        c cVar = this.a.get();
        return cVar == h.a.y0.a.d.DISPOSED ? d.a() : cVar;
    }

    public h(@h.a.t0.g c cVar) {
        this.a = new AtomicReference<>(cVar);
    }
}
