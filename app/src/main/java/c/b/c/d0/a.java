package c.b.c.d0;

import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* loaded from: classes.dex */
public final class a extends q {

    /* renamed from: d, reason: collision with root package name */
    private static final float f2447d = 2.0f;

    /* renamed from: e, reason: collision with root package name */
    private static final float f2448e = 1.5f;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2452i = 3;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f2454a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f2455b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f2456c = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2449f = "0123456789-$:/.+ABCD";

    /* renamed from: g, reason: collision with root package name */
    static final char[] f2450g = f2449f.toCharArray();

    /* renamed from: h, reason: collision with root package name */
    static final int[] f2451h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f2453j = {'A', 'B', 'C', 'D'};

    private void b(int i2) {
        int[] iArr = this.f2455b;
        int i3 = this.f2456c;
        iArr[i3] = i2;
        this.f2456c = i3 + 1;
        int i4 = this.f2456c;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f2455b = iArr2;
        }
    }

    private int c(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f2456c) {
            return -1;
        }
        int[] iArr = this.f2455b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f2451h;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m {
        Arrays.fill(this.f2455b, 0);
        a(aVar);
        int a2 = a();
        this.f2454a.setLength(0);
        int i3 = a2;
        do {
            int c2 = c(i3);
            if (c2 == -1) {
                throw c.b.c.m.getNotFoundInstance();
            }
            this.f2454a.append((char) c2);
            i3 += 8;
            if (this.f2454a.length() > 1 && a(f2453j, f2450g[c2])) {
                break;
            }
        } while (i3 < this.f2456c);
        int i4 = i3 - 1;
        int i5 = this.f2455b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f2455b[i3 + i7];
        }
        if (i3 < this.f2456c && i5 < i6 / 2) {
            throw c.b.c.m.getNotFoundInstance();
        }
        a(a2);
        for (int i8 = 0; i8 < this.f2454a.length(); i8++) {
            StringBuilder sb = this.f2454a;
            sb.setCharAt(i8, f2450g[sb.charAt(i8)]);
        }
        if (!a(f2453j, this.f2454a.charAt(0))) {
            throw c.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f2454a;
        if (!a(f2453j, sb2.charAt(sb2.length() - 1))) {
            throw c.b.c.m.getNotFoundInstance();
        }
        if (this.f2454a.length() <= 3) {
            throw c.b.c.m.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(c.b.c.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f2454a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f2454a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < a2; i10++) {
            i9 += this.f2455b[i10];
        }
        float f2 = i9;
        while (a2 < i4) {
            i9 += this.f2455b[a2];
            a2++;
        }
        float f3 = i2;
        return new c.b.c.r(this.f2454a.toString(), null, new c.b.c.t[]{new c.b.c.t(f2, f3), new c.b.c.t(i9, f3)}, c.b.c.a.CODABAR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
    
        throw c.b.c.m.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r15) throws c.b.c.m {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.a.a(int):void");
    }

    private void a(c.b.c.z.a aVar) throws c.b.c.m {
        int i2 = 0;
        this.f2456c = 0;
        int d2 = aVar.d(0);
        int c2 = aVar.c();
        if (d2 < c2) {
            boolean z = true;
            while (d2 < c2) {
                if (aVar.b(d2) ^ z) {
                    i2++;
                } else {
                    b(i2);
                    z = !z;
                    i2 = 1;
                }
                d2++;
            }
            b(i2);
            return;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    private int a() throws c.b.c.m {
        for (int i2 = 1; i2 < this.f2456c; i2 += 2) {
            int c2 = c(i2);
            if (c2 != -1 && a(f2453j, f2450g[c2])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f2455b[i4];
                }
                if (i2 == 1 || this.f2455b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
