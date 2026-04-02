package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SpWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class aq {
    public static final String a = "cl_count";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7007b = "interval_";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7008c = "config_ts";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7009d = "iucc_s1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7010e = "iucc_s2";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7011f = "sdk_type_ver";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7012g = "should_fetch";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f7013h = "ccg_sp_config_file";

    private aq() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f7013h, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
