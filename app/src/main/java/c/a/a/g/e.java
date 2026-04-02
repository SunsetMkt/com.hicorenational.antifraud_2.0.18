package c.a.a.g;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: ScreenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static DisplayMetrics f1965b;

    public static float a(Context context) {
        return c(context).density;
    }

    public static int b(Context context) {
        return c(context).densityDpi;
    }

    public static DisplayMetrics c(Context context) {
        DisplayMetrics displayMetrics = f1965b;
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        d.e("screen width=" + displayMetrics2.widthPixels + "px, screen height=" + displayMetrics2.heightPixels + "px, densityDpi=" + displayMetrics2.densityDpi + ", density=" + displayMetrics2.density);
        return displayMetrics2;
    }

    public static int d(Context context) {
        return c(context).heightPixels;
    }

    public static int e(Context context) {
        return c(context).widthPixels;
    }

    public static boolean a() {
        return a;
    }

    public static void b(Activity activity) {
        Window window = activity.getWindow();
        if (a) {
            window.clearFlags(1024);
            a = false;
        } else {
            window.setFlags(1024, 1024);
            a = true;
        }
    }

    public static void a(Activity activity) {
        activity.getWindow().setFlags(128, 128);
    }
}
