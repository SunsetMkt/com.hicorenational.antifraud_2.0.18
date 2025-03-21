package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: Code39Writer.java */
/* renamed from: c.b.c.d0.f */
/* loaded from: classes.dex */
public final class C1023f extends AbstractC1035r {
    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r, p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.CODE_39) {
            return super.mo1190a(str, enumC0953a, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + enumC0953a);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i2 = length + 25;
            int i3 = 0;
            while (i3 < length) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i3));
                if (indexOf >= 0) {
                    m1488a(C1022e.f1908g[indexOf], iArr);
                    int i4 = i2;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    i3++;
                    i2 = i4;
                } else {
                    throw new IllegalArgumentException("Bad contents: " + str);
                }
            }
            boolean[] zArr = new boolean[i2];
            m1488a(C1022e.f1908g[39], iArr);
            int m1512a = AbstractC1035r.m1512a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int m1512a2 = m1512a + AbstractC1035r.m1512a(zArr, m1512a, iArr2, false);
            for (int i6 = 0; i6 < length; i6++) {
                m1488a(C1022e.f1908g["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i6))], iArr);
                int m1512a3 = m1512a2 + AbstractC1035r.m1512a(zArr, m1512a2, iArr, true);
                m1512a2 = m1512a3 + AbstractC1035r.m1512a(zArr, m1512a3, iArr2, false);
            }
            m1488a(C1022e.f1908g[39], iArr);
            AbstractC1035r.m1512a(zArr, m1512a2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    /* renamed from: a */
    private static void m1488a(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) != 0) {
                i4 = 2;
            }
            iArr[i3] = i4;
        }
    }
}
