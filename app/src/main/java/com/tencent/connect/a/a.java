package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Class<?> a = null;

    /* JADX INFO: renamed from: b */
    private static Class<?> f6613b = null;

    /* JADX INFO: renamed from: c */
    private static Method f6614c = null;

    /* JADX INFO: renamed from: d */
    private static Method f6615d = null;

    /* JADX INFO: renamed from: e */
    private static Method f6616e = null;

    /* JADX INFO: renamed from: f */
    private static Method f6617f = null;

    /* JADX INFO: renamed from: g */
    private static boolean f6618g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f6617f.invoke(a, true);
            } else {
                f6617f.invoke(a, false);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            a = Class.forName("com.tencent.stat.StatConfig");
            f6613b = Class.forName("com.tencent.stat.StatService");
            f6614c = f6613b.getMethod("reportQQ", Context.class, String.class);
            f6615d = f6613b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f6616e = f6613b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f6617f = a.getMethod("setEnableStatService", Boolean.TYPE);
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(a, false);
            a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(a, true);
            a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(a, 1440);
            Class<?> cls = Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", cls).invoke(a, cls.getField("PERIOD").get(null));
            Method method = f6613b.getMethod("startStatService", Context.class, String.class, String.class);
            Class<?> cls2 = f6613b;
            Object[] objArr = new Object[3];
            objArr[0] = context;
            objArr[1] = str;
            objArr[2] = Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null);
            method.invoke(cls2, objArr);
            f6618g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (f6618g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f6614c.invoke(f6613b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f6618g) {
            b(context, qQToken);
            try {
                f6615d.invoke(f6613b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
