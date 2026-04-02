package d.b.c.d0;

import java.util.Map;

/* JADX INFO: compiled from: OneDimensionalCodeWriter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class r implements d.b.c.v {
    public int a() {
        return 10;
    }

    @Override // d.b.c.v
    public final d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3) throws d.b.c.w {
        return a(str, aVar, i2, i3, null);
    }

    public abstract boolean[] a(String str);

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<d.b.c.g, ?> map) throws d.b.c.w {
        Integer num;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            int iA = a();
            if (map != null && (num = (Integer) map.get(d.b.c.g.MARGIN)) != null) {
                iA = num.intValue();
            }
            return a(a(str), i2, i3, iA);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }

    private static d.b.c.z.b a(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int iMax = Math.max(i2, i5);
        int iMax2 = Math.max(1, i3);
        int i6 = iMax / i5;
        d.b.c.z.b bVar = new d.b.c.z.b(iMax, iMax2);
        int i7 = (iMax - (length * i6)) / 2;
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.a(i7, 0, i6, iMax2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int length = iArr.length;
        int i3 = i2;
        boolean z2 = z;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = iArr[i4];
            int i7 = i3;
            int i8 = 0;
            while (i8 < i6) {
                zArr[i7] = z2;
                i8++;
                i7++;
            }
            i5 += i6;
            z2 = !z2;
            i4++;
            i3 = i7;
        }
        return i5;
    }
}
