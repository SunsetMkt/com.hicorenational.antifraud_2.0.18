package i.q2.t;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f1 extends p implements i.w2.m {
    public f1() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            return getOwner().equals(f1Var.getOwner()) && getName().equals(f1Var.getName()) && getSignature().equals(f1Var.getSignature()) && i0.a(getBoundReceiver(), f1Var.getBoundReceiver());
        }
        if (obj instanceof i.w2.m) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // i.w2.m
    @i.t0(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // i.w2.m
    @i.t0(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        i.w2.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @i.t0(version = "1.1")
    public f1(Object obj) {
        super(obj);
    }

    @Override // i.q2.t.p
    @i.t0(version = "1.1")
    public i.w2.m getReflected() {
        return (i.w2.m) super.getReflected();
    }
}
