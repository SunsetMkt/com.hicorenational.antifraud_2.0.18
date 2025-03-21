package c.b.c.d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Code128Writer.java */
/* loaded from: classes.dex */
public final class d extends r {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2543a = 104;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2544b = 105;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2545c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2546d = 99;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2547e = 106;

    /* renamed from: f, reason: collision with root package name */
    private static final char f2548f = 241;

    /* renamed from: g, reason: collision with root package name */
    private static final char f2549g = 242;

    /* renamed from: h, reason: collision with root package name */
    private static final char f2550h = 243;

    /* renamed from: i, reason: collision with root package name */
    private static final char f2551i = 244;

    /* renamed from: j, reason: collision with root package name */
    private static final int f2552j = 102;

    /* renamed from: k, reason: collision with root package name */
    private static final int f2553k = 97;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2554l = 96;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2555m = 100;

    @Override // c.b.c.d0.r, c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + aVar);
    }

    @Override // c.b.c.d0.r
    public boolean[] a(String str) {
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
                int i9 = a(str, i4, i6 == 99 ? 2 : 4) ? 99 : 100;
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
                arrayList.add(c.f2530a[i8]);
                i5 += i8 * i7;
                if (i4 != 0) {
                    i7++;
                }
            }
            arrayList.add(c.f2530a[i5 % 103]);
            arrayList.add(c.f2530a[106]);
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
                i2 += r.a(zArr, i2, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static boolean a(CharSequence charSequence, int i2, int i3) {
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
