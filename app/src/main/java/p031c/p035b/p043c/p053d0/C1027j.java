package p031c.p035b.p043c.p053d0;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: EAN8Reader.java */
/* renamed from: c.b.c.d0.j */
/* loaded from: classes.dex */
public final class C1027j extends AbstractC1041x {

    /* renamed from: j */
    private final int[] f1923j = new int[4];

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected int mo1496a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        int[] iArr2 = this.f1923j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m2157c = c1162a.m2157c();
        int i2 = iArr[1];
        int i3 = 0;
        while (i3 < 4 && i2 < m2157c) {
            sb.append((char) (AbstractC1041x.m1528a(c1162a, iArr2, i2, AbstractC1041x.f1954h) + 48));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = AbstractC1041x.m1531a(c1162a, i2, true, AbstractC1041x.f1953g)[1];
        int i7 = 0;
        while (i7 < 4 && i6 < m2157c) {
            sb.append((char) (AbstractC1041x.m1528a(c1162a, iArr2, i6, AbstractC1041x.f1954h) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    EnumC0953a mo1497a() {
        return EnumC0953a.EAN_8;
    }
}
