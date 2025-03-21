package c.b.c.d0;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension5Support.java */
/* loaded from: classes.dex */
final class v {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2594c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2595a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f2596b = new StringBuilder();

    v() {
    }

    private static Map<c.b.c.s, Object> b(String str) {
        String a2;
        if (str.length() != 5 || (a2 = a(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(c.b.c.s.class);
        enumMap.put((EnumMap) c.b.c.s.SUGGESTED_PRICE, (c.b.c.s) a2);
        return enumMap;
    }

    c.b.c.r a(int i2, c.b.c.z.a aVar, int[] iArr) throws c.b.c.m {
        StringBuilder sb = this.f2596b;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<c.b.c.s, Object> b2 = b(sb2);
        float f2 = i2;
        c.b.c.r rVar = new c.b.c.r(sb2, null, new c.b.c.t[]{new c.b.c.t((iArr[0] + iArr[1]) / 2.0f, f2), new c.b.c.t(a2, f2)}, c.b.c.a.UPC_EAN_EXTENSION);
        if (b2 != null) {
            rVar.a(b2);
        }
        return rVar;
    }

    int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m {
        int[] iArr2 = this.f2595a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int c2 = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 5 && i2 < c2) {
            int a2 = x.a(aVar, iArr2, i2, x.f2605i);
            sb.append((char) ((a2 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (a2 >= 10) {
                i4 |= 1 << (4 - i3);
            }
            i2 = i3 != 4 ? aVar.d(aVar.c(i5)) : i5;
            i3++;
        }
        if (sb.length() == 5) {
            if (a((CharSequence) sb.toString()) == a(i4)) {
                return i2;
            }
            throw c.b.c.m.getNotFoundInstance();
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static int a(CharSequence charSequence) {
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

    private static int a(int i2) throws c.b.c.m {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f2594c[i3]) {
                return i3;
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private static String a(String str) {
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
