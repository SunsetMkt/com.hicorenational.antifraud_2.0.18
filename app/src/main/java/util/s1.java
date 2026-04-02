package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: LogUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class s1 {
    private static final String a = "LogUtil";

    /* JADX INFO: renamed from: b */
    public static String f15073b = "MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: c */
    private static String f15074c = "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3_log_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + d.c.a.b.a.a.s1;

    /* JADX INFO: renamed from: d */
    public static StringBuilder f15075d = new StringBuilder();

    public static void a(String str) {
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Exception exc) {
    }

    public static void b(String str) {
    }

    public static void b(String str, String str2) {
    }

    public static String c(String str) {
        try {
            return new SimpleDateFormat(str).format(new GregorianCalendar().getTime());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str) {
    }

    public static synchronized void d(String str, String str2) {
    }

    public static void e(String str) {
    }

    public static void e(String str, String str2) {
    }

    public static void f(String str) {
    }

    public static void f(String str, String str2) {
    }
}
