package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public class ScreenUtil {

    /* renamed from: a */
    private static final String f8282a = "ScreenUtil";

    /* renamed from: b */
    private static final int f8283b = 524288;

    /* renamed from: com.huawei.secure.android.common.util.ScreenUtil$a */
    private static class C2568a implements PrivilegedAction {

        /* renamed from: a */
        Method f8284a;

        public C2568a(Method method) {
            this.f8284a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.f8284a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    /* renamed from: a */
    private static void m8042a(Activity activity, int i2) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.m8021e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i2);
        }
    }

    /* renamed from: b */
    private static void m8043b(Activity activity, int i2) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.m8021e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i2);
        }
    }

    public static void disableScreenshots(Activity activity) {
        m8042a(activity, 8192);
    }

    public static void enableScreenshots(Activity activity) {
        m8043b(activity, 8192);
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            Window window = activity.getWindow();
            Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
            AccessController.doPrivileged(new C2568a(declaredMethod));
            declaredMethod.invoke(window, 524288);
        } catch (ClassNotFoundException unused) {
            LogsUtil.m8021e(f8282a, "hideOverlayWindows ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            LogsUtil.m8021e(f8282a, "hideOverlayWindows IllegalAccessException");
        } catch (NoSuchMethodException unused3) {
            LogsUtil.m8021e(f8282a, "hideOverlayWindows NoSuchMethodException");
        } catch (InvocationTargetException unused4) {
            LogsUtil.m8021e(f8282a, "hideOverlayWindows InvocationTargetException");
        }
    }
}
