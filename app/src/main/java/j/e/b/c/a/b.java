package j.e.b.c.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: IdentifierManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "IdentifierManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f12581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f12582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f12583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f12584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f12585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f12586g;

    static {
        try {
            f12582c = Class.forName("com.android.id.impl.IdProviderImpl");
            f12581b = f12582c.newInstance();
            f12583d = f12582c.getMethod("getUDID", Context.class);
            f12584e = f12582c.getMethod("getOAID", Context.class);
            f12585f = f12582c.getMethod("getVAID", Context.class);
            f12586g = f12582c.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return (f12582c == null || f12581b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f12584e);
    }

    public static String c(Context context) {
        return a(context, f12585f);
    }

    public static String d(Context context) {
        return a(context, f12586g);
    }

    public static String a(Context context) {
        return a(context, f12583d);
    }

    private static String a(Context context, Method method) {
        Object obj = f12581b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
