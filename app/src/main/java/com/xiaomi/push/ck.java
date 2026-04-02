package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ck {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final List<String> f269a = Arrays.asList("001", "002", "003", "004", "005");
    private static Boolean a = null;

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (a == null) {
            try {
                if (!j.m625a(context)) {
                    a = false;
                }
                String strM740a = com.xiaomi.push.service.q.m740a(context);
                if (TextUtils.isEmpty(strM740a) || strM740a.length() < 3) {
                    a = false;
                } else {
                    a = Boolean.valueOf(f269a.contains(strM740a.substring(strM740a.length() - 3)));
                }
                a("Sampling statistical connection quality: " + a);
            } catch (Throwable th) {
                a = false;
                com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return a.booleanValue();
    }

    static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
