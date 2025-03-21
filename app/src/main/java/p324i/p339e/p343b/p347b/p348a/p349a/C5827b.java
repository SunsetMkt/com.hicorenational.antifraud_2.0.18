package p324i.p339e.p343b.p347b.p348a.p349a;

import android.content.Context;
import java.lang.reflect.Method;

/* renamed from: i.e.b.b.a.a.b */
/* loaded from: classes2.dex */
public class C5827b {

    /* renamed from: a */
    private static final String f20963a = "OpenIdHelper";

    /* renamed from: b */
    private static Method f20964b;

    /* renamed from: a */
    public static String m24456a(Context context) {
        C5831f m24468a = C5831f.m24468a();
        return m24468a.m24476a(context.getApplicationContext(), m24468a.f20972a);
    }

    /* renamed from: a */
    public static void m24457a(boolean z) {
        C5831f.m24468a();
        C5831f.m24471a(z);
    }

    /* renamed from: a */
    public static final boolean m24458a() {
        Context context = null;
        try {
            if (f20964b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f20964b = method;
                method.setAccessible(true);
            }
            context = (Context) f20964b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "ActivityThread:currentApplication --> " + e2.toString();
        }
        if (context == null) {
            return false;
        }
        return C5831f.m24468a().m24477a(context, false);
    }

    /* renamed from: b */
    public static String m24459b(Context context) {
        C5831f m24468a = C5831f.m24468a();
        return m24468a.m24476a(context.getApplicationContext(), m24468a.f20973b);
    }

    /* renamed from: c */
    public static String m24460c(Context context) {
        C5831f m24468a = C5831f.m24468a();
        return m24468a.m24476a(context.getApplicationContext(), m24468a.f20975d);
    }

    /* renamed from: d */
    public static String m24461d(Context context) {
        C5831f m24468a = C5831f.m24468a();
        return m24468a.m24476a(context.getApplicationContext(), m24468a.f20974c);
    }
}
