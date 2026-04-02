package h.a.u0;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: Disposables.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private d() {
        throw new IllegalStateException("No instances!");
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f Runnable runnable) {
        h.a.y0.b.b.a(runnable, "run is null");
        return new g(runnable);
    }

    @h.a.t0.f
    public static c b() {
        return a(h.a.y0.b.a.f10446b);
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f h.a.x0.a aVar) {
        h.a.y0.b.b.a(aVar, "run is null");
        return new a(aVar);
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f Future<?> future) {
        h.a.y0.b.b.a(future, "future is null");
        return a(future, true);
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f Future<?> future, boolean z) {
        h.a.y0.b.b.a(future, "future is null");
        return new e(future, z);
    }

    @h.a.t0.f
    public static c a(@h.a.t0.f j.d.d dVar) {
        h.a.y0.b.b.a(dVar, "subscription is null");
        return new i(dVar);
    }

    @h.a.t0.f
    public static c a() {
        return h.a.y0.a.e.INSTANCE;
    }
}
