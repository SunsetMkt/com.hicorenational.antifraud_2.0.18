package i.q2.t;

import i.w2.i;
import i.w2.n;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 extends w0 implements i.w2.i {
    public q0() {
    }

    @Override // i.q2.t.p
    protected i.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // i.w2.n
    @i.t0(version = "1.1")
    public Object getDelegate() {
        return ((i.w2.i) getReflected()).getDelegate();
    }

    @Override // i.q2.s.a
    public Object invoke() {
        return get();
    }

    @i.t0(version = "1.1")
    public q0(Object obj) {
        super(obj);
    }

    @Override // i.w2.m
    public n.a getGetter() {
        return ((i.w2.i) getReflected()).getGetter();
    }

    @Override // i.w2.h
    public i.a getSetter() {
        return ((i.w2.i) getReflected()).getSetter();
    }
}
