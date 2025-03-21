package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;

/* loaded from: classes.dex */
public class RegionUtils {
    /* renamed from: a */
    private static String m7808a(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : GrsApp.getInstance().getIssueCountryCode(context);
    }

    public static boolean isChinaROM(Context context) {
        return "CN".equalsIgnoreCase(m7808a(context));
    }
}
