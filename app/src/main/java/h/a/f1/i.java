package h.a.f1;

import h.a.b0;
import h.a.i0;

/* JADX INFO: compiled from: Subject.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T> extends b0<T> implements i0<T> {
    @h.a.t0.g
    public abstract Throwable O();

    public abstract boolean P();

    public abstract boolean Q();

    public abstract boolean R();

    @h.a.t0.f
    public final i<T> S() {
        return this instanceof g ? this : new g(this);
    }
}
