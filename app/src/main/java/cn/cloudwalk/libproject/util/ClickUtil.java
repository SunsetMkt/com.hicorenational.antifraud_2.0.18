package cn.cloudwalk.libproject.util;

/* loaded from: classes.dex */
public class ClickUtil {
    private static final int MIN_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - lastClickTime < 1000;
        lastClickTime = currentTimeMillis;
        return z;
    }
}
