package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: EAN13Writer.java */
/* renamed from: c.b.c.d0.i */
/* loaded from: classes.dex */
public final class C1026i extends AbstractC1042y {

    /* renamed from: a */
    private static final int f1922a = 95;

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r, p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.EAN_13) {
            return super.mo1190a(str, enumC0953a, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + enumC0953a);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        if (str.length() == 13) {
            try {
                if (AbstractC1041x.m1529a((CharSequence) str)) {
                    int i2 = C1025h.f1920k[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int m1512a = AbstractC1035r.m1512a(zArr, 0, AbstractC1041x.f1952f, true) + 0;
                    int i3 = 1;
                    while (i3 <= 6) {
                        int i4 = i3 + 1;
                        int parseInt = Integer.parseInt(str.substring(i3, i4));
                        if (((i2 >> (6 - i3)) & 1) == 1) {
                            parseInt += 10;
                        }
                        m1512a += AbstractC1035r.m1512a(zArr, m1512a, AbstractC1041x.f1955i[parseInt], false);
                        i3 = i4;
                    }
                    int m1512a2 = m1512a + AbstractC1035r.m1512a(zArr, m1512a, AbstractC1041x.f1953g, false);
                    int i5 = 7;
                    while (i5 <= 12) {
                        int i6 = i5 + 1;
                        m1512a2 += AbstractC1035r.m1512a(zArr, m1512a2, AbstractC1041x.f1954h[Integer.parseInt(str.substring(i5, i6))], true);
                        i5 = i6;
                    }
                    AbstractC1035r.m1512a(zArr, m1512a2, AbstractC1041x.f1952f, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (C1097h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
