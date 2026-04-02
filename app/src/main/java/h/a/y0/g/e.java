package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ImmediateThinScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f11940b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final j0.c f11941c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final h.a.u0.c f11942d = h.a.u0.d.b();

    static {
        f11942d.dispose();
    }

    private e() {
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
        runnable.run();
        return f11942d;
    }

    /* JADX INFO: compiled from: ImmediateThinScheduler.java */
    static final class a extends j0.c {
        a() {
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            runnable.run();
            return e.f11942d;
        }

        @Override // h.a.u0.c
        public void dispose() {
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return false;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // h.a.j0
    @h.a.t0.f
    public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return f11941c;
    }
}
