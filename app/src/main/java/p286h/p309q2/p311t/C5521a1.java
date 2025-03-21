package p286h.p309q2.p311t;

import p286h.p320w2.InterfaceC5665f;

/* compiled from: PropertyReference0Impl.java */
/* renamed from: h.q2.t.a1 */
/* loaded from: classes2.dex */
public class C5521a1 extends AbstractC5595z0 {
    private final String name;
    private final InterfaceC5665f owner;
    private final String signature;

    public C5521a1(InterfaceC5665f interfaceC5665f, String str, String str2) {
        this.owner = interfaceC5665f;
        this.name = str;
        this.signature = str2;
    }

    @Override // p286h.p320w2.InterfaceC5673n
    public Object get() {
        return getGetter().call(new Object[0]);
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
}
