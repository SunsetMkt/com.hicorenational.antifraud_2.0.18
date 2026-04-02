package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private static int a = 2;

    /* JADX INFO: renamed from: a */
    private static Context f66a = null;

    /* JADX INFO: renamed from: a */
    private static boolean f72a = false;

    /* JADX INFO: renamed from: b */
    private static boolean f73b = false;

    /* JADX INFO: renamed from: a */
    private static String f69a = "XMPush-" + Process.myPid();

    /* JADX INFO: renamed from: a */
    private static LoggerInterface f67a = new a();

    /* JADX INFO: renamed from: a */
    private static final HashMap<Integer, Long> f70a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private static final HashMap<Integer, String> f8707b = new HashMap<>();

    /* JADX INFO: renamed from: a */
    private static final Integer f68a = -1;

    /* JADX INFO: renamed from: a */
    private static AtomicInteger f71a = new AtomicInteger(1);

    static class a implements LoggerInterface {
        private String a = b.f69a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m51a() {
        return false;
    }

    public static void b(String str) {
        if (m52a(0)) {
            a(0, m47a(str));
        }
    }

    public static void c(String str) {
        if (m52a(0)) {
            a(1, m47a(str));
        }
    }

    public static void d(String str) {
        if (m52a(4)) {
            a(4, m47a(str));
        }
    }

    public static void e(String str) {
        if (f72a) {
            m48a(str);
            return;
        }
        m47a(str);
        if (f73b) {
            return;
        }
        m48a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        f67a = loggerInterface;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m52a(int i2) {
        return i2 >= a || m51a();
    }

    /* JADX INFO: renamed from: b */
    public static void m53b(String str, String str2) {
        if (m52a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (m52a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f72a) {
            m49a(str, str2);
            return;
        }
        b(str, str2);
        if (f73b) {
            return;
        }
        m49a(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m48a(String str) {
        if (m52a(2)) {
            a(2, m47a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m52a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m49a(String str, String str2) {
        if (m52a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m50a(String str, Object... objArr) {
        if (m52a(2)) {
            a(2, a(str, objArr));
        }
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void a(String str, Throwable th) {
        if (m52a(4)) {
            a(4, m47a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m52a(4)) {
            a(4, th);
        }
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer numValueOf = Integer.valueOf(f71a.incrementAndGet());
            f70a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            f8707b.put(numValueOf, str);
            f67a.log(str + " starts");
            return numValueOf;
        }
        return f68a;
    }

    public static void a(Integer num) {
        if (a > 1 || !f70a.containsKey(num)) {
            return;
        }
        long jLongValue = f70a.remove(num).longValue();
        String strRemove = f8707b.remove(num);
        long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
        f67a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
    }

    public static void a(int i2, String str) {
        if (i2 >= a) {
            f67a.log(str);
            return;
        }
        if (m51a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    public static void a(int i2, Throwable th) {
        if (i2 >= a) {
            f67a.log("", th);
            return;
        }
        if (m51a()) {
            String str = "-->log(" + i2 + "): ";
        }
    }

    public static void a(int i2, String str, Throwable th) {
        if (i2 >= a) {
            f67a.log(str, th);
            return;
        }
        if (m51a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m47a(String str) {
        return b() + str;
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 5) {
            a(2, "set log level as " + i2);
        }
        a = i2;
    }

    public static int a() {
        return a;
    }

    public static void a(Context context) {
        f66a = context;
        if (j.m625a(context)) {
            f72a = true;
        }
        if (j.m624a()) {
            f73b = true;
        }
    }
}
