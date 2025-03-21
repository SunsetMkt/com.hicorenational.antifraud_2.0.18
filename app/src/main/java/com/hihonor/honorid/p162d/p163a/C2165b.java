package com.hihonor.honorid.p162d.p163a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import p358k.p359a.p360a.p361a.C5849c;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: HnIdEncrypter.java */
/* renamed from: com.hihonor.honorid.d.a.b */
/* loaded from: classes.dex */
public class C2165b {
    /* renamed from: a */
    public static String m6302a(Context context, String str) {
        int i2;
        try {
            i2 = Integer.parseInt(C5849c.m24627a(context));
        } catch (Exception unused) {
            C5863e.m24692b("HnIdEncrypter", "get version of encrypted is null, use GRADE_VERSION_KEYSTORE directory", true);
            i2 = 3;
        }
        String str2 = null;
        if (Build.VERSION.SDK_INT >= 23 && i2 >= 3) {
            str2 = C2166c.m6305a(context.getPackageName() + ".hnidsdk", str);
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    /* renamed from: b */
    public static String m6303b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        return C2166c.m6307b(context.getPackageName() + ".hnidsdk", str);
    }

    /* renamed from: c */
    public static String m6304c(Context context, String str) {
        return m6302a(context, str);
    }
}
