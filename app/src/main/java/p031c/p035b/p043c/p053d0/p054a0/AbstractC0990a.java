package p031c.p035b.p043c.p053d0.p054a0;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p053d0.AbstractC1034q;

/* compiled from: AbstractRSSReader.java */
/* renamed from: c.b.c.d0.a0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0990a extends AbstractC1034q {

    /* renamed from: g */
    private static final float f1784g = 0.2f;

    /* renamed from: h */
    private static final float f1785h = 0.45f;

    /* renamed from: i */
    private static final float f1786i = 0.7916667f;

    /* renamed from: j */
    private static final float f1787j = 0.89285713f;

    /* renamed from: a */
    private final int[] f1788a = new int[4];

    /* renamed from: b */
    private final int[] f1789b = new int[8];

    /* renamed from: c */
    private final float[] f1790c = new float[4];

    /* renamed from: d */
    private final float[] f1791d = new float[4];

    /* renamed from: e */
    private final int[] f1792e;

    /* renamed from: f */
    private final int[] f1793f;

    protected AbstractC0990a() {
        int[] iArr = this.f1789b;
        this.f1792e = new int[iArr.length / 2];
        this.f1793f = new int[iArr.length / 2];
    }

    /* renamed from: a */
    protected final int[] m1372a() {
        return this.f1789b;
    }

    /* renamed from: b */
    protected final int[] m1373b() {
        return this.f1788a;
    }

    /* renamed from: c */
    protected final int[] m1374c() {
        return this.f1793f;
    }

    /* renamed from: d */
    protected final float[] m1375d() {
        return this.f1791d;
    }

    /* renamed from: e */
    protected final int[] m1376e() {
        return this.f1792e;
    }

    /* renamed from: f */
    protected final float[] m1377f() {
        return this.f1790c;
    }

    /* renamed from: a */
    protected static int m1368a(int[] iArr, int[][] iArr2) throws C1102m {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (AbstractC1034q.m1508a(iArr, iArr2[i2], f1785h) < f1784g) {
                return i2;
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: b */
    protected static void m1370b(int[] iArr, float[] fArr) {
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

    /* renamed from: a */
    protected static int m1367a(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    /* renamed from: a */
    protected static void m1369a(int[] iArr, float[] fArr) {
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

    /* renamed from: b */
    protected static boolean m1371b(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 < f1786i || f2 > f1787j) {
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
