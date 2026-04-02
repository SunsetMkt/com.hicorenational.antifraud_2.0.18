package i.q2.t;

import i.w2.n;

/* JADX INFO: compiled from: PropertyReference0.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z0 extends f1 implements i.w2.n {
    public z0() {
    }

    @Override // i.q2.t.p
    protected i.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // i.w2.n
    @i.t0(version = "1.1")
    public Object getDelegate() {
        return ((i.w2.n) getReflected()).getDelegate();
    }

    @Override // i.q2.s.a
    public Object invoke() {
        return get();
    }

    @i.t0(version = "1.1")
    public z0(Object obj) {
        super(obj);
    }

    @Override // i.w2.m
    public n.a getGetter() {
        return ((i.w2.n) getReflected()).getGetter();
    }
}
