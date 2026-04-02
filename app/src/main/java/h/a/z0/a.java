package h.a.z0;

import h.a.b0;
import h.a.t0.f;
import h.a.u0.c;
import h.a.y0.e.d.i2;
import h.a.y0.e.d.k;
import h.a.y0.j.g;

/* JADX INFO: compiled from: ConnectableObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends b0<T> {
    @f
    public b0<T> O() {
        return i(1);
    }

    public final c P() {
        g gVar = new g();
        k((h.a.x0.g<? super c>) gVar);
        return gVar.a;
    }

    @f
    public b0<T> Q() {
        return h.a.c1.a.a(new i2(this));
    }

    @f
    public b0<T> a(int i2, @f h.a.x0.g<? super c> gVar) {
        if (i2 > 0) {
            return h.a.c1.a.a(new k(this, i2, gVar));
        }
        k(gVar);
        return h.a.c1.a.a((a) this);
    }

    @f
    public b0<T> i(int i2) {
        return a(i2, h.a.y0.b.a.d());
    }

    public abstract void k(@f h.a.x0.g<? super c> gVar);
}
