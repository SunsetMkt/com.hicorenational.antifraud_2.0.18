package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: LogUtil.java */
/* renamed from: util.n1 */
/* loaded from: classes2.dex */
public class C7301n1 {

    /* renamed from: a */
    private static final String f25479a = "LogUtil";

    /* renamed from: b */
    public static String f25480b = "MM-dd HH:mm:ss";

    /* renamed from: c */
    private static String f25481c = "国家反诈中心_log_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + AbstractC1191a.f2606s1;

    /* renamed from: d */
    public static StringBuilder f25482d = new StringBuilder();

    /* renamed from: a */
    public static void m26453a(String str) {
    }

    /* renamed from: a */
    public static void m26454a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m26455a(String str, String str2, Exception exc) {
    }

    /* renamed from: b */
    public static void m26456b(String str) {
    }

    /* renamed from: b */
    public static void m26457b(String str, String str2) {
    }

    /* renamed from: c */
    public static String m26458c(String str) {
        try {
            return new SimpleDateFormat(str).format(new GregorianCalendar().getTime());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static void m26459c(String str, String str2) {
    }

    /* renamed from: d */
    public static void m26460d(String str) {
    }

    /* renamed from: d */
    public static synchronized void m26461d(String str, String str2) {
        synchronized (C7301n1.class) {
        }
    }

    /* renamed from: e */
    public static void m26462e(String str) {
    }

    /* renamed from: e */
    public static void m26463e(String str, String str2) {
    }

    /* renamed from: f */
    public static void m26464f(String str) {
    }

    /* renamed from: f */
    public static void m26465f(String str, String str2) {
    }
}
