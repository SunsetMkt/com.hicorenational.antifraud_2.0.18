package cn.cloudwalk.libproject.util;

/* JADX INFO: loaded from: classes.dex */
public class TimeUtil {
    static long startTime;

    public static long timeSpanEnd() {
        return System.currentTimeMillis() - startTime;
    }

    public static void timeSpanStart() {
        startTime = System.currentTimeMillis();
    }
}
