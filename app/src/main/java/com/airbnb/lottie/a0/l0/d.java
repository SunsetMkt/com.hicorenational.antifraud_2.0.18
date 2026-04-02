package com.airbnb.lottie.a0.l0;

import i.z2.h0;

/* JADX INFO: compiled from: JsonScope.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    static final int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f2052b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f2053c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f2054d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f2055e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f2056f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f2057g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f2058h = 8;

    private d() {
    }

    static String a(int i2, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f12422b);
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
