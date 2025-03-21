package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.service.j */
/* loaded from: classes2.dex */
public class C4387j {
    /* renamed from: a */
    public static boolean m16112a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static ComponentName m16111a(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                return new ComponentName(resolveActivity.activityInfo.packageName, TextUtils.isEmpty(resolveActivity.activityInfo.targetActivity) ? resolveActivity.activityInfo.name : resolveActivity.activityInfo.targetActivity);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
