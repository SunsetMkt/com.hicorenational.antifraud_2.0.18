package c.b.c.d0;

import java.util.Map;

/* compiled from: EAN8Writer.java */
/* loaded from: classes.dex */
public final class k extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2574a = 67;

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.EAN_8) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[67];
            int a2 = r.a(zArr, 0, x.f2602f, true) + 0;
            int i2 = 0;
            while (i2 <= 3) {
                int i3 = i2 + 1;
                a2 += r.a(zArr, a2, x.f2604h[Integer.parseInt(str.substring(i2, i3))], false);
                i2 = i3;
            }
            int a3 = a2 + r.a(zArr, a2, x.f2603g, false);
            int i4 = 4;
            while (i4 <= 7) {
                int i5 = i4 + 1;
                a3 += r.a(zArr, a3, x.f2604h[Integer.parseInt(str.substring(i4, i5))], true);
                i4 = i5;
            }
            r.a(zArr, a3, x.f2602f, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
