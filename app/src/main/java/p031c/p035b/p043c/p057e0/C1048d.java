package p031c.p035b.p043c.p057e0;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p057e0.p061g.C1067d;
import p031c.p035b.p043c.p057e0.p061g.C1068e;
import p031c.p035b.p043c.p057e0.p061g.EnumC1066c;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: PDF417Writer.java */
/* renamed from: c.b.c.e0.d */
/* loaded from: classes.dex */
public final class C1048d implements InterfaceC1111v {

    /* renamed from: a */
    static final int f1977a = 30;

    /* renamed from: b */
    static final int f1978b = 2;

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        int i4;
        int i5;
        if (enumC0953a != EnumC0953a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + enumC0953a);
        }
        C1068e c1068e = new C1068e();
        if (map != null) {
            if (map.containsKey(EnumC1096g.PDF417_COMPACT)) {
                c1068e.m1710a(((Boolean) map.get(EnumC1096g.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(EnumC1096g.PDF417_COMPACTION)) {
                c1068e.m1707a((EnumC1066c) map.get(EnumC1096g.PDF417_COMPACTION));
            }
            if (map.containsKey(EnumC1096g.PDF417_DIMENSIONS)) {
                C1067d c1067d = (C1067d) map.get(EnumC1096g.PDF417_DIMENSIONS);
                c1068e.m1706a(c1067d.m1696a(), c1067d.m1698c(), c1067d.m1697b(), c1067d.m1699d());
            }
            int intValue = map.containsKey(EnumC1096g.MARGIN) ? ((Number) map.get(EnumC1096g.MARGIN)).intValue() : 30;
            int intValue2 = map.containsKey(EnumC1096g.ERROR_CORRECTION) ? ((Number) map.get(EnumC1096g.ERROR_CORRECTION)).intValue() : 2;
            if (map.containsKey(EnumC1096g.CHARACTER_SET)) {
                c1068e.m1709a(Charset.forName((String) map.get(EnumC1096g.CHARACTER_SET)));
            }
            i5 = intValue;
            i4 = intValue2;
        } else {
            i4 = 2;
            i5 = 30;
        }
        return m1553a(c1068e, str, i4, i2, i3, i5);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) throws C1112w {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    /* renamed from: a */
    private static C1163b m1553a(C1068e c1068e, String str, int i2, int i3, int i4, int i5) throws C1112w {
        boolean z;
        c1068e.m1708a(str, i2);
        byte[][] m1689a = c1068e.m1705a().m1689a(1, 4);
        if ((i4 > i3) ^ (m1689a[0].length < m1689a.length)) {
            m1689a = m1555a(m1689a);
            z = true;
        } else {
            z = false;
        }
        int length = i3 / m1689a[0].length;
        int length2 = i4 / m1689a.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] m1689a2 = c1068e.m1705a().m1689a(length, length * 4);
            if (z) {
                m1689a2 = m1555a(m1689a2);
            }
            return m1554a(m1689a2, i5);
        }
        return m1554a(m1689a, i5);
    }

    /* renamed from: a */
    private static C1163b m1554a(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        C1163b c1163b = new C1163b(bArr[0].length + i3, bArr.length + i3);
        c1163b.m2168a();
        int m2177d = (c1163b.m2177d() - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr[i4][i5] == 1) {
                    c1163b.m2175c(i5 + i2, m2177d);
                }
            }
            i4++;
            m2177d--;
        }
        return c1163b;
    }

    /* renamed from: a */
    private static byte[][] m1555a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }
}
