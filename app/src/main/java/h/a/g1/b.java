package h.a.g1;

import h.a.q;
import h.a.y0.i.j;
import h.a.y0.j.i;
import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DisposableSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements q<T>, h.a.u0.c {
    final AtomicReference<j.d.d> a = new AtomicReference<>();

    protected final void a(long j2) {
        this.a.get().request(j2);
    }

    protected void b() {
        this.a.get().request(m0.f12222b);
    }

    @Override // h.a.u0.c
    public final void dispose() {
        j.cancel(this.a);
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return this.a.get() == j.CANCELLED;
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (i.a(this.a, dVar, getClass())) {
            b();
        }
    }

    protected final void a() {
        dispose();
    }
}
