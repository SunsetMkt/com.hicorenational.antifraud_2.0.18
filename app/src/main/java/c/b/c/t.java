package c.b.c;

/* compiled from: ResultPoint.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private final float f2850a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2851b;

    public t(float f2, float f3) {
        this.f2850a = f2;
        this.f2851b = f3;
    }

    public final float a() {
        return this.f2850a;
    }

    public final float b() {
        return this.f2851b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f2850a == tVar.f2850a && this.f2851b == tVar.f2851b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2850a) * 31) + Float.floatToIntBits(this.f2851b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f2850a);
        sb.append(',');
        sb.append(this.f2851b);
        sb.append(')');
        return sb.toString();
    }

    public static void a(t[] tVarArr) {
        t tVar;
        t tVar2;
        t tVar3;
        float a2 = a(tVarArr[0], tVarArr[1]);
        float a3 = a(tVarArr[1], tVarArr[2]);
        float a4 = a(tVarArr[0], tVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            tVar = tVarArr[0];
            tVar2 = tVarArr[1];
            tVar3 = tVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
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
        return c.b.c.z.m.a.a(tVar.f2850a, tVar.f2851b, tVar2.f2850a, tVar2.f2851b);
    }

    private static float a(t tVar, t tVar2, t tVar3) {
        float f2 = tVar2.f2850a;
        float f3 = tVar2.f2851b;
        return ((tVar3.f2850a - f2) * (tVar.f2851b - f3)) - ((tVar3.f2851b - f3) * (tVar.f2850a - f2));
    }
}
