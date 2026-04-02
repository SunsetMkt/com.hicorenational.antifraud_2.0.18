package d.b.c.d0;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f9537d = 2.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f9538e = 1.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9542i = 3;
    private final StringBuilder a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f9544b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9545c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9539f = "0123456789-$:/.+ABCD";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final char[] f9540g = f9539f.toCharArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f9541h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f9543j = {'A', 'B', 'C', 'D'};

    private void b(int i2) {
        int[] iArr = this.f9544b;
        int i3 = this.f9545c;
        iArr[i3] = i2;
        this.f9545c = i3 + 1;
        int i4 = this.f9545c;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f9544b = iArr2;
        }
    }

    private int c(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f9545c) {
            return -1;
        }
        int[] iArr = this.f9544b;
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
            int[] iArr2 = f9541h;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m {
        Arrays.fill(this.f9544b, 0);
        a(aVar);
        int iA = a();
        this.a.setLength(0);
        int i3 = iA;
        do {
            int iC = c(i3);
            if (iC == -1) {
                throw d.b.c.m.getNotFoundInstance();
            }
            this.a.append((char) iC);
            i3 += 8;
            if (this.a.length() > 1 && a(f9543j, f9540g[iC])) {
                break;
            }
        } while (i3 < this.f9545c);
        int i4 = i3 - 1;
        int i5 = this.f9544b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f9544b[i3 + i7];
        }
        if (i3 < this.f9545c && i5 < i6 / 2) {
            throw d.b.c.m.getNotFoundInstance();
        }
        a(iA);
        for (int i8 = 0; i8 < this.a.length(); i8++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i8, f9540g[sb.charAt(i8)]);
        }
        if (!a(f9543j, this.a.charAt(0))) {
            throw d.b.c.m.getNotFoundInstance();
        }
        StringBuilder sb2 = this.a;
        if (!a(f9543j, sb2.charAt(sb2.length() - 1))) {
            throw d.b.c.m.getNotFoundInstance();
        }
        if (this.a.length() <= 3) {
            throw d.b.c.m.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(d.b.c.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iA; i10++) {
            i9 += this.f9544b[i10];
        }
        float f2 = i9;
        while (iA < i4) {
            i9 += this.f9544b[iA];
            iA++;
        }
        float f3 = i2;
        return new d.b.c.r(this.a.toString(), null, new d.b.c.t[]{new d.b.c.t(f2, f3), new d.b.c.t(i9, f3)}, d.b.c.a.CODABAR);
    }

    void a(int i2) throws d.b.c.m {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.a.length() - 1;
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            int i6 = f9541h[this.a.charAt(i5)];
            for (int i7 = 6; i7 >= 0; i7--) {
                int i8 = (i7 & 1) + ((i6 & 1) * 2);
                iArr[i8] = iArr[i8] + this.f9544b[i4 + i7];
                iArr2[i8] = iArr2[i8] + 1;
                i6 >>= 1;
            }
            if (i5 >= length) {
                break;
            }
            i4 += 8;
            i5++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i9 = 0; i9 < 2; i9++) {
            fArr2[i9] = 0.0f;
            int i10 = i9 + 2;
            fArr2[i10] = ((iArr[i9] / iArr2[i9]) + (iArr[i10] / iArr2[i10])) / 2.0f;
            fArr[i9] = fArr2[i10];
            fArr[i10] = ((iArr[i10] * 2.0f) + f9538e) / iArr2[i10];
        }
        loop3: while (true) {
            int i11 = f9541h[this.a.charAt(i3)];
            for (int i12 = 6; i12 >= 0; i12--) {
                int i13 = (i12 & 1) + ((i11 & 1) * 2);
                float f2 = this.f9544b[i2 + i12];
                if (f2 < fArr2[i13] || f2 > fArr[i13]) {
                    break loop3;
                }
                i11 >>= 1;
            }
            if (i3 >= length) {
                return;
            }
            i2 += 8;
            i3++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private void a(d.b.c.z.a aVar) throws d.b.c.m {
        int i2 = 0;
        this.f9545c = 0;
        int iD = aVar.d(0);
        int iC = aVar.c();
        if (iD < iC) {
            boolean z = true;
            while (iD < iC) {
                if (aVar.b(iD) ^ z) {
                    i2++;
                } else {
                    b(i2);
                    z = !z;
                    i2 = 1;
                }
                iD++;
            }
            b(i2);
            return;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private int a() throws d.b.c.m {
        for (int i2 = 1; i2 < this.f9545c; i2 += 2) {
            int iC = c(i2);
            if (iC != -1 && a(f9543j, f9540g[iC])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f9544b[i4];
                }
                if (i2 == 1 || this.f9544b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw d.b.c.m.getNotFoundInstance();
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
