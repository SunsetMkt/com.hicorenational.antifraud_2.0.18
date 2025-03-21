package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* loaded from: classes.dex */
public class ConnectionErrorMessages {
    /* renamed from: a */
    private static boolean m6738a(Context context) {
        return context != null && Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context);
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i2) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        return i2 != 1 ? i2 != 2 ? ResourceLoaderUtil.getString("hms_confirm") : m6738a(activity) ? ResourceLoaderUtil.getString("hms_update") : ResourceLoaderUtil.getString("hms_confirm") : m6738a(activity) ? ResourceLoaderUtil.getString("hms_install") : ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity activity, int i2) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i2 == 1 || i2 == 2) {
            return m6738a(activity) ? ResourceLoaderUtil.getString("hms_update_title") : activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{Util.getAppName(activity, activity.getPackageName())});
        }
        return null;
    }

    public static String getErrorTitle(Activity activity, int i2) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i2 == 1) {
            if (m6738a(activity)) {
                return ResourceLoaderUtil.getString("hms_install_message");
            }
            return null;
        }
        if (i2 == 2) {
            if (m6738a(activity)) {
                return ResourceLoaderUtil.getString("hms_update_message");
            }
            return null;
        }
        if (i2 == 3) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
        }
        if (i2 == 9) {
            HMSLog.m7715e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
            return null;
        }
        HMSLog.m7715e("HuaweiApiAvailability", "Unexpected error code " + i2);
        return null;
    }
}
