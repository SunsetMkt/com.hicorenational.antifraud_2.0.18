package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.push.service.C4356ah;

/* renamed from: com.xiaomi.push.di */
/* loaded from: classes2.dex */
public class C4161di {
    /* renamed from: a */
    public static byte[] m14287a(String str, byte[] bArr) {
        byte[] m13840a = C4096ay.m13840a(str);
        try {
            m14285a(m13840a);
            return C4260h.m15241a(m13840a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m14288b(String str, byte[] bArr) {
        byte[] m13840a = C4096ay.m13840a(str);
        try {
            m14285a(m13840a);
            return C4260h.m15242b(m13840a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m14285a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    /* renamed from: a */
    public static boolean m14286a(Context context, String str, long j2) {
        if (C4356ah.m15923a(context).m15935a(EnumC4244gk.DCJobMutualSwitch.m15014a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !C4074ac.m13693a(context, str, j2);
        }
        return false;
    }
}
