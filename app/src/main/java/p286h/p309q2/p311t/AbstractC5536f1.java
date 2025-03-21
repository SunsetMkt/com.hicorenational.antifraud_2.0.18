package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5672m;

/* compiled from: PropertyReference.java */
/* renamed from: h.q2.t.f1 */
/* loaded from: classes2.dex */
public abstract class AbstractC5536f1 extends AbstractC5564p implements InterfaceC5672m {
    public AbstractC5536f1() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC5536f1) {
            AbstractC5536f1 abstractC5536f1 = (AbstractC5536f1) obj;
            return getOwner().equals(abstractC5536f1.getOwner()) && getName().equals(abstractC5536f1.getName()) && getSignature().equals(abstractC5536f1.getSignature()) && C5544i0.m22531a(getBoundReceiver(), abstractC5536f1.getBoundReceiver());
        }
        if (obj instanceof InterfaceC5672m) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p286h.p320w2.InterfaceC5672m
    @InterfaceC5610t0(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // p286h.p320w2.InterfaceC5672m
    @InterfaceC5610t0(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        InterfaceC5661b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @InterfaceC5610t0(version = "1.1")
    public AbstractC5536f1(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5564p
    @InterfaceC5610t0(version = "1.1")
    public InterfaceC5672m getReflected() {
        return (InterfaceC5672m) super.getReflected();
    }
}
