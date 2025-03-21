package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5669j;
import p286h.p320w2.InterfaceC5674o;

/* compiled from: MutablePropertyReference1.java */
/* renamed from: h.q2.t.s0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5581s0 extends AbstractC5589w0 implements InterfaceC5669j {
    public AbstractC5581s0() {
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22485a(this);
    }

    @Override // p286h.p320w2.InterfaceC5674o
    @InterfaceC5610t0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((InterfaceC5669j) getReflected()).getDelegate(obj);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5506l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @InterfaceC5610t0(version = "1.1")
    public AbstractC5581s0(Object obj) {
        super(obj);
    }

    @Override // p286h.p320w2.InterfaceC5672m
    public InterfaceC5674o.a getGetter() {
        return ((InterfaceC5669j) getReflected()).getGetter();
    }

    @Override // p286h.p320w2.InterfaceC5667h
    public InterfaceC5669j.a getSetter() {
        return ((InterfaceC5669j) getReflected()).getSetter();
    }
}
