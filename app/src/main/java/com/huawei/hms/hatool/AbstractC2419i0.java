package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC2419i0 {
    /* renamed from: a */
    public static String m7164a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(AbstractC2460z.m7421a(str, str2))) {
            return AbstractC2460z.m7421a(str, str2);
        }
        C2452v.m7385c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return m7166c(context, str, str2);
    }

    /* renamed from: b */
    public static String m7165b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            C2452v.m7390f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return m7167d(context, str, str2);
    }

    /* renamed from: c */
    private static String m7166c(Context context, String str, String str2) {
        if (!AbstractC2460z.m7422b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(AbstractC2443q0.m7301d())) {
            C2446s.m7326c().m7331b().m7119b(AbstractC2436o.m7259a(context));
        }
        return AbstractC2443q0.m7301d();
    }

    /* renamed from: d */
    private static String m7167d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(AbstractC2396a1.m7022d(str, str2))) {
            return AbstractC2396a1.m7022d(str, str2);
        }
        C2414g1 m7331b = C2446s.m7326c().m7331b();
        if (TextUtils.isEmpty(m7331b.m7130h())) {
            String m7263b = AbstractC2436o.m7263b(context);
            if (!C2408e1.m7098a("channel", m7263b, 256)) {
                m7263b = "";
            }
            m7331b.m7127f(m7263b);
        }
        return m7331b.m7130h();
    }
}
