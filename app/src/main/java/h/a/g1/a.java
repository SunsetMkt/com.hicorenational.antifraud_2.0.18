package h.a.g1;

import h.a.q;
import h.a.y0.i.j;
import h.a.y0.j.i;
import i.q2.t.m0;

/* JADX INFO: compiled from: DefaultSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements q<T> {
    private j.d.d a;

    protected final void a(long j2) {
        j.d.d dVar = this.a;
        if (dVar != null) {
            dVar.request(j2);
        }
    }

    protected void b() {
        a(m0.f12222b);
    }

    @Override // h.a.q
    public final void onSubscribe(j.d.d dVar) {
        if (i.a(this.a, dVar, getClass())) {
            this.a = dVar;
            b();
        }
    }

    protected final void a() {
        j.d.d dVar = this.a;
        this.a = j.CANCELLED;
        dVar.cancel();
    }
}
