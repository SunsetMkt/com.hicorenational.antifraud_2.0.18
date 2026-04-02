package h.a.g1;

import h.a.q;
import h.a.y0.a.i;
import h.a.y0.i.j;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ResourceSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements q<T>, h.a.u0.c {
    private final AtomicReference<j.d.d> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f10389b = new i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f10390c = new AtomicLong();

    public final void a(h.a.u0.c cVar) {
        h.a.y0.b.b.a(cVar, "resource is null");
        this.f10389b.b(cVar);
    }

    @Override // h.a.u0.c
    public final void dispose() {
        if (j.cancel(this.a)) {
            this.f10389b.dispose();
        }
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return j.isCancelled(this.a.get());
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (h.a.y0.j.i.a(this.a, dVar, (Class<?>) c.class)) {
            long andSet = this.f10390c.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            a();
        }
    }

    protected void a() {
        a(m0.f12222b);
    }

    protected final void a(long j2) {
        j.deferredRequest(this.a, this.f10390c, j2);
    }
}
