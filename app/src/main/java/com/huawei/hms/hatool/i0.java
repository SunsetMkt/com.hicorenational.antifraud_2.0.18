package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class i0 {
    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(z.a(str, str2))) {
            return z.a(str, str2);
        }
        v.c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(context, str, str2);
    }

    public static String b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            v.f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return d(context, str, str2);
    }

    private static String c(Context context, String str, String str2) {
        if (!z.b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(q0.d())) {
            s.c().b().b(o.a(context));
        }
        return q0.d();
    }

    private static String d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(a1.d(str, str2))) {
            return a1.d(str, str2);
        }
        g1 b2 = s.c().b();
        if (TextUtils.isEmpty(b2.h())) {
            String b3 = o.b(context);
            if (!e1.a("channel", b3, 256)) {
                b3 = "";
            }
            b2.f(b3);
        }
        return b2.h();
    }
}
