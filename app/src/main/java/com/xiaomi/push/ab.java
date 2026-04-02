package com.xiaomi.push;

import android.content.Context;
import i.f1;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    static final char[] a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return aa.a;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i2 + i4] & f1.f12066c;
            sb.append(a[i5 >> 4]);
            sb.append(a[i5 & 15]);
        }
        return sb.toString();
    }
}
