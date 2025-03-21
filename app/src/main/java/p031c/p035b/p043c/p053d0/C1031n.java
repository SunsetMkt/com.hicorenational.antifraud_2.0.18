package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: ITFWriter.java */
/* renamed from: c.b.c.d0.n */
/* loaded from: classes.dex */
public final class C1031n extends AbstractC1035r {

    /* renamed from: a */
    private static final int[] f1936a = {1, 1, 1, 1};

    /* renamed from: b */
    private static final int[] f1937b = {3, 1, 1};

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r, p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.ITF) {
            return super.mo1190a(str, enumC0953a, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + enumC0953a);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int m1512a = AbstractC1035r.m1512a(zArr, 0, f1936a, true);
            for (int i2 = 0; i2 < length; i2 += 2) {
                int digit = Character.digit(str.charAt(i2), 10);
                int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                int[] iArr = new int[18];
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = i3 * 2;
                    int[][] iArr2 = C1030m.f1934i;
                    iArr[i4] = iArr2[digit][i3];
                    iArr[i4 + 1] = iArr2[digit2][i3];
                }
                m1512a += AbstractC1035r.m1512a(zArr, m1512a, iArr, true);
            }
            AbstractC1035r.m1512a(zArr, m1512a, f1937b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
