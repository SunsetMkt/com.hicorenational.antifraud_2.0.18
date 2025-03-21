package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.push.d */
/* loaded from: classes.dex */
public abstract class AbstractC2484d {

    /* renamed from: a */
    private static final Object f7743a = new Object();

    /* renamed from: b */
    private static int f7744b = -1;

    /* renamed from: a */
    private static boolean m7544a(Context context) {
        HMSLog.m7712d("CommFun", "existFrameworkPush:" + f7744b);
        try {
            File file = new File("/system/framework/hwpush.jar");
            if (m7543a()) {
                HMSLog.m7712d("CommFun", "push jarFile is exist");
            } else {
                if (!file.isFile()) {
                    return false;
                }
                HMSLog.m7712d("CommFun", "push jarFile is exist");
            }
            return true;
        } catch (Exception e2) {
            HMSLog.m7715e("CommFun", "get Apk version faild ,Exception e= " + e2.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static long m7546b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.m7715e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: c */
    public static boolean m7549c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* renamed from: d */
    public static boolean m7550d(Context context) {
        HMSLog.m7712d("CommFun", "existFrameworkPush:" + f7744b);
        synchronized (f7743a) {
            int i2 = f7744b;
            if (-1 != i2) {
                return 1 == i2;
            }
            if (m7544a(context)) {
                f7744b = 1;
            } else {
                f7744b = 0;
            }
            return 1 == f7744b;
        }
    }

    /* renamed from: c */
    public static String m7548c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    /* renamed from: b */
    public static boolean m7547b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    /* renamed from: a */
    private static boolean m7543a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", Integer.valueOf(((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue()));
            if (file != null && file.exists()) {
                HMSLog.m7712d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.m7715e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HMSLog.m7715e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (IllegalArgumentException unused3) {
            HMSLog.m7715e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (NoSuchFieldException unused4) {
            HMSLog.m7715e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused5) {
            HMSLog.m7715e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (SecurityException unused6) {
            HMSLog.m7715e("CommFun", "check cust exist push SecurityException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.m7715e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7545a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
