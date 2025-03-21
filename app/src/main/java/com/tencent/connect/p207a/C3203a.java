package com.tencent.connect.p207a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3263e;
import com.tencent.open.utils.C3291i;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.a.a */
/* loaded from: classes2.dex */
public class C3203a {

    /* renamed from: a */
    private static Class<?> f10854a = null;

    /* renamed from: b */
    private static Class<?> f10855b = null;

    /* renamed from: c */
    private static Method f10856c = null;

    /* renamed from: d */
    private static Method f10857d = null;

    /* renamed from: e */
    private static Method f10858e = null;

    /* renamed from: f */
    private static Method f10859f = null;

    /* renamed from: g */
    private static boolean f10860g = false;

    /* renamed from: a */
    public static boolean m10155a(Context context, QQToken qQToken) {
        return C3291i.m10615a(context, qQToken.getAppId()).m10625b("Common_ta_enable");
    }

    /* renamed from: b */
    public static void m10156b(Context context, QQToken qQToken) {
        try {
            if (m10155a(context, qQToken)) {
                f10859f.invoke(f10854a, true);
            } else {
                f10859f.invoke(f10854a, false);
            }
        } catch (Exception e2) {
            SLog.m10500e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    /* renamed from: c */
    public static void m10157c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f10854a = Class.forName("com.tencent.stat.StatConfig");
            f10855b = Class.forName("com.tencent.stat.StatService");
            f10856c = f10855b.getMethod("reportQQ", Context.class, String.class);
            f10857d = f10855b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            f10858e = f10855b.getMethod("commitEvents", Context.class, Integer.TYPE);
            f10859f = f10854a.getMethod("setEnableStatService", Boolean.TYPE);
            m10156b(context, qQToken);
            f10854a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f10854a, false);
            f10854a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f10854a, true);
            f10854a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f10854a, 1440);
            Class<?> cls = Class.forName("com.tencent.stat.StatReportStrategy");
            f10854a.getMethod("setStatSendStrategy", cls).invoke(f10854a, cls.getField("PERIOD").get(null));
            Method method = f10855b.getMethod("startStatService", Context.class, String.class, String.class);
            Class<?> cls2 = f10855b;
            Object[] objArr = new Object[3];
            objArr[0] = context;
            objArr[1] = str;
            objArr[2] = Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null);
            method.invoke(cls2, objArr);
            f10860g = true;
        } catch (Exception e2) {
            SLog.m10500e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    /* renamed from: d */
    public static void m10158d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            C3263e.m10457a().m10460a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (f10860g) {
            m10156b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f10856c.invoke(f10855b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.m10500e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10154a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f10860g) {
            m10156b(context, qQToken);
            try {
                f10857d.invoke(f10855b, context, str, strArr);
            } catch (Exception e2) {
                SLog.m10500e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
