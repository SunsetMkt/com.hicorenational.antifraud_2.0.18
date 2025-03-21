package com.airbnb.lottie.p098a0.p099l0;

import p286h.p323z2.C5736h0;

/* compiled from: JsonScope.java */
/* renamed from: com.airbnb.lottie.a0.l0.d */
/* loaded from: classes.dex */
final class C1331d {

    /* renamed from: a */
    static final int f3034a = 1;

    /* renamed from: b */
    static final int f3035b = 2;

    /* renamed from: c */
    static final int f3036c = 3;

    /* renamed from: d */
    static final int f3037d = 4;

    /* renamed from: e */
    static final int f3038e = 5;

    /* renamed from: f */
    static final int f3039f = 6;

    /* renamed from: g */
    static final int f3040g = 7;

    /* renamed from: h */
    static final int f3041h = 8;

    private C1331d() {
    }

    /* renamed from: a */
    static String m2711a(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append(C5736h0.f20713b);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = iArr[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(iArr2[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }
}
