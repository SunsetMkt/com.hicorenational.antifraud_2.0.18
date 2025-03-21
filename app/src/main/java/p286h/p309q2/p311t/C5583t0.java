package p286h.p309q2.p311t;

import p286h.p320w2.InterfaceC5665f;

/* compiled from: MutablePropertyReference1Impl.java */
/* renamed from: h.q2.t.t0 */
/* loaded from: classes2.dex */
public class C5583t0 extends AbstractC5581s0 {
    private final String name;
    private final InterfaceC5665f owner;
    private final String signature;

    public C5583t0(InterfaceC5665f interfaceC5665f, String str, String str2) {
        this.owner = interfaceC5665f;
        this.name = str;
        this.signature = str2;
    }

    @Override // p286h.p320w2.InterfaceC5674o
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p, p286h.p320w2.InterfaceC5661b
    public String getName() {
        return this.name;
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    public InterfaceC5665f getOwner() {
        return this.owner;
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    public String getSignature() {
        return this.signature;
    }

    @Override // p286h.p320w2.InterfaceC5669j
    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}
