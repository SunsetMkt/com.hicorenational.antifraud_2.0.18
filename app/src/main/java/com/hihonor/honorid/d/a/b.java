package com.hihonor.honorid.d.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: HnIdEncrypter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(Context context, String str) {
        int i2;
        try {
            i2 = Integer.parseInt(l.a.a.a.c.a(context));
        } catch (Exception unused) {
            l.a.a.a.j.e.b("HnIdEncrypter", "get version of encrypted is null, use GRADE_VERSION_KEYSTORE directory", true);
            i2 = 3;
        }
        String strA = null;
        if (Build.VERSION.SDK_INT >= 23 && i2 >= 3) {
            strA = c.a(context.getPackageName() + ".hnidsdk", str);
        }
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        return c.b(context.getPackageName() + ".hnidsdk", str);
    }

    public static String c(Context context, String str) {
        return a(context, str);
    }
}
