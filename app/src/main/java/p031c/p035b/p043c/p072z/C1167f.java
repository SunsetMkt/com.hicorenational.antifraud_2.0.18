package p031c.p035b.p043c.p072z;

import p031c.p035b.p043c.C1102m;

/* compiled from: DefaultGridSampler.java */
/* renamed from: c.b.c.z.f */
/* loaded from: classes.dex */
public final class C1167f extends AbstractC1170i {
    @Override // p031c.p035b.p043c.p072z.AbstractC1170i
    /* renamed from: a */
    public C1163b mo2200a(C1163b c1163b, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws C1102m {
        return mo2201a(c1163b, i2, i3, C1172k.m2214a(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
    }

    @Override // p031c.p035b.p043c.p072z.AbstractC1170i
    /* renamed from: a */
    public C1163b mo2201a(C1163b c1163b, int i2, int i3, C1172k c1172k) throws C1102m {
        if (i2 > 0 && i3 > 0) {
            C1163b c1163b2 = new C1163b(i2, i3);
            float[] fArr = new float[i2 * 2];
            for (int i4 = 0; i4 < i3; i4++) {
                int length = fArr.length;
                float f2 = i4 + 0.5f;
                for (int i5 = 0; i5 < length; i5 += 2) {
                    fArr[i5] = (i5 / 2) + 0.5f;
                    fArr[i5 + 1] = f2;
                }
                c1172k.m2218a(fArr);
                AbstractC1170i.m2207a(c1163b, fArr);
                for (int i6 = 0; i6 < length; i6 += 2) {
                    try {
                        if (c1163b.m2173b((int) fArr[i6], (int) fArr[i6 + 1])) {
                            c1163b2.m2175c(i6 / 2, i4);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw C1102m.getNotFoundInstance();
                    }
                }
            }
            return c1163b2;
        }
        throw C1102m.getNotFoundInstance();
    }
}
