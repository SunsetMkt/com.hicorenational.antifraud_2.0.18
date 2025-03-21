package p358k.p359a.p369b.p373b.p374a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat.java */
/* renamed from: k.a.b.b.a.a */
/* loaded from: classes2.dex */
public class C5870a {

    /* compiled from: BundleCompat.java */
    /* renamed from: k.a.b.b.a.a$a */
    static class a {

        /* renamed from: a */
        private static Method f21190a;

        /* renamed from: b */
        private static boolean f21191b;

        /* renamed from: a */
        public static void m24739a(Bundle bundle, String str, IBinder iBinder) {
            if (!f21191b) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f21190a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f21191b = true;
            }
            Method method2 = f21190a;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f21190a = null;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m24738a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.m24739a(bundle, str, iBinder);
        }
    }
}
