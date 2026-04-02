package d.b.c.d0;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANExtension2Support.java */
/* JADX INFO: loaded from: classes.dex */
final class u {
    private final int[] a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f9659b = new StringBuilder();

    u() {
    }

    d.b.c.r a(int i2, d.b.c.z.a aVar, int[] iArr) throws d.b.c.m {
        StringBuilder sb = this.f9659b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map<d.b.c.s, Object> mapA = a(string);
        float f2 = i2;
        d.b.c.r rVar = new d.b.c.r(string, null, new d.b.c.t[]{new d.b.c.t((iArr[0] + iArr[1]) / 2.0f, f2), new d.b.c.t(iA, f2)}, d.b.c.a.UPC_EAN_EXTENSION);
        if (mapA != null) {
            rVar.a(mapA);
        }
        return rVar;
    }

    int a(d.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws d.b.c.m {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int iD = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2 && iD < iC) {
            int iA = x.a(aVar, iArr2, iD, x.f9669i);
            sb.append((char) ((iA % 10) + 48));
            int i4 = iD;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iA >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            iD = i2 != 1 ? aVar.d(aVar.c(i4)) : i4;
            i2++;
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i3) {
                return iD;
            }
            throw d.b.c.m.getNotFoundInstance();
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private static Map<d.b.c.s, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(d.b.c.s.class);
        enumMap.put(d.b.c.s.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
