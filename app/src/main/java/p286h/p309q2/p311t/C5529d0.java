package p286h.p309q2.p311t;

import p286h.InterfaceC5610t0;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5666g;

/* compiled from: FunctionReference.java */
/* renamed from: h.q2.t.d0 */
/* loaded from: classes2.dex */
public class C5529d0 extends AbstractC5564p implements InterfaceC5523b0, InterfaceC5666g {
    private final int arity;

    public C5529d0(int i2) {
        this.arity = i2;
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p
    @InterfaceC5610t0(version = "1.1")
    protected InterfaceC5661b computeReflected() {
        return C5542h1.m22483a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5529d0)) {
            if (obj instanceof InterfaceC5666g) {
                return obj.equals(compute());
            }
            return false;
        }
        C5529d0 c5529d0 = (C5529d0) obj;
        if (getOwner() != null ? getOwner().equals(c5529d0.getOwner()) : c5529d0.getOwner() == null) {
            if (getName().equals(c5529d0.getName()) && getSignature().equals(c5529d0.getSignature()) && C5544i0.m22531a(getBoundReceiver(), c5529d0.getBoundReceiver())) {
                return true;
            }
        }
        return false;
    }

    @Override // p286h.p309q2.p311t.InterfaceC5523b0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // p286h.p309q2.p311t.AbstractC5564p, p286h.p320w2.InterfaceC5661b, p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC5661b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p286h.p309q2.p311t.AbstractC5564p
    @InterfaceC5610t0(version = "1.1")
    public InterfaceC5666g getReflected() {
        return (InterfaceC5666g) super.getReflected();
    }

    @InterfaceC5610t0(version = "1.1")
    public C5529d0(int i2, Object obj) {
        super(obj);
        this.arity = i2;
    }
}
