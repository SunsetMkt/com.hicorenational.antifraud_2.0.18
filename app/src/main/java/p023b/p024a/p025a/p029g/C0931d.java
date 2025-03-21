package p023b.p024a.p025a.p029g;

import android.os.Debug;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: LogUtils.java */
/* renamed from: b.a.a.g.d */
/* loaded from: classes.dex */
public final class C0931d {

    /* renamed from: a */
    private static final int f1565a = 3;

    /* renamed from: b */
    private static final int f1566b = 131071;

    /* renamed from: c */
    private static final int f1567c = 2;

    /* renamed from: d */
    private static boolean f1568d = false;

    /* renamed from: e */
    private static String f1569e = "liyujiang";

    /* renamed from: a */
    public static void m1149a(boolean z) {
        f1568d = z;
    }

    /* renamed from: b */
    public static void m1154b(String str) {
        m1147a("", str);
    }

    /* renamed from: c */
    public static boolean m1160c() {
        return f1568d;
    }

    /* renamed from: d */
    public static void m1163d(String str) {
        f1569e = str;
    }

    /* renamed from: e */
    public static void m1166e(String str) {
        m1158c("", str);
    }

    /* renamed from: f */
    public static void m1167f(String str) {
        m1164d("", str);
    }

    /* renamed from: a */
    public static String m1143a() {
        return f1569e;
    }

    /* renamed from: b */
    public static void m1153b(Object obj, Throwable th) {
        m1164d(obj.getClass().getSimpleName(), m1151b(th));
    }

    /* renamed from: c */
    public static void m1156c(Object obj, String str) {
        m1158c(obj.getClass().getSimpleName(), str);
    }

    /* renamed from: d */
    public static void m1162d(Object obj, String str) {
        m1164d(obj.getClass().getSimpleName(), str);
    }

    /* renamed from: e */
    public static void m1165e() {
        if (f1568d) {
            Debug.stopMethodTracing();
        }
    }

    /* renamed from: a */
    public static void m1145a(Object obj, String str) {
        m1147a(obj.getClass().getSimpleName(), str);
    }

    /* renamed from: b */
    public static void m1152b(Object obj, String str) {
        m1155b(obj.getClass().getSimpleName(), str);
    }

    /* renamed from: c */
    public static void m1158c(String str, String str2) {
        if (f1568d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1569e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + m1150b();
        }
    }

    /* renamed from: d */
    public static void m1164d(String str, String str2) {
        if (f1568d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1569e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + m1150b();
        }
    }

    /* renamed from: a */
    public static void m1147a(String str, String str2) {
        if (f1568d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1569e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + m1150b();
        }
    }

    /* renamed from: b */
    public static void m1155b(String str, String str2) {
        if (f1568d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1569e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + m1150b();
        }
    }

    /* renamed from: c */
    public static void m1159c(Throwable th) {
        m1167f(m1151b(th));
    }

    /* renamed from: d */
    public static void m1161d() {
        if (f1568d) {
            Debug.startMethodTracing(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + f1569e + ".trace");
        }
    }

    /* renamed from: a */
    public static void m1148a(Throwable th) {
        m1157c(m1151b(th));
    }

    /* renamed from: b */
    public static String m1151b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        if (stringWriter2.length() > f1566b) {
            stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
        }
        printWriter.close();
        return stringWriter2;
    }

    /* renamed from: c */
    public static void m1157c(String str) {
        m1155b("", str);
    }

    /* renamed from: a */
    public static void m1146a(Object obj, Throwable th) {
        m1155b(obj.getClass().getSimpleName(), m1151b(th));
    }

    /* renamed from: a */
    private static int m1142a(StackTraceElement[] stackTraceElementArr) {
        for (int i2 = 3; i2 < stackTraceElementArr.length; i2++) {
            if (!stackTraceElementArr[i2].getClassName().equals(C0931d.class.getName())) {
                return i2 - 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static String m1144a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: b */
    private static String m1150b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int m1142a = m1142a(stackTrace);
            StringBuilder sb = new StringBuilder();
            String str = "    ";
            for (int length = m1142a + 2 > stackTrace.length ? (stackTrace.length - m1142a) - 1 : 2; length > 0; length--) {
                int i2 = length + m1142a;
                if (i2 < stackTrace.length) {
                    sb.append("\n");
                    sb.append(str);
                    sb.append(m1144a(stackTrace[i2].getClassName()));
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append(AbstractC1191a.f2568g);
                    sb.append("(");
                    sb.append(stackTrace[i2].getFileName());
                    sb.append(Constants.COLON_SEPARATOR);
                    sb.append(stackTrace[i2].getLineNumber());
                    sb.append(")");
                    str = str + "    ";
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
