package p031c.p035b.p043c.p062f0.p063c;

/* compiled from: FormatInformation.java */
/* renamed from: c.b.c.f0.c.g */
/* loaded from: classes.dex */
final class C1080g {

    /* renamed from: c */
    private static final int f2129c = 21522;

    /* renamed from: d */
    private static final int[][] f2130d = {new int[]{f2129c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: e */
    private static final int[] f2131e = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    /* renamed from: a */
    private final EnumC1079f f2132a;

    /* renamed from: b */
    private final byte f2133b;

    private C1080g(int i2) {
        this.f2132a = EnumC1079f.forBits((i2 >> 3) & 3);
        this.f2133b = (byte) (i2 & 7);
    }

    /* renamed from: a */
    static C1080g m1761a(int i2, int i3) {
        C1080g m1762b = m1762b(i2, i3);
        return m1762b != null ? m1762b : m1762b(i2 ^ f2129c, i3 ^ f2129c);
    }

    /* renamed from: b */
    private static C1080g m1762b(int i2, int i3) {
        int m1763c;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : f2130d) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new C1080g(iArr[1]);
            }
            int m1763c2 = m1763c(i2, i6);
            if (m1763c2 < i4) {
                i5 = iArr[1];
                i4 = m1763c2;
            }
            if (i2 != i3 && (m1763c = m1763c(i3, i6)) < i4) {
                i5 = iArr[1];
                i4 = m1763c;
            }
        }
        if (i4 <= 3) {
            return new C1080g(i5);
        }
        return null;
    }

    /* renamed from: c */
    static int m1763c(int i2, int i3) {
        int i4 = i2 ^ i3;
        int[] iArr = f2131e;
        return iArr[i4 & 15] + iArr[(i4 >>> 4) & 15] + iArr[(i4 >>> 8) & 15] + iArr[(i4 >>> 12) & 15] + iArr[(i4 >>> 16) & 15] + iArr[(i4 >>> 20) & 15] + iArr[(i4 >>> 24) & 15] + iArr[(i4 >>> 28) & 15];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1080g)) {
            return false;
        }
        C1080g c1080g = (C1080g) obj;
        return this.f2132a == c1080g.f2132a && this.f2133b == c1080g.f2133b;
    }

    public int hashCode() {
        return (this.f2132a.ordinal() << 3) | this.f2133b;
    }

    /* renamed from: a */
    byte m1764a() {
        return this.f2133b;
    }

    /* renamed from: b */
    EnumC1079f m1765b() {
        return this.f2132a;
    }
}
