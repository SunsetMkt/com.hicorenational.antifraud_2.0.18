package d.b.c.d0;

import com.luck.picture.lib.camera.CustomCameraView;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f9633e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f9634f = f9633e.toCharArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f9635g = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, CustomCameraView.BUTTON_STATE_BOTH, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 133, 388, 196, 148, 168, 162, 138, 42};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9636h = f9635g[39];
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f9638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f9639d;

    public e() {
        this(false);
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        int[] iArr = this.f9639d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f9638c;
        sb.setLength(0);
        int iC = aVar.c(a(aVar, iArr)[1]);
        int iC2 = aVar.c();
        while (true) {
            q.a(aVar, iC, iArr);
            int iA = a(iArr);
            if (iA < 0) {
                throw d.b.c.m.getNotFoundInstance();
            }
            char cA = a(iA);
            sb.append(cA);
            int i3 = iC;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int iC3 = aVar.c(i3);
            if (cA == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (iC3 - iC) - i5;
                if (iC3 != iC2 && i7 * 2 < i5) {
                    throw d.b.c.m.getNotFoundInstance();
                }
                if (this.a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iIndexOf += f9633e.indexOf(this.f9638c.charAt(i8));
                    }
                    if (sb.charAt(length) != f9634f[iIndexOf % 43]) {
                        throw d.b.c.d.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw d.b.c.m.getNotFoundInstance();
                }
                float f2 = i2;
                return new d.b.c.r(this.f9637b ? a(sb) : sb.toString(), null, new d.b.c.t[]{new d.b.c.t((r2[1] + r2[0]) / 2.0f, f2), new d.b.c.t(iC + (i5 / 2.0f), f2)}, d.b.c.a.CODE_39);
            }
            iC = iC3;
        }
    }

    public e(boolean z) {
        this(z, false);
    }

    public e(boolean z, boolean z2) {
        this.a = z;
        this.f9637b = z2;
        this.f9638c = new StringBuilder(20);
        this.f9639d = new int[9];
    }

    private static int[] a(d.b.c.z.a aVar, int[] iArr) throws d.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        int length = iArr.length;
        int i2 = iC2;
        boolean z = false;
        int i3 = 0;
        while (iC2 < iC) {
            if (aVar.b(iC2) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (a(iArr) == f9636h && aVar.a(Math.max(0, i2 - ((iC2 - i2) / 2)), i2, false)) {
                        return new int[]{i2, iC2};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            iC2++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if (i11 * 2 >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    private static char a(int i2) throws d.b.c.m {
        int i3 = 0;
        while (true) {
            int[] iArr = f9635g;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f9634f[i3];
                }
                i3++;
            } else {
                throw d.b.c.m.getNotFoundInstance();
            }
        }
    }

    private static String a(CharSequence charSequence) throws d.b.c.h {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '+' && cCharAt != '$' && cCharAt != '%' && cCharAt != '/') {
                sb.append(cCharAt);
            } else {
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c2 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i2 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw d.b.c.h.getFormatInstance();
                                }
                                c2 = ':';
                            }
                            sb.append(c2);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw d.b.c.h.getFormatInstance();
                            }
                            i2 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i2 = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw d.b.c.h.getFormatInstance();
                        }
                        i2 = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw d.b.c.h.getFormatInstance();
                    }
                    i2 = cCharAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            }
            i3++;
        }
        return sb.toString();
    }
}
