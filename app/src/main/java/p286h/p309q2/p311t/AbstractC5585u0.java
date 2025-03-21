package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5670k;
import p286h.p320w2.InterfaceC5675p;

/* compiled from: MutablePropertyReference2.java */
/* renamed from: h.q2.t.u0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5585u0 extends AbstractC5589w0 implements InterfaceC5670k {
    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22486a(this);
    }

    @Override // p286h.p320w2.InterfaceC5675p
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((InterfaceC5670k) getReflected()).getDelegate(obj, obj2);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5510p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5675p.a getGetter() {
        return ((InterfaceC5670k) getReflected()).getGetter();
    }

    @Override // p286h.p320w2.InterfaceC5667h
    public InterfaceC5670k.a getSetter() {
        return ((InterfaceC5670k) getReflected()).getSetter();
    }
}
