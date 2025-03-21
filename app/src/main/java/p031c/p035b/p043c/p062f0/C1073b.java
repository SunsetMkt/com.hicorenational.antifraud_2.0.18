package p031c.p035b.p043c.p062f0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p062f0.p065e.C1091b;
import p031c.p035b.p043c.p062f0.p065e.C1092c;
import p031c.p035b.p043c.p062f0.p065e.C1095f;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: QRCodeWriter.java */
/* renamed from: c.b.c.f0.b */
/* loaded from: classes.dex */
public final class C1073b implements InterfaceC1111v {

    /* renamed from: a */
    private static final int f2112a = 4;

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) throws C1112w {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (enumC0953a != EnumC0953a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + enumC0953a);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        EnumC1079f enumC1079f = EnumC1079f.L;
        int i4 = 4;
        if (map != null) {
            EnumC1079f enumC1079f2 = (EnumC1079f) map.get(EnumC1096g.ERROR_CORRECTION);
            if (enumC1079f2 != null) {
                enumC1079f = enumC1079f2;
            }
            Integer num = (Integer) map.get(EnumC1096g.MARGIN);
            if (num != null) {
                i4 = num.intValue();
            }
        }
        return m1733a(C1092c.m1841a(str, enumC1079f, map), i2, i3, i4);
    }

    /* renamed from: a */
    private static C1163b m1733a(C1095f c1095f, int i2, int i3, int i4) {
        C1091b m1890c = c1095f.m1890c();
        if (m1890c != null) {
            int m1833c = m1890c.m1833c();
            int m1832b = m1890c.m1832b();
            int i5 = i4 * 2;
            int i6 = m1833c + i5;
            int i7 = i5 + m1832b;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (m1833c * min)) / 2;
            int i9 = (max2 - (m1832b * min)) / 2;
            C1163b c1163b = new C1163b(max, max2);
            int i10 = 0;
            while (i10 < m1832b) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < m1833c) {
                    if (m1890c.m1826a(i12, i10) == 1) {
                        c1163b.m2170a(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return c1163b;
        }
        throw new IllegalStateException();
    }
}
