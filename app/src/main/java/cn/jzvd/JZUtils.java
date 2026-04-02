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
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class JZUtils {
    public static int SYSTEM_UI = 0;
    public static final String TAG = "JZVD";

    public static void clearSavedProgress(Context context, Object obj) {
        if (obj == null) {
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().clear().apply();
            return;
        }
        context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), 0L).apply();
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatActivity getAppCompActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return getAppCompActivity(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static long getSavedProgress(Context context, Object obj) {
        if (!Jzvd.SAVE_PROGRESS) {
            return 0L;
        }
        return context.getSharedPreferences("JZVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
    }

    public static Window getWindow(Context context) {
        return getAppCompActivity(context) != null ? getAppCompActivity(context).getWindow() : scanForActivity(context).getWindow();
    }

    @SuppressLint({"RestrictedApi"})
    public static void hideStatusBar(Context context) {
        if (Jzvd.TOOL_BAR_EXIST) {
            getWindow(context).setFlags(1024, 1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void hideSystemUI(Context context) {
        int i2 = Build.VERSION.SDK_INT >= 19 ? 5638 : 1542;
        SYSTEM_UI = getWindow(context).getDecorView().getSystemUiVisibility();
        getWindow(context).getDecorView().setSystemUiVisibility(i2);
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void saveProgress(Context context, Object obj, long j2) {
        if (Jzvd.SAVE_PROGRESS) {
            String str = "saveProgress: " + j2;
            if (j2 < com.heytap.mcssdk.constant.a.r) {
                j2 = 0;
            }
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), j2).apply();
        }
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void setRequestedOrientation(Context context, int i2) {
        if (getAppCompActivity(context) != null) {
            getAppCompActivity(context).setRequestedOrientation(i2);
        } else {
            scanForActivity(context).setRequestedOrientation(i2);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static void showStatusBar(Context context) {
        if (Jzvd.TOOL_BAR_EXIST) {
            getWindow(context).clearFlags(1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void showSystemUI(Context context) {
        getWindow(context).getDecorView().setSystemUiVisibility(SYSTEM_UI);
    }

    public static String stringForTime(long j2) {
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
}
