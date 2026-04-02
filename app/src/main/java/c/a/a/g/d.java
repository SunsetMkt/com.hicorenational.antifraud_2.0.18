package c.a.a.g;

import android.os.Debug;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final int a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f1961b = 131071;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f1962c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1963d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f1964e = "liyujiang";

    public static void a(boolean z) {
        f1963d = z;
    }

    public static void b(String str) {
        a("", str);
    }

    public static boolean c() {
        return f1963d;
    }

    public static void d(String str) {
        f1964e = str;
    }

    public static void e(String str) {
        c("", str);
    }

    public static void f(String str) {
        d("", str);
    }

    public static String a() {
        return f1964e;
    }

    public static void b(Object obj, Throwable th) {
        d(obj.getClass().getSimpleName(), b(th));
    }

    public static void c(Object obj, String str) {
        c(obj.getClass().getSimpleName(), str);
    }

    public static void d(Object obj, String str) {
        d(obj.getClass().getSimpleName(), str);
    }

    public static void e() {
        if (f1963d) {
            Debug.stopMethodTracing();
        }
    }

    public static void a(Object obj, String str) {
        a(obj.getClass().getSimpleName(), str);
    }

    public static void b(Object obj, String str) {
        b(obj.getClass().getSimpleName(), str);
    }

    public static void c(String str, String str2) {
        if (f1963d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1964e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + b();
        }
    }

    public static void d(String str, String str2) {
        if (f1963d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1964e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + b();
        }
    }

    public static void a(String str, String str2) {
        if (f1963d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1964e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + b();
        }
    }

    public static void b(String str, String str2) {
        if (f1963d) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1964e);
            sb.append((str == null || str.trim().length() == 0) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(str);
            sb.toString();
            String str3 = str2 + b();
        }
    }

    public static void c(Throwable th) {
        f(b(th));
    }

    public static void d() {
        if (f1963d) {
            Debug.startMethodTracing(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + f1964e + ".trace");
        }
    }

    public static void a(Throwable th) {
        c(b(th));
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        if (string.length() > f1961b) {
            string = string.substring(0, 131047) + " [stack trace too large]";
        }
        printWriter.close();
        return string;
    }

    public static void c(String str) {
        b("", str);
    }

    public static void a(Object obj, Throwable th) {
        b(obj.getClass().getSimpleName(), b(th));
    }

    private static int a(StackTraceElement[] stackTraceElementArr) {
        for (int i2 = 3; i2 < stackTraceElementArr.length; i2++) {
            if (!stackTraceElementArr[i2].getClassName().equals(d.class.getName())) {
                return i2 - 1;
            }
        }
        return -1;
    }

    private static String a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private static String b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int iA = a(stackTrace);
            StringBuilder sb = new StringBuilder();
            String str = "    ";
            for (int length = iA + 2 > stackTrace.length ? (stackTrace.length - iA) - 1 : 2; length > 0; length--) {
                int i2 = length + iA;
                if (i2 < stackTrace.length) {
                    sb.append("\n");
                    sb.append(str);
                    sb.append(a(stackTrace[i2].getClassName()));
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append(d.c.a.b.a.a.f10074g);
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
