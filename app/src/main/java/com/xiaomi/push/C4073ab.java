package com.xiaomi.push;

import android.content.Context;
import p286h.C5230f1;

/* renamed from: com.xiaomi.push.ab */
/* loaded from: classes2.dex */
public class C4073ab {

    /* renamed from: a */
    static final char[] f14477a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static boolean m13692a(Context context) {
        return C4072aa.f14476a;
    }

    /* renamed from: a */
    public static String m13691a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i2 + i4] & C5230f1.f20085c;
            sb.append(f14477a[i5 >> 4]);
            sb.append(f14477a[i5 & 15]);
        }
        return sb.toString();
    }
}
