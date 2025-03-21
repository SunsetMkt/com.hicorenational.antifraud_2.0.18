package p324i.p339e.p343b.p350c.p351a;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: IdentifierManager.java */
/* renamed from: i.e.b.c.a.b */
/* loaded from: classes2.dex */
public class C5833b {

    /* renamed from: a */
    private static final String f20984a = "IdentifierManager";

    /* renamed from: b */
    private static Object f20985b;

    /* renamed from: c */
    private static Class<?> f20986c;

    /* renamed from: d */
    private static Method f20987d;

    /* renamed from: e */
    private static Method f20988e;

    /* renamed from: f */
    private static Method f20989f;

    /* renamed from: g */
    private static Method f20990g;

    static {
        try {
            f20986c = Class.forName("com.android.id.impl.IdProviderImpl");
            f20985b = f20986c.newInstance();
            f20987d = f20986c.getMethod("getUDID", Context.class);
            f20988e = f20986c.getMethod("getOAID", Context.class);
            f20989f = f20986c.getMethod("getVAID", Context.class);
            f20990g = f20986c.getMethod("getAAID", Context.class);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static boolean m24480a() {
        return (f20986c == null || f20985b == null) ? false : true;
    }

    /* renamed from: b */
    public static String m24481b(Context context) {
        return m24479a(context, f20988e);
    }

    /* renamed from: c */
    public static String m24482c(Context context) {
        return m24479a(context, f20989f);
    }

    /* renamed from: d */
    public static String m24483d(Context context) {
        return m24479a(context, f20990g);
    }

    /* renamed from: a */
    public static String m24478a(Context context) {
        return m24479a(context, f20987d);
    }

    /* renamed from: a */
    private static String m24479a(Context context, Method method) {
        Object obj = f20985b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
