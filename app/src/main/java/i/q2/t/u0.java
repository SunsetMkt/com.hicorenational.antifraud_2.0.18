package i.q2.t;

import i.w2.k;
import i.w2.p;

/* JADX INFO: compiled from: MutablePropertyReference2.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 extends w0 implements i.w2.k {
    @Override // i.q2.t.p
    protected i.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // i.w2.p
    @i.t0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((i.w2.k) getReflected()).getDelegate(obj, obj2);
    }

    @Override // i.q2.s.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // i.w2.m
    public p.a getGetter() {
        return ((i.w2.k) getReflected()).getGetter();
    }

    @Override // i.w2.h
    public k.a getSetter() {
        return ((i.w2.k) getReflected()).getSetter();
    }
}
