package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: EAN8Writer.java */
/* renamed from: c.b.c.d0.k */
/* loaded from: classes.dex */
public final class C1028k extends AbstractC1042y {

    /* renamed from: a */
    private static final int f1924a = 67;

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r, p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.EAN_8) {
            return super.mo1190a(str, enumC0953a, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + enumC0953a);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int m1512a = AbstractC1035r.m1512a(zArr, 0, AbstractC1041x.f1952f, true) + 0;
            int i2 = 0;
            while (i2 <= 3) {
                int i3 = i2 + 1;
                m1512a += AbstractC1035r.m1512a(zArr, m1512a, AbstractC1041x.f1954h[Integer.parseInt(str.substring(i2, i3))], false);
                i2 = i3;
            }
            int m1512a2 = m1512a + AbstractC1035r.m1512a(zArr, m1512a, AbstractC1041x.f1953g, false);
            int i4 = 4;
            while (i4 <= 7) {
                int i5 = i4 + 1;
                m1512a2 += AbstractC1035r.m1512a(zArr, m1512a2, AbstractC1041x.f1954h[Integer.parseInt(str.substring(i4, i5))], true);
                i4 = i5;
            }
            AbstractC1035r.m1512a(zArr, m1512a2, AbstractC1041x.f1952f, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
