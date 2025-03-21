package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.InterfaceC1111v;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: OneDimensionalCodeWriter.java */
/* renamed from: c.b.c.d0.r */
/* loaded from: classes.dex */
public abstract class AbstractC1035r implements InterfaceC1111v {
    /* renamed from: a */
    public int mo1514a() {
        return 10;
    }

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public final C1163b mo1189a(String str, EnumC0953a enumC0953a, int i2, int i3) throws C1112w {
        return mo1190a(str, enumC0953a, i2, i3, null);
    }

    /* renamed from: a */
    public abstract boolean[] mo1480a(String str);

    @Override // p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        Integer num;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            int mo1514a = mo1514a();
            if (map != null && (num = (Integer) map.get(EnumC1096g.MARGIN)) != null) {
                mo1514a = num.intValue();
            }
            return m1513a(mo1480a(str), i2, i3, mo1514a);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }

    /* renamed from: a */
    private static C1163b m1513a(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int max = Math.max(i2, i5);
        int max2 = Math.max(1, i3);
        int i6 = max / i5;
        C1163b c1163b = new C1163b(max, max2);
        int i7 = (max - (length * i6)) / 2;
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                c1163b.m2170a(i7, 0, i6, max2);
            }
            i8++;
            i7 += i6;
        }
        return c1163b;
    }

    /* renamed from: a */
    protected static int m1512a(boolean[] zArr, int i2, int[] iArr, boolean z) {
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
