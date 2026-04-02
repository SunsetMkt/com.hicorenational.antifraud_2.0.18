package d.b.c;

/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes.dex */
public class t {
    private final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f9855b;

    public t(float f2, float f3) {
        this.a = f2;
        this.f9855b = f3;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.f9855b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a == tVar.a && this.f9855b == tVar.f9855b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.f9855b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.a);
        sb.append(',');
        sb.append(this.f9855b);
        sb.append(')');
        return sb.toString();
    }

    public static void a(t[] tVarArr) {
        t tVar;
        t tVar2;
        t tVar3;
        float fA = a(tVarArr[0], tVarArr[1]);
        float fA2 = a(tVarArr[1], tVarArr[2]);
        float fA3 = a(tVarArr[0], tVarArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            tVar = tVarArr[0];
            tVar2 = tVarArr[1];
            tVar3 = tVarArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            tVar = tVarArr[2];
            tVar2 = tVarArr[0];
            tVar3 = tVarArr[1];
        } else {
            tVar = tVarArr[1];
            tVar2 = tVarArr[0];
            tVar3 = tVarArr[2];
        }
        if (a(tVar2, tVar, tVar3) < 0.0f) {
            t tVar4 = tVar3;
            tVar3 = tVar2;
            tVar2 = tVar4;
        }
        tVarArr[0] = tVar2;
        tVarArr[1] = tVar;
        tVarArr[2] = tVar3;
    }

    public static float a(t tVar, t tVar2) {
        return d.b.c.z.m.a.a(tVar.a, tVar.f9855b, tVar2.a, tVar2.f9855b);
    }

    private static float a(t tVar, t tVar2, t tVar3) {
        float f2 = tVar2.a;
        float f3 = tVar2.f9855b;
        return ((tVar3.a - f2) * (tVar.f9855b - f3)) - ((tVar3.f9855b - f3) * (tVar.a - f2));
    }
}
