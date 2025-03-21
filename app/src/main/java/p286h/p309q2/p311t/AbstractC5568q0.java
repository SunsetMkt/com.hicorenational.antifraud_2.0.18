package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5668i;
import p286h.p320w2.InterfaceC5673n;

/* compiled from: MutablePropertyReference0.java */
/* renamed from: h.q2.t.q0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5568q0 extends AbstractC5589w0 implements InterfaceC5668i {
    public AbstractC5568q0() {
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22484a(this);
    }

    @Override // p286h.p320w2.InterfaceC5673n
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate() {
        return ((InterfaceC5668i) getReflected()).getDelegate();
    }

    @Override // p286h.p309q2.p310s.InterfaceC5495a
    public Object invoke() {
        return get();
    }

    @InterfaceC5610t0(version = "1.1")
    public AbstractC5568q0(Object obj) {
        super(obj);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5673n.a getGetter() {
        return ((InterfaceC5668i) getReflected()).getGetter();
    }

    @Override // p286h.p320w2.InterfaceC5667h
    public InterfaceC5668i.a getSetter() {
        return ((InterfaceC5668i) getReflected()).getSetter();
    }
}
