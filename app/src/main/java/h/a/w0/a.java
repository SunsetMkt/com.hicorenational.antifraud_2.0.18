package h.a.w0;

import h.a.l;
import h.a.t0.f;
import h.a.u0.c;
import h.a.y0.e.b.k;
import h.a.y0.e.b.t2;
import h.a.y0.j.g;

/* JADX INFO: compiled from: ConnectableFlowable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends l<T> {
    @f
    public l<T> T() {
        return m(1);
    }

    public final c U() {
        g gVar = new g();
        l((h.a.x0.g<? super c>) gVar);
        return gVar.a;
    }

    @f
    public l<T> V() {
        return h.a.c1.a.a(new t2(this));
    }

    @f
    public l<T> a(int i2, @f h.a.x0.g<? super c> gVar) {
        if (i2 > 0) {
            return h.a.c1.a.a(new k(this, i2, gVar));
        }
        l(gVar);
        return h.a.c1.a.a((a) this);
    }

    public abstract void l(@f h.a.x0.g<? super c> gVar);

    @f
    public l<T> m(int i2) {
        return a(i2, h.a.y0.b.a.d());
    }
}
