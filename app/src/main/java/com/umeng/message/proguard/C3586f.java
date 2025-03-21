package com.umeng.message.proguard;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.p221ut.device.UTDevice;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.message.proguard.f */
/* loaded from: classes2.dex */
public final class C3586f {

    /* renamed from: d */
    private static String f13279d;

    /* renamed from: e */
    private static Boolean f13280e;

    /* renamed from: f */
    private static Boolean f13281f;

    /* renamed from: c */
    private static final AtomicInteger f13278c = new AtomicInteger(1);

    /* renamed from: a */
    public static boolean f13276a = true;

    /* renamed from: b */
    public static boolean f13277b = true;

    /* renamed from: a */
    public static void m12386a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public static boolean m12390b(Context context) {
        Boolean bool = f13280e;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        Boolean valueOf = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(m12381a(context), packageName));
        f13280e = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: c */
    public static boolean m12392c(Context context) {
        Boolean bool;
        try {
            bool = (Boolean) C3579ba.m12333a(C3579ba.m12335a(UTDevice.class.getName(), "isNewDid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
            bool = null;
        }
        return Boolean.TRUE.equals(bool);
    }

    /* renamed from: d */
    public static String m12393d(Context context) {
        try {
            return (String) C3579ba.m12333a(C3579ba.m12335a(UTDevice.class.getName(), "getTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
            return null;
        }
    }

    /* renamed from: e */
    public static void m12394e(Context context) {
        try {
            C3579ba.m12333a(C3579ba.m12335a(UTDevice.class.getName(), "removeTid", (Class<?>[]) new Class[]{Context.class}), (Object) null, new Object[]{context});
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
        }
    }

    /* renamed from: f */
    public static boolean m12395f(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    /* renamed from: g */
    public static File m12396g(Context context) {
        File file = new File(context.getCacheDir(), "umeng_push");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static void m12384a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) >= 0) {
                ComponentName componentName = new ComponentName(context, cls);
                if (m12388a(packageManager, componentName)) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
        }
    }

    /* renamed from: b */
    public static boolean m12389b() {
        Boolean bool = f13281f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = null;
        try {
            bool2 = (Boolean) C3579ba.m12333a(C3579ba.m12335a(UMConfigure.class.getName(), "isSilentMode", (Class<?>[]) new Class[0]), (Object) null, (Object[]) null);
        } catch (Throwable unused) {
        }
        Boolean valueOf = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
        f13281f = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: c */
    public static void m12391c() {
        try {
            Method m12335a = C3579ba.m12335a(UMConfigure.class.getName(), "registerActionInfo", (Class<?>[]) new Class[]{Class.forName("com.umeng.ccg.ActionInfo")});
            if (m12335a != null) {
                C3579ba.m12333a(m12335a, (Object) null, new Object[]{C3579ba.m12331a(C3598r.class.getName(), (Class<?>[]) null, (Object[]) null)});
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static boolean m12388a(PackageManager packageManager, ComponentName componentName) {
        try {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
            return false;
        }
    }

    /* renamed from: a */
    public static String m12381a(Context context) {
        if (!TextUtils.isEmpty(f13279d)) {
            return f13279d;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            }
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
        }
        if (TextUtils.isEmpty(str)) {
            str = UMFrUtils.getCurrentProcessName(context);
        }
        f13279d = str;
        return str;
    }

    /* renamed from: a */
    public static String m12382a(Context context, String str) {
        String str2 = context.getCacheDir() + "/umeng_push_inapp/";
        if (str == null) {
            return str2;
        }
        return str2 + str + "/";
    }

    /* renamed from: a */
    public static int m12378a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f13278c.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f13278c.compareAndSet(i2, i3));
        return i2;
    }

    /* renamed from: a */
    public static void m12385a(Context context, String str, long j2) {
        try {
            C3579ba.m12333a(C3579ba.m12335a(UTDevice.class.getName(), "resetDid", (Class<?>[]) new Class[]{Context.class, String.class, Long.TYPE}), (Object) null, new Object[]{context, str, Long.valueOf(j2)});
        } catch (Throwable th) {
            UPLog.m12143e("Helper", th);
        }
    }

    /* renamed from: a */
    public static Object m12380a(Object obj, String str) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m12387a(long j2) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(6);
        calendar.setTimeInMillis(j2);
        return i3 == calendar.get(6) && i2 == calendar.get(1);
    }

    /* renamed from: a */
    public static Bitmap m12379a(File file, int i2, int i3) {
        try {
            if (i3 != 0 && i2 != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                float f2 = i2 >= i3 ? options.outWidth / i2 : options.outHeight / i3;
                float f3 = 1.0f;
                if (f2 >= 1.0f) {
                    f3 = f2;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = (int) f3;
                return BitmapFactory.decodeFile(file.getPath(), options);
            }
            return BitmapFactory.decodeFile(file.getPath(), null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m12383a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        switch (str) {
            case "HW_TOKEN":
                return "huawei";
            case "VIVO_TOKEN":
                return "vivo";
            case "MZ_TOKEN":
                return "meizu";
            case "OPPO_TOKEN":
                return "oppo";
            case "HONOR_TOKEN":
                return "honor";
            case "MI_TOKEN":
                return "xiaomi";
            case "gcm":
                return UPushThirdTokenCallback.TYPE_FCM;
            default:
                return str;
        }
    }
}
