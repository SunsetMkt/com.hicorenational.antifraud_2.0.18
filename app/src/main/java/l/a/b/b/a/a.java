package l.a.b.b.a;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: BundleCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: l.a.b.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BundleCompat.java */
    static class C0268a {
        private static Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f12707b;

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!f12707b) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f12707b = true;
            }
            Method method2 = a;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    a = null;
                }
            }
        }
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0268a.a(bundle, str, iBinder);
        }
    }
}
