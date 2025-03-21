package p023b.p024a.p025a.p029g;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: ScreenUtils.java */
/* renamed from: b.a.a.g.e */
/* loaded from: classes.dex */
public final class C0932e {

    /* renamed from: a */
    private static boolean f1570a = false;

    /* renamed from: b */
    private static DisplayMetrics f1571b;

    /* renamed from: a */
    public static float m1168a(Context context) {
        return m1173c(context).density;
    }

    /* renamed from: b */
    public static int m1171b(Context context) {
        return m1173c(context).densityDpi;
    }

    /* renamed from: c */
    public static DisplayMetrics m1173c(Context context) {
        DisplayMetrics displayMetrics = f1571b;
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        C0931d.m1166e("screen width=" + displayMetrics2.widthPixels + "px, screen height=" + displayMetrics2.heightPixels + "px, densityDpi=" + displayMetrics2.densityDpi + ", density=" + displayMetrics2.density);
        return displayMetrics2;
    }

    /* renamed from: d */
    public static int m1174d(Context context) {
        return m1173c(context).heightPixels;
    }

    /* renamed from: e */
    public static int m1175e(Context context) {
        return m1173c(context).widthPixels;
    }

    /* renamed from: a */
    public static boolean m1170a() {
        return f1570a;
    }

    /* renamed from: b */
    public static void m1172b(Activity activity) {
        Window window = activity.getWindow();
        if (f1570a) {
            window.clearFlags(1024);
            f1570a = false;
        } else {
            window.setFlags(1024, 1024);
            f1570a = true;
        }
    }

    /* renamed from: a */
    public static void m1169a(Activity activity) {
        activity.getWindow().setFlags(128, 128);
    }
}
