package cn.cloudwalk.util;

/* JADX INFO: loaded from: classes.dex */
public class TestLog {
    public static int frame = 0;
    public static boolean isDebug = false;
    public static int sfFrame;
    private static long startTime;

    public static void logSf() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - startTime >= 1000) {
            startTime = System.currentTimeMillis();
            netE("TestLog", "\u6bcf\u79d2:" + frame + "\u7b97\u6cd5:" + sfFrame);
            frame = 0;
            sfFrame = 0;
        }
    }

    public static void netE(String str, String str2) {
    }

    public static void netd(String str, String str2) {
    }

    public static void setIsDebug(boolean z) {
        isDebug = z;
    }
}
