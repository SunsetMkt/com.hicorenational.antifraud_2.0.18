package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5675p;

/* compiled from: PropertyReference2.java */
/* renamed from: h.q2.t.d1 */
/* loaded from: classes2.dex */
public abstract class AbstractC5530d1 extends AbstractC5536f1 implements InterfaceC5675p {
    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22489a(this);
    }

    @Override // p286h.p320w2.InterfaceC5675p
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((InterfaceC5675p) getReflected()).getDelegate(obj, obj2);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5510p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5675p.a getGetter() {
        return ((InterfaceC5675p) getReflected()).getGetter();
    }
}
