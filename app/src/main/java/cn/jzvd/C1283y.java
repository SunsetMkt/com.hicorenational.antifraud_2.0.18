package cn.jzvd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import com.heytap.mcssdk.constant.C2084a;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: JZUtils.java */
/* renamed from: cn.jzvd.y */
/* loaded from: classes.dex */
public class C1283y {

    /* renamed from: a */
    public static final String f2872a = "JZVD";

    /* renamed from: b */
    public static int f2873b;

    /* renamed from: a */
    public static String m2549a(long j2) {
        if (j2 <= 0 || j2 >= 86400000) {
            return "00:00";
        }
        long j3 = j2 / 1000;
        int i2 = (int) (j3 % 60);
        int i3 = (int) ((j3 / 60) % 60);
        int i4 = (int) (j3 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    /* renamed from: b */
    public static Window m2554b(Context context) {
        return m2548a(context) != null ? m2548a(context).getWindow() : m2558f(context).getWindow();
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: c */
    public static void m2555c(Context context) {
        if (Jzvd.f2736q0) {
            m2554b(context).setFlags(1024, 1024);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public static void m2556d(Context context) {
        int i2 = Build.VERSION.SDK_INT >= 19 ? 5638 : 1542;
        f2873b = m2554b(context).getDecorView().getSystemUiVisibility();
        m2554b(context).getDecorView().setSystemUiVisibility(i2);
    }

    /* renamed from: e */
    public static boolean m2557e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: f */
    public static Activity m2558f(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m2558f(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: g */
    public static void m2559g(Context context) {
        if (Jzvd.f2736q0) {
            m2554b(context).clearFlags(1024);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public static void m2560h(Context context) {
        m2554b(context).getDecorView().setSystemUiVisibility(f2873b);
    }

    /* renamed from: b */
    public static long m2553b(Context context, Object obj) {
        if (!Jzvd.f2739t0) {
            return 0L;
        }
        return context.getSharedPreferences("JZVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
    }

    /* renamed from: a */
    public static AppCompatActivity m2548a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return m2548a(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: a */
    public static void m2550a(Context context, int i2) {
        if (m2548a(context) != null) {
            m2548a(context).setRequestedOrientation(i2);
        } else {
            m2558f(context).setRequestedOrientation(i2);
        }
    }

    /* renamed from: a */
    public static int m2547a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static void m2552a(Context context, Object obj, long j2) {
        if (Jzvd.f2739t0) {
            String str = "saveProgress: " + j2;
            if (j2 < C2084a.f6136r) {
                j2 = 0;
            }
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), j2).apply();
        }
    }

    /* renamed from: a */
    public static void m2551a(Context context, Object obj) {
        if (obj == null) {
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().clear().apply();
            return;
        }
        context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), 0L).apply();
    }
}
