package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class di {
    public static byte[] a(String str, byte[] bArr) {
        byte[] bArrM159a = ay.m159a(str);
        try {
            a(bArrM159a);
            return h.a(bArrM159a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] bArrM159a = ay.m159a(str);
        try {
            a(bArrM159a);
            return h.b(bArrM159a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j2) {
        if (com.xiaomi.push.service.ah.a(context).a(gk.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ac.a(context, str, j2);
        }
        return false;
    }
}
