package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* loaded from: classes.dex */
public class ContextUtil {

    /* renamed from: a */
    private static Context f8237a;

    public static Context getInstance() {
        return f8237a;
    }

    public static void setContext(Context context) {
        if (context == null || f8237a != null) {
            return;
        }
        f8237a = context.getApplicationContext();
    }
}
