package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.content.PermissionChecker;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

/* loaded from: classes.dex */
public class PermissionUtil {

    /* renamed from: a */
    private static final String f8274a = "PermissionUtil";

    public static boolean checkCallingPermission(Context context, String str, String str2) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() == Process.myPid()) {
            return false;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static boolean checkPermission(Context context, String str, int i2, int i3, String str2) throws NoPermissionCheckerException {
        try {
            return context.getApplicationInfo().targetSdkVersion > 23 ? context.checkPermission(str, i2, i3) == 0 : PermissionChecker.checkPermission(context, str, i2, i3, str2) == 0;
        } catch (Throwable th) {
            String str3 = "checkPermission: " + th.getMessage() + " , you should implementation support library or androidx library";
            throw new NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean checkSelfPermission(Context context, String str) throws NoPermissionCheckerException {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
