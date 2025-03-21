package p031c.p035b.p043c.p053d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: Code128Writer.java */
/* renamed from: c.b.c.d0.d */
/* loaded from: classes.dex */
public final class C1021d extends AbstractC1035r {

    /* renamed from: a */
    private static final int f1893a = 104;

    /* renamed from: b */
    private static final int f1894b = 105;

    /* renamed from: c */
    private static final int f1895c = 100;

    /* renamed from: d */
    private static final int f1896d = 99;

    /* renamed from: e */
    private static final int f1897e = 106;

    /* renamed from: f */
    private static final char f1898f = 241;

    /* renamed from: g */
    private static final char f1899g = 242;

    /* renamed from: h */
    private static final char f1900h = 243;

    /* renamed from: i */
    private static final char f1901i = 244;

    /* renamed from: j */
    private static final int f1902j = 102;

    /* renamed from: k */
    private static final int f1903k = 97;

    /* renamed from: l */
    private static final int f1904l = 96;

    /* renamed from: m */
    private static final int f1905m = 100;

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r, p031c.p035b.p043c.InterfaceC1111v
    /* renamed from: a */
    public C1163b mo1190a(String str, EnumC0953a enumC0953a, int i2, int i3, Map<EnumC1096g, ?> map) throws C1112w {
        if (enumC0953a == EnumC0953a.CODE_128) {
            return super.mo1190a(str, enumC0953a, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + enumC0953a);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (i4 < length) {
                int i8 = 100;
                int i9 = m1483a(str, i4, i6 == 99 ? 2 : 4) ? 99 : 100;
                if (i9 == i6) {
                    switch (str.charAt(i4)) {
                        case 241:
                            i8 = 102;
                            break;
                        case 242:
                            i8 = 97;
                            break;
                        case 243:
                            i8 = 96;
                            break;
                        case 244:
                            break;
                        default:
                            if (i6 != 100) {
                                i8 = Integer.parseInt(str.substring(i4, i4 + 2));
                                i4++;
                                break;
                            } else {
                                i8 = str.charAt(i4) - ' ';
                                break;
                            }
                    }
                    i4++;
                } else {
                    i8 = i6 == 0 ? i9 == 100 ? 104 : 105 : i9;
                    i6 = i9;
                }
                arrayList.add(C1020c.f1877a[i8]);
                i5 += i8 * i7;
                if (i4 != 0) {
                    i7++;
                }
            }
            arrayList.add(C1020c.f1877a[i5 % 103]);
            arrayList.add(C1020c.f1877a[106]);
            int i10 = 0;
            for (int[] iArr : arrayList) {
                int i11 = i10;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                i10 = i11;
            }
            boolean[] zArr = new boolean[i10];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i2 += AbstractC1035r.m1512a(zArr, i2, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    /* renamed from: a */
    private static boolean m1483a(CharSequence charSequence, int i2, int i3) {
        int i4 = i3 + i2;
        int length = charSequence.length();
        while (i2 < i4 && i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                if (charAt != 241) {
                    return false;
                }
                i4++;
            }
            i2++;
        }
        return i4 <= length;
    }
}
