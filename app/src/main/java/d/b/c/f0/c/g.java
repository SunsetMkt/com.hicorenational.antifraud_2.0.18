package d.b.c.f0.c;

/* JADX INFO: compiled from: FormatInformation.java */
/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9786c = 21522;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f9787d = {new int[]{f9786c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9788e = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f9789b;

    private g(int i2) {
        this.a = f.forBits((i2 >> 3) & 3);
        this.f9789b = (byte) (i2 & 7);
    }

    static g a(int i2, int i3) {
        g gVarB = b(i2, i3);
        return gVarB != null ? gVarB : b(i2 ^ f9786c, i3 ^ f9786c);
    }

    private static g b(int i2, int i3) {
        int iC;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : f9787d) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new g(iArr[1]);
            }
            int iC2 = c(i2, i6);
            if (iC2 < i4) {
                i5 = iArr[1];
                i4 = iC2;
            }
            if (i2 != i3 && (iC = c(i3, i6)) < i4) {
                i5 = iArr[1];
                i4 = iC;
            }
        }
        if (i4 <= 3) {
            return new g(i5);
        }
        return null;
    }

    static int c(int i2, int i3) {
        int i4 = i2 ^ i3;
        int[] iArr = f9788e;
        return iArr[i4 & 15] + iArr[(i4 >>> 4) & 15] + iArr[(i4 >>> 8) & 15] + iArr[(i4 >>> 12) & 15] + iArr[(i4 >>> 16) & 15] + iArr[(i4 >>> 20) & 15] + iArr[(i4 >>> 24) & 15] + iArr[(i4 >>> 28) & 15];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && this.f9789b == gVar.f9789b;
    }

    public int hashCode() {
        return (this.a.ordinal() << 3) | this.f9789b;
    }

    byte a() {
        return this.f9789b;
    }

    f b() {
        return this.a;
    }
}
