package p031c.p035b.p043c.p053d0;

import java.util.EnumMap;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: UPCEANExtension2Support.java */
/* renamed from: c.b.c.d0.u */
/* loaded from: classes.dex */
final class C1038u {

    /* renamed from: a */
    private final int[] f1942a = new int[4];

    /* renamed from: b */
    private final StringBuilder f1943b = new StringBuilder();

    C1038u() {
    }

    /* renamed from: a */
    C1107r m1520a(int i2, C1162a c1162a, int[] iArr) throws C1102m {
        StringBuilder sb = this.f1943b;
        sb.setLength(0);
        int m1519a = m1519a(c1162a, iArr, sb);
        String sb2 = sb.toString();
        Map<EnumC1108s, Object> m1518a = m1518a(sb2);
        float f2 = i2;
        C1107r c1107r = new C1107r(sb2, null, new C1109t[]{new C1109t((iArr[0] + iArr[1]) / 2.0f, f2), new C1109t(m1519a, f2)}, EnumC0953a.UPC_EAN_EXTENSION);
        if (m1518a != null) {
            c1107r.m1912a(m1518a);
        }
        return c1107r;
    }

    /* renamed from: a */
    int m1519a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        int[] iArr2 = this.f1942a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m2157c = c1162a.m2157c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2 && i2 < m2157c) {
            int m1528a = AbstractC1041x.m1528a(c1162a, iArr2, i2, AbstractC1041x.f1955i);
            sb.append((char) ((m1528a % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (m1528a >= 10) {
                i4 = (1 << (1 - i3)) | i4;
            }
            i2 = i3 != 1 ? c1162a.m2161d(c1162a.m2158c(i5)) : i5;
            i3++;
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i4) {
                return i2;
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static Map<EnumC1108s, Object> m1518a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC1108s.class);
        enumMap.put((EnumMap) EnumC1108s.ISSUE_NUMBER, (EnumC1108s) Integer.valueOf(str));
        return enumMap;
    }
}
