package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* renamed from: com.xiaomi.push.l */
/* loaded from: classes2.dex */
public abstract class AbstractC4302l {
    /* renamed from: a */
    public static void m15695a(Context context) {
    }

    /* renamed from: a */
    public static boolean m15698a(Context context, String str, boolean z) {
        m15695a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    /* renamed from: a */
    public static void m15696a(Context context, String str, boolean z) {
        m15695a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public static void m15697a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }
}
