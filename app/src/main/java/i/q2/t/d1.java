package i.q2.t;

import i.w2.p;

/* JADX INFO: compiled from: PropertyReference2.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d1 extends f1 implements i.w2.p {
    @Override // i.q2.t.p
    protected i.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // i.w2.p
    @i.t0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((i.w2.p) getReflected()).getDelegate(obj, obj2);
    }

    @Override // i.q2.s.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // i.w2.m
    public p.a getGetter() {
        return ((i.w2.p) getReflected()).getGetter();
    }
}
