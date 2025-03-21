package p031c.p035b.p043c.p062f0.p063c;

/* compiled from: ErrorCorrectionLevel.java */
/* renamed from: c.b.c.f0.c.f */
/* loaded from: classes.dex */
public enum EnumC1079f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: a */
    private static final EnumC1079f[] f2127a;
    private final int bits;

    static {
        EnumC1079f enumC1079f = L;
        EnumC1079f enumC1079f2 = M;
        EnumC1079f enumC1079f3 = Q;
        f2127a = new EnumC1079f[]{enumC1079f2, enumC1079f, H, enumC1079f3};
    }

    EnumC1079f(int i2) {
        this.bits = i2;
    }

    public static EnumC1079f forBits(int i2) {
        if (i2 >= 0) {
            EnumC1079f[] enumC1079fArr = f2127a;
            if (i2 < enumC1079fArr.length) {
                return enumC1079fArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }
}
