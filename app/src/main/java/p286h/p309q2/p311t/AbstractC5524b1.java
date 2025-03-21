package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5674o;

/* compiled from: PropertyReference1.java */
/* renamed from: h.q2.t.b1 */
/* loaded from: classes2.dex */
public abstract class AbstractC5524b1 extends AbstractC5536f1 implements InterfaceC5674o {
    public AbstractC5524b1() {
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22488a(this);
    }

    @Override // p286h.p320w2.InterfaceC5674o
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((InterfaceC5674o) getReflected()).getDelegate(obj);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5506l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @InterfaceC5610t0(version = "1.1")
    public AbstractC5524b1(Object obj) {
        super(obj);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5674o.a getGetter() {
        return ((InterfaceC5674o) getReflected()).getGetter();
    }
}
