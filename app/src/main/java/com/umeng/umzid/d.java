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

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f11891a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static String a(Context context) {
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

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        String b2 = b(str);
        if (context == null || b2 == null || TextUtils.isEmpty(b2) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, b2).commit();
    }

    public static String b(Context context) {
        SharedPreferences a2;
        if (context == null || (a2 = a.a(context)) == null) {
            return "";
        }
        String string = a2.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        String b2 = b(str);
        if (context == null || b2 == null || TextUtils.isEmpty(b2) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("oaid", b2).commit();
    }

    public static String c(Context context) {
        SharedPreferences a2;
        return (context == null || (a2 = a.a(context)) == null) ? "" : a2.getString("uabc", "");
    }

    public static void c(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }

    public static String d(Context context) {
        SharedPreferences a2;
        if (context == null || (a2 = a.a(context)) == null) {
            return null;
        }
        return a2.getString("aaid", null);
    }

    public static void d(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static String e(Context context) {
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

    public static void e(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static String f(Context context) {
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

    public static void f(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a2 = a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    public static boolean g(Context context) {
        boolean z;
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f11891a) {
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

    public static boolean h(Context context) {
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

    public static boolean i(Context context) {
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

    public static boolean j(Context context) {
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
