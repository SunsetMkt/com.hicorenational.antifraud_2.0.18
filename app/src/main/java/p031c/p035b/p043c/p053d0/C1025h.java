package p031c.p035b.p043c.p053d0;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: EAN13Reader.java */
/* renamed from: c.b.c.d0.h */
/* loaded from: classes.dex */
public final class C1025h extends AbstractC1041x {

    /* renamed from: k */
    static final int[] f1920k = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: j */
    private final int[] f1921j = new int[4];

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected int mo1496a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        int[] iArr2 = this.f1921j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m2157c = c1162a.m2157c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < m2157c) {
            int m1528a = AbstractC1041x.m1528a(c1162a, iArr2, i2, AbstractC1041x.f1955i);
            sb.append((char) ((m1528a % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (m1528a >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        m1495a(sb, i4);
        int i7 = AbstractC1041x.m1531a(c1162a, i2, true, AbstractC1041x.f1953g)[1];
        int i8 = 0;
        while (i8 < 6 && i7 < m2157c) {
            sb.append((char) (AbstractC1041x.m1528a(c1162a, iArr2, i7, AbstractC1041x.f1954h) + 48));
            int i9 = i7;
            for (int i10 : iArr2) {
                i9 += i10;
            }
            i8++;
            i7 = i9;
        }
        return i7;
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    EnumC0953a mo1497a() {
        return EnumC0953a.EAN_13;
    }

    /* renamed from: a */
    private static void m1495a(StringBuilder sb, int i2) throws C1102m {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f1920k[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw C1102m.getNotFoundInstance();
    }
}
