package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.r */
/* loaded from: classes2.dex */
public class C4309r {

    /* renamed from: a */
    private static Context f16395a;

    /* renamed from: a */
    private static String f16396a;

    /* renamed from: a */
    public static void m15718a(Context context) {
        f16395a = context.getApplicationContext();
    }

    /* renamed from: b */
    public static boolean m15722b() {
        try {
            return m15716a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            AbstractC4022b.m13361d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }

    /* renamed from: c */
    private static String m15723c() {
        String m15713a = C4308q.m15713a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(m15713a) && !m15713a.startsWith("ColorOS_")) {
            f16396a = "ColorOS_" + m15713a;
        }
        return f16396a;
    }

    /* renamed from: d */
    private static String m15724d() {
        String m15713a = C4308q.m15713a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(m15713a) && !m15713a.startsWith("FuntouchOS_")) {
            f16396a = "FuntouchOS_" + m15713a;
        }
        return f16396a;
    }

    /* renamed from: a */
    public static Context m15715a() {
        return f16395a;
    }

    /* renamed from: a */
    public static int m15714a() {
        try {
            Class<?> m15716a = m15716a(null, "miui.os.Build");
            if (m15716a.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return m15716a.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static String m15721b() {
        f16396a = C4308q.m15713a("ro.build.version.emui", "");
        return f16396a;
    }

    /* renamed from: a */
    public static boolean m15720a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15719a() {
        return TextUtils.equals((String) C4094aw.m13824a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a */
    public static synchronized String m15717a() {
        String str;
        synchronized (C4309r.class) {
            if (f16396a != null) {
                return f16396a;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (m15714a() <= 0) {
                str = m15721b();
                if (TextUtils.isEmpty(str)) {
                    str = m15723c();
                    if (TextUtils.isEmpty(str)) {
                        str = m15724d();
                        if (TextUtils.isEmpty(str)) {
                            str2 = String.valueOf(C4308q.m15713a(SystemUtils.PRODUCT_BRAND, "Android") + AbstractC1191a.f2606s1 + str2);
                        }
                    }
                }
                f16396a = str;
                return str;
            }
            str = str2;
            f16396a = str;
            return str;
        }
    }

    /* renamed from: a */
    public static Class<?> m15716a(Context context, String str) {
        if (str != null && str.trim().length() != 0) {
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                AbstractC4022b.m13347a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }
}
