package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpWrapper.java */
/* renamed from: com.umeng.analytics.pro.aq */
/* loaded from: classes2.dex */
public class C3333aq {

    /* renamed from: a */
    public static final String f11470a = "cl_count";

    /* renamed from: b */
    public static final String f11471b = "interval_";

    /* renamed from: c */
    public static final String f11472c = "config_ts";

    /* renamed from: d */
    public static final String f11473d = "iucc_s1";

    /* renamed from: e */
    public static final String f11474e = "iucc_s2";

    /* renamed from: f */
    public static final String f11475f = "sdk_type_ver";

    /* renamed from: g */
    public static final String f11476g = "should_fetch";

    /* renamed from: h */
    private static final String f11477h = "ccg_sp_config_file";

    private C3333aq() {
    }

    /* renamed from: a */
    public static SharedPreferences m10859a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f11477h, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
