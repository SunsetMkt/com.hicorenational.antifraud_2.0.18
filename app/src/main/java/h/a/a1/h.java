package h.a.a1;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ResourceCompletableObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements h.a.f, h.a.u0.c {
    private final AtomicReference<h.a.u0.c> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h.a.y0.a.i f10237b = new h.a.y0.a.i();

    protected void a() {
    }

    public final void a(@h.a.t0.f h.a.u0.c cVar) {
        h.a.y0.b.b.a(cVar, "resource is null");
        this.f10237b.b(cVar);
    }

    @Override // h.a.u0.c
    public final void dispose() {
        if (h.a.y0.a.d.dispose(this.a)) {
            this.f10237b.dispose();
        }
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return h.a.y0.a.d.isDisposed(this.a.get());
    }

    @Override // h.a.f
    public final void onSubscribe(@h.a.t0.f h.a.u0.c cVar) {
        if (h.a.y0.j.i.a(this.a, cVar, (Class<?>) h.class)) {
            a();
        }
    }
}
