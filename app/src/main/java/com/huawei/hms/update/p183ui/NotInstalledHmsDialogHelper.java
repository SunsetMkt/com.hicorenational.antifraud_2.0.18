package com.huawei.hms.update.p183ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes.dex */
public class NotInstalledHmsDialogHelper {
    /* renamed from: a */
    private static void m7727a(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
    }

    public static String getAppName(Activity activity) {
        return activity == null ? "" : m7726a(activity, activity.getPackageName());
    }

    public static int getConfirmResId(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        m7727a(activity);
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }

    public static AlertDialog.Builder getDialogBuilder(Activity activity) {
        Checker.checkNonNull(activity, "activity must not be null");
        m7727a(activity);
        return new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity)).setMessage(activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), new Object[]{m7726a(activity, activity.getPackageName())}));
    }

    /* renamed from: a */
    private static String m7726a(Context context, String str) {
        if (context == null) {
            HMSLog.m7715e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m7715e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m7715e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
            return "";
        }
    }
}
