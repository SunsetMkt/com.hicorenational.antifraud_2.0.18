package p031c.p035b.p043c.p066x;

import java.nio.charset.Charset;
import java.util.Map;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p066x.p069f.C1118a;
import p031c.p035b.p043c.p066x.p069f.C1120c;
import p031c.p035b.p043c.p072z.C1163b;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: AztecWriter.java */
/* renamed from: c.b.c.x.c */
/* loaded from: classes.dex */
public final class C1115c implements InterfaceC1111v {

    /* renamed from: a */
    private static final Charset f2228a = Charset.forName(C5758c.f20750a);

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) {
        String str2 = map == null ? null : (String) map.get(EnumC1096g.CHARACTER_SET);
        Number number = map == null ? null : (Number) map.get(EnumC1096g.ERROR_CORRECTION);
        Number number2 = map != null ? (Number) map.get(EnumC1096g.AZTEC_LAYERS) : null;
        return m1929a(str, enumC0953a, i2, i3, str2 == null ? f2228a : Charset.forName(str2), number == null ? 33 : number.intValue(), number2 == null ? 0 : number2.intValue());
    }

    /* renamed from: a */
    private static C1163b m1929a(String str, EnumC0953a enumC0953a, int i2, int i3, Charset charset, int i4, int i5) {
        if (enumC0953a == EnumC0953a.AZTEC) {
            return m1928a(C1120c.m1974a(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + enumC0953a);
    }

    /* renamed from: a */
    private static C1163b m1928a(C1118a c1118a, int i2, int i3) {
        C1163b m1967c = c1118a.m1967c();
        if (m1967c != null) {
            int m2181g = m1967c.m2181g();
            int m2177d = m1967c.m2177d();
            int max = Math.max(i2, m2181g);
            int max2 = Math.max(i3, m2177d);
            int min = Math.min(max / m2181g, max2 / m2177d);
            int i4 = (max - (m2181g * min)) / 2;
            int i5 = (max2 - (m2177d * min)) / 2;
            C1163b c1163b = new C1163b(max, max2);
            int i6 = 0;
            while (i6 < m2177d) {
                int i7 = i4;
                int i8 = 0;
                while (i8 < m2181g) {
                    if (m1967c.m2173b(i8, i6)) {
                        c1163b.m2170a(i7, i5, min, min);
                    }
                    i8++;
                    i7 += min;
                }
                i6++;
                i5 += min;
            }
            return c1163b;
        }
        throw new IllegalStateException();
    }
}
