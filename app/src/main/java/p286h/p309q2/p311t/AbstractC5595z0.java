package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5673n;

/* compiled from: PropertyReference0.java */
/* renamed from: h.q2.t.z0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5595z0 extends AbstractC5536f1 implements InterfaceC5673n {
    public AbstractC5595z0() {
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22487a(this);
    }

    @Override // p286h.p320w2.InterfaceC5673n
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate() {
        return ((InterfaceC5673n) getReflected()).getDelegate();
    }

    @Override // p286h.p309q2.p310s.InterfaceC5495a
    public Object invoke() {
        return get();
    }

    @InterfaceC5610t0(version = "1.1")
    public AbstractC5595z0(Object obj) {
        super(obj);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5673n.a getGetter() {
        return ((InterfaceC5673n) getReflected()).getGetter();
    }
}
