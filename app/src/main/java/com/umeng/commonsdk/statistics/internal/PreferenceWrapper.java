package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.C3336at;

/* loaded from: classes2.dex */
public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = C3336at.m10865b().m10868b(C3336at.f11496j);

    private PreferenceWrapper() {
    }

    public static SharedPreferences getDefault(Context context) {
        if (context != null) {
            return context.getSharedPreferences(DEFAULT_PREFERENCE, 0);
        }
        return null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
