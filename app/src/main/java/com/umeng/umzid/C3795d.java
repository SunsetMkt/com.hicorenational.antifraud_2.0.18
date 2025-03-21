package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* renamed from: com.umeng.umzid.d */
/* loaded from: classes2.dex */
public class C3795d {

    /* renamed from: a */
    public static String[] f13854a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    /* renamed from: a */
    public static String m12736a(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("getAndroidId", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: a */
    public static String m12737a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m12738a(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        String m12740b = m12740b(str);
        if (context == null || m12740b == null || TextUtils.isEmpty(m12740b) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, m12740b).commit();
    }

    /* renamed from: b */
    public static String m12739b(Context context) {
        SharedPreferences m12731a;
        if (context == null || (m12731a = C3792a.m12731a(context)) == null) {
            return "";
        }
        String string = m12731a.getString("inputDomain", "");
        return m12744c(string) ? m12737a(string) : string;
    }

    /* renamed from: b */
    public static String m12740b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m12741b(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        String m12740b = m12740b(str);
        if (context == null || m12740b == null || TextUtils.isEmpty(m12740b) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("oaid", m12740b).commit();
    }

    /* renamed from: c */
    public static String m12742c(Context context) {
        SharedPreferences m12731a;
        return (context == null || (m12731a = C3792a.m12731a(context)) == null) ? "" : m12731a.getString("uabc", "");
    }

    /* renamed from: c */
    public static void m12743c(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    /* renamed from: c */
    public static boolean m12744c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(m12740b(m12737a(str)));
    }

    /* renamed from: d */
    public static String m12745d(Context context) {
        SharedPreferences m12731a;
        if (context == null || (m12731a = C3792a.m12731a(context)) == null) {
            return null;
        }
        return m12731a.getString("aaid", null);
    }

    /* renamed from: d */
    public static void m12746d(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    /* renamed from: e */
    public static String m12747e(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("getMac", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: e */
    public static void m12748e(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    /* renamed from: f */
    public static String m12749f(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("getOaid", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: f */
    public static void m12750f(Context context, String str) {
        SharedPreferences m12731a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m12731a = C3792a.m12731a(context)) == null || (edit = m12731a.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    /* renamed from: g */
    public static boolean m12751g(Context context) {
        boolean z;
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f13854a) {
                if (path.contains(str)) {
                    z = true;
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        z = false;
        return z;
    }

    /* renamed from: h */
    public static boolean m12752h(Context context) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("isMainProgress", Context.class)) == null) {
                return true;
            }
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(cls, context)).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: i */
    public static boolean m12753i(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                    return networkInfo.isConnected();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: j */
    public static boolean m12754j(Context context) {
        String host;
        int port;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                int parseInt = Integer.parseInt(property2);
                host = property;
                port = parseInt;
            } else {
                host = Proxy.getHost(context);
                port = Proxy.getPort(context);
            }
            return (TextUtils.isEmpty(host) || port == -1) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
