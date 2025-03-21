package com.luck.picture.lib.tools;

/* loaded from: classes.dex */
public class DoubleUtils {
    private static long TIME = 800;
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        TIME = 800L;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - lastClickTime;
        if (j2 < TIME && j2 > 0) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static boolean isFastDoubleClick(int i2) {
        TIME = i2;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = lastClickTime;
        long j3 = currentTimeMillis - j2;
        if (currentTimeMillis - j2 < TIME && j3 > 0) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }
}
