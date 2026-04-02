package h.a.d1;

import h.a.l;
import h.a.q;

/* JADX INFO: compiled from: FlowableProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends l<T> implements j.d.a<T, T>, q<T> {
    public abstract Throwable T();

    public abstract boolean U();

    public abstract boolean V();

    public abstract boolean W();

    @h.a.t0.f
    public final c<T> X() {
        return this instanceof f ? this : new f(this);
    }
}
