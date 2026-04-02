package i.q2.t;

import i.w2.o;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b1 extends f1 implements i.w2.o {
    public b1() {
    }

    @Override // i.q2.t.p
    protected i.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // i.w2.o
    @i.t0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((i.w2.o) getReflected()).getDelegate(obj);
    }

    @Override // i.q2.s.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @i.t0(version = "1.1")
    public b1(Object obj) {
        super(obj);
    }

    @Override // i.w2.m
    public o.a getGetter() {
        return ((i.w2.o) getReflected()).getGetter();
    }
}
