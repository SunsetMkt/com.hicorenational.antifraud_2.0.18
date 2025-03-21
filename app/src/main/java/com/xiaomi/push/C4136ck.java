package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4394q;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.xiaomi.push.ck */
/* loaded from: classes2.dex */
public class C4136ck {

    /* renamed from: a */
    private static final List<String> f14744a = Arrays.asList("001", "002", "003", "004", "005");

    /* renamed from: a */
    private static Boolean f14743a = null;

    /* renamed from: a */
    public static void m14114a(String str, String str2) {
    }

    /* renamed from: a */
    public static boolean m14115a(Context context) {
        if (f14743a == null) {
            try {
                if (!C4300j.m15681a(context)) {
                    f14743a = false;
                }
                String m16206a = C4394q.m16206a(context);
                if (TextUtils.isEmpty(m16206a) || m16206a.length() < 3) {
                    f14743a = false;
                } else {
                    f14743a = Boolean.valueOf(f14744a.contains(m16206a.substring(m16206a.length() - 3)));
                }
                m14113a("Sampling statistical connection quality: " + f14743a);
            } catch (Throwable th) {
                f14743a = false;
                AbstractC4022b.m13360c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return f14743a.booleanValue();
    }

    /* renamed from: a */
    static void m14113a(String str) {
        m14114a("Push-ConnectionQualityStatsHelper", str);
    }
}
