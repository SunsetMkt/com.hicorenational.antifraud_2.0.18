package p286h.p309q2.p311t;

import p286h.p320w2.InterfaceC5665f;

/* compiled from: PropertyReference1Impl.java */
/* renamed from: h.q2.t.c1 */
/* loaded from: classes2.dex */
public class C5527c1 extends AbstractC5524b1 {
    private final String name;
    private final InterfaceC5665f owner;
    private final String signature;

    public C5527c1(InterfaceC5665f interfaceC5665f, String str, String str2) {
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
}
