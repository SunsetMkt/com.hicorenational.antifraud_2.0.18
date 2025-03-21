package p388ui.statusbarcompat;

import android.app.Activity;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.android.agoo.xiaomi.MiPushRegistar;
import p388ui.Hicore;
import util.C7301n1;

/* compiled from: NotchUtils.java */
/* renamed from: ui.statusbarcompat.a */
/* loaded from: classes2.dex */
public class C7160a {

    /* renamed from: a */
    private static final String f24442a = "NotchUtils";

    /* renamed from: b */
    public static final int f24443b = 32;

    /* renamed from: c */
    public static final int f24444c = 8;

    /* renamed from: a */
    public static int m25676a(Activity activity) {
        if (!m25678b(activity)) {
            return 0;
        }
        m25674a();
        return 0;
    }

    /* renamed from: b */
    public static boolean m25678b(Activity activity) {
        return m25677a("ro.miui.notch") == 1 || m25682d() || m25683e() || m25684f() || m25681c(activity) != null;
    }

    /* renamed from: c */
    public static int m25680c() {
        int identifier = Hicore.getApp().getResources().getIdentifier("notch_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return Hicore.getApp().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: d */
    public static boolean m25682d() {
        try {
            Class<?> loadClass = Hicore.getApp().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception unused) {
            C7301n1.m26457b("", "hasNotchAtHuawei Exception");
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m25683e() {
        return Hicore.getApp().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /* renamed from: f */
    public static boolean m25684f() {
        try {
            Class<?> loadClass = Hicore.getApp().getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception unused) {
            C7301n1.m26457b("", "hasNotchAtVivo Exception");
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m25685g() {
        return "huawei".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    /* renamed from: h */
    public static boolean m25686h() {
        return "oppo".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    /* renamed from: i */
    public static boolean m25687i() {
        return "vivo".toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    /* renamed from: j */
    public static boolean m25688j() {
        return MiPushRegistar.XIAOMI.toLowerCase().equals(Build.MANUFACTURER.toLowerCase());
    }

    /* renamed from: a */
    private static int m25674a() {
        if (m25688j()) {
            return m25680c();
        }
        if (m25685g()) {
            return m25679b()[0];
        }
        if (m25686h()) {
            return 80;
        }
        if (m25687i()) {
            return m25675a(27.0f);
        }
        return 0;
    }

    /* renamed from: b */
    public static int[] m25679b() {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = Hicore.getApp().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (Exception unused) {
            C7301n1.m26457b(f24442a, "getNotchSize Exception");
            return iArr;
        }
    }

    /* renamed from: c */
    public static DisplayCutout m25681c(Activity activity) {
        WindowInsets rootWindowInsets;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    /* renamed from: a */
    public static int m25675a(float f2) {
        return (int) ((f2 * Hicore.getApp().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static int m25677a(String str) {
        if (!m25688j()) {
            return 0;
        }
        try {
            Class<?> loadClass = Hicore.getApp().getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
        } catch (Exception unused) {
            C7301n1.m26457b(f24442a, "getInt InvocationTargetException");
            return 0;
        }
    }
}
