package j.e.b.a.a.a;

import android.content.Context;
import j.e.a.a.a.a;

/* JADX INFO: compiled from: OpenIDSDK.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Context context) {
        a.b.f12557b = a.c.b.a.a(context.getApplicationContext());
        a.b.a = true;
    }

    public static String b(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.b.a) {
            return a.c.b.a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.b.a) {
            return a.b.f12557b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
