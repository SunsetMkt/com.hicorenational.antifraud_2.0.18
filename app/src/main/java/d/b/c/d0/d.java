package d.b.c.d0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Code128Writer.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends r {
    private static final int a = 104;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9621b = 105;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9622c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9623d = 99;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9624e = 106;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f9625f = '\u00f1';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f9626g = '\u00f2';

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f9627h = '\u00f3';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f9628i = '\u00f4';

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9629j = 102;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9630k = 97;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9631l = 96;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9632m = 100;

    @Override // d.b.c.d0.r, d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<d.b.c.g, ?> map) throws d.b.c.w {
        if (aVar == d.b.c.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + aVar);
    }

    @Override // d.b.c.d0.r
    public boolean[] a(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int iA = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < ' ' || cCharAt > '~') {
                    switch (cCharAt) {
                        case '\u00f1':
                        case '\u00f2':
                        case '\u00f3':
                        case '\u00f4':
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + cCharAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int iCharAt = 100;
                int i7 = a(str, i3, i5 == 99 ? 2 : 4) ? 99 : 100;
                if (i7 == i5) {
                    switch (str.charAt(i3)) {
                        case '\u00f1':
                            iCharAt = 102;
                            break;
                        case '\u00f2':
                            iCharAt = 97;
                            break;
                        case '\u00f3':
                            iCharAt = 96;
                            break;
                        case '\u00f4':
                            break;
                        default:
                            if (i5 != 100) {
                                iCharAt = Integer.parseInt(str.substring(i3, i3 + 2));
                                i3++;
                            } else {
                                iCharAt = str.charAt(i3) - ' ';
                            }
                            break;
                    }
                    i3++;
                } else {
                    iCharAt = i5 == 0 ? i7 == 100 ? 104 : 105 : i7;
                    i5 = i7;
                }
                arrayList.add(c.a[iCharAt]);
                i4 += iCharAt * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            arrayList.add(c.a[i4 % 103]);
            arrayList.add(c.a[106]);
            int i8 = 0;
            for (int[] iArr : arrayList) {
                int i9 = i8;
                for (int i10 : iArr) {
                    i9 += i10;
                }
                i8 = i9;
            }
            boolean[] zArr = new boolean[i8];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iA += r.a(zArr, iA, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static boolean a(CharSequence charSequence, int i2, int i3) {
        int i4 = i3 + i2;
        int length = charSequence.length();
        while (i2 < i4 && i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt != '\u00f1') {
                    return false;
                }
                i4++;
            }
            i2++;
        }
        return i4 <= length;
    }
}
