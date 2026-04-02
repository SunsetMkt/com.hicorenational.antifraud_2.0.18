package d.b.c.d0.a0;

import d.b.c.d0.q;
import d.b.c.m;

/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f9546g = 0.2f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f9547h = 0.45f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f9548i = 0.7916667f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f9549j = 0.89285713f;
    private final int[] a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f9550b = new int[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f9551c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f9552d = new float[4];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f9553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f9554f;

    protected a() {
        int[] iArr = this.f9550b;
        this.f9553e = new int[iArr.length / 2];
        this.f9554f = new int[iArr.length / 2];
    }

    protected final int[] a() {
        return this.f9550b;
    }

    protected final int[] b() {
        return this.a;
    }

    protected final int[] c() {
        return this.f9554f;
    }

    protected final float[] d() {
        return this.f9552d;
    }

    protected final int[] e() {
        return this.f9553e;
    }

    protected final float[] f() {
        return this.f9551c;
    }

    protected static int a(int[] iArr, int[][] iArr2) throws m {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (q.a(iArr, iArr2[i2], f9547h) < 0.2f) {
                return i2;
            }
        }
        throw m.getNotFoundInstance();
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static int a(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static boolean b(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 < f9548i || f2 > f9549j) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 > i2) {
                i2 = i4;
            }
            if (i4 < i3) {
                i3 = i4;
            }
        }
        return i2 < i3 * 10;
    }
}
