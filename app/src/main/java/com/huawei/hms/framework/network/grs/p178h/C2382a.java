package com.huawei.hms.framework.network.grs.p178h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* renamed from: com.huawei.hms.framework.network.grs.h.a */
/* loaded from: classes.dex */
public class C2382a {
    /* renamed from: a */
    public static String m6972a() {
        return "6.0.11.300";
    }

    /* renamed from: a */
    public static String m6973a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.m6804w("AgentUtil", "", e2);
            return "";
        }
    }

    /* renamed from: a */
    public static String m6974a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", m6972a());
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String m6973a = m6973a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = m6973a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = m6972a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }

    /* renamed from: b */
    public static String m6975b(Context context, String str, String str2) {
        return m6974a(context, str, str2);
    }
}
