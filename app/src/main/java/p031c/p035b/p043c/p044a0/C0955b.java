package p031c.p035b.p043c.p044a0;

import java.util.Map;
import p031c.p035b.p043c.C1071f;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p044a0.p047e.C0966e;
import p031c.p035b.p043c.p044a0.p047e.C0970i;
import p031c.p035b.p043c.p044a0.p047e.C0971j;
import p031c.p035b.p043c.p044a0.p047e.C0972k;
import p031c.p035b.p043c.p044a0.p047e.EnumC0973l;
import p031c.p035b.p043c.p062f0.p065e.C1091b;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: DataMatrixWriter.java */
/* renamed from: c.b.c.a0.b */
/* loaded from: classes.dex */
public final class C0955b implements InterfaceC1111v {
    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) {
        C1071f c1071f;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (enumC0953a != EnumC0953a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + enumC0953a);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        EnumC0973l enumC0973l = EnumC0973l.FORCE_NONE;
        C1071f c1071f2 = null;
        if (map != null) {
            EnumC0973l enumC0973l2 = (EnumC0973l) map.get(EnumC1096g.DATA_MATRIX_SHAPE);
            if (enumC0973l2 != null) {
                enumC0973l = enumC0973l2;
            }
            c1071f = (C1071f) map.get(EnumC1096g.MIN_SIZE);
            if (c1071f == null) {
                c1071f = null;
            }
            C1071f c1071f3 = (C1071f) map.get(EnumC1096g.MAX_SIZE);
            if (c1071f3 != null) {
                c1071f2 = c1071f3;
            }
        } else {
            c1071f = null;
        }
        String m1296a = C0971j.m1296a(str, enumC0973l, c1071f, c1071f2);
        C0972k m1307a = C0972k.m1307a(m1296a.length(), enumC0973l, c1071f, c1071f2, true);
        C0966e c0966e = new C0966e(C0970i.m1289a(m1296a, m1307a), m1307a.m1318g(), m1307a.m1317f());
        c0966e.m1263d();
        return m1187a(c0966e, m1307a);
    }

    /* renamed from: a */
    private static C1163b m1187a(C0966e c0966e, C0972k c0972k) {
        int m1318g = c0972k.m1318g();
        int m1317f = c0972k.m1317f();
        C1091b c1091b = new C1091b(c0972k.m1320i(), c0972k.m1319h());
        int i2 = 0;
        for (int i3 = 0; i3 < m1317f; i3++) {
            if (i3 % c0972k.f1724e == 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < c0972k.m1320i(); i5++) {
                    c1091b.m1830a(i4, i2, i5 % 2 == 0);
                    i4++;
                }
                i2++;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < m1318g; i7++) {
                if (i7 % c0972k.f1723d == 0) {
                    c1091b.m1830a(i6, i2, true);
                    i6++;
                }
                c1091b.m1830a(i6, i2, c0966e.m1258a(i7, i3));
                i6++;
                int i8 = c0972k.f1723d;
                if (i7 % i8 == i8 - 1) {
                    c1091b.m1830a(i6, i2, i3 % 2 == 0);
                    i6++;
                }
            }
            i2++;
            int i9 = c0972k.f1724e;
            if (i3 % i9 == i9 - 1) {
                int i10 = 0;
                for (int i11 = 0; i11 < c0972k.m1320i(); i11++) {
                    c1091b.m1830a(i10, i2, true);
                    i10++;
                }
                i2++;
            }
        }
        return m1188a(c1091b);
    }

    /* renamed from: a */
    private static C1163b m1188a(C1091b c1091b) {
        int m1833c = c1091b.m1833c();
        int m1832b = c1091b.m1832b();
        C1163b c1163b = new C1163b(m1833c, m1832b);
        c1163b.m2168a();
        for (int i2 = 0; i2 < m1833c; i2++) {
            for (int i3 = 0; i3 < m1832b; i3++) {
                if (c1091b.m1826a(i2, i3) == 1) {
                    c1163b.m2175c(i2, i3);
                }
            }
        }
        return c1163b;
    }
}
