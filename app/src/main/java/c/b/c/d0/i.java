package c.b.c.d0;

import java.util.Map;

/* compiled from: EAN13Writer.java */
/* loaded from: classes.dex */
public final class i extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2572a = 95;

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.EAN_13) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
        if (str.length() == 13) {
            try {
                if (x.a((CharSequence) str)) {
                    int i2 = h.f2570k[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int a2 = r.a(zArr, 0, x.f2602f, true) + 0;
                    int i3 = 1;
                    while (i3 <= 6) {
                        int i4 = i3 + 1;
                        int parseInt = Integer.parseInt(str.substring(i3, i4));
                        if (((i2 >> (6 - i3)) & 1) == 1) {
                            parseInt += 10;
                        }
                        a2 += r.a(zArr, a2, x.f2605i[parseInt], false);
                        i3 = i4;
                    }
                    int a3 = a2 + r.a(zArr, a2, x.f2603g, false);
                    int i5 = 7;
                    while (i5 <= 12) {
                        int i6 = i5 + 1;
                        a3 += r.a(zArr, a3, x.f2604h[Integer.parseInt(str.substring(i5, i6))], true);
                        i5 = i6;
                    }
                    r.a(zArr, a3, x.f2602f, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (c.b.c.h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
