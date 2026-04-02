package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NewThreadScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f11971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11968c = "RxNewThreadScheduler";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11970e = "rx2.newthread-priority";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f11969d = new k(f11968c, Math.max(1, Math.min(10, Integer.getInteger(f11970e, 5).intValue())));

    public h() {
        this(f11969d);
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        return new i(this.f11971b);
    }

    public h(ThreadFactory threadFactory) {
        this.f11971b = threadFactory;
    }
}
