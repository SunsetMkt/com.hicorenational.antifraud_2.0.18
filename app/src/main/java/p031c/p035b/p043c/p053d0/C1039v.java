package p031c.p035b.p043c.p053d0;

import java.util.EnumMap;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: UPCEANExtension5Support.java */
/* renamed from: c.b.c.d0.v */
/* loaded from: classes.dex */
final class C1039v {

    /* renamed from: c */
    private static final int[] f1944c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a */
    private final int[] f1945a = new int[4];

    /* renamed from: b */
    private final StringBuilder f1946b = new StringBuilder();

    C1039v() {
    }

    /* renamed from: b */
    private static Map<EnumC1108s, Object> m1524b(String str) {
        String m1523a;
        if (str.length() != 5 || (m1523a = m1523a(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC1108s.class);
        enumMap.put((EnumMap) EnumC1108s.SUGGESTED_PRICE, (EnumC1108s) m1523a);
        return enumMap;
    }

    /* renamed from: a */
    C1107r m1526a(int i2, C1162a c1162a, int[] iArr) throws C1102m {
        StringBuilder sb = this.f1946b;
        sb.setLength(0);
        int m1525a = m1525a(c1162a, iArr, sb);
        String sb2 = sb.toString();
        Map<EnumC1108s, Object> m1524b = m1524b(sb2);
        float f2 = i2;
        C1107r c1107r = new C1107r(sb2, null, new C1109t[]{new C1109t((iArr[0] + iArr[1]) / 2.0f, f2), new C1109t(m1525a, f2)}, EnumC0953a.UPC_EAN_EXTENSION);
        if (m1524b != null) {
            c1107r.m1912a(m1524b);
        }
        return c1107r;
    }

    /* renamed from: a */
    int m1525a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        int[] iArr2 = this.f1945a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m2157c = c1162a.m2157c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5 && i2 < m2157c) {
            int m1528a = AbstractC1041x.m1528a(c1162a, iArr2, i2, AbstractC1041x.f1955i);
            sb.append((char) ((m1528a % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (m1528a >= 10) {
                i4 |= 1 << (4 - i3);
            }
            i2 = i3 != 4 ? c1162a.m2161d(c1162a.m2158c(i5)) : i5;
            i3++;
        }
        if (sb.length() == 5) {
            if (m1522a((CharSequence) sb.toString()) == m1521a(i4)) {
                return i2;
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1522a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            i2 += charSequence.charAt(i3) - '0';
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        return (i4 * 3) % 10;
    }

    /* renamed from: a */
    private static int m1521a(int i2) throws C1102m {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f1944c[i3]) {
                return i3;
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static String m1523a(String str) {
        String valueOf;
        char charAt = str.charAt(0);
        String str2 = "";
        if (charAt == '0') {
            str2 = "£";
        } else if (charAt == '5') {
            str2 = "$";
        } else if (charAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i2 = parseInt % 100;
        if (i2 < 10) {
            valueOf = "0" + i2;
        } else {
            valueOf = String.valueOf(i2);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }
}
