package i.e.b.b.a.a;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16904a = "OpenIdHelper";

    /* renamed from: b, reason: collision with root package name */
    private static Method f16905b;

    public static String a(Context context) {
        f a2 = f.a();
        return a2.a(context.getApplicationContext(), a2.f16913a);
    }

    public static void a(boolean z) {
        f.a();
        f.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f16905b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f16905b = method;
                method.setAccessible(true);
            }
            context = (Context) f16905b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "ActivityThread:currentApplication --> " + e2.toString();
        }
        if (context == null) {
            return false;
        }
        return f.a().a(context, false);
    }

    public static String b(Context context) {
        f a2 = f.a();
        return a2.a(context.getApplicationContext(), a2.f16914b);
    }

    public static String c(Context context) {
        f a2 = f.a();
        return a2.a(context.getApplicationContext(), a2.f16916d);
    }

    public static String d(Context context) {
        f a2 = f.a();
        return a2.a(context.getApplicationContext(), a2.f16915c);
    }
}
