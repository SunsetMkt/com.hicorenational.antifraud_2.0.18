package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.xiaomi.push.C4300j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.channel.commonutils.logger.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4022b {

    /* renamed from: a */
    private static int f14299a = 2;

    /* renamed from: a */
    private static Context f14300a = null;

    /* renamed from: a */
    private static boolean f14306a = false;

    /* renamed from: b */
    private static boolean f14308b = false;

    /* renamed from: a */
    private static String f14303a = "XMPush-" + Process.myPid();

    /* renamed from: a */
    private static LoggerInterface f14301a = new a();

    /* renamed from: a */
    private static final HashMap<Integer, Long> f14304a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<Integer, String> f14307b = new HashMap<>();

    /* renamed from: a */
    private static final Integer f14302a = -1;

    /* renamed from: a */
    private static AtomicInteger f14305a = new AtomicInteger(1);

    /* renamed from: com.xiaomi.channel.commonutils.logger.b$a */
    static class a implements LoggerInterface {

        /* renamed from: a */
        private String f14309a = AbstractC4022b.f14303a;

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
            this.f14309a = str;
        }
    }

    /* renamed from: a */
    private static boolean m13352a() {
        return false;
    }

    /* renamed from: b */
    public static void m13356b(String str) {
        if (m13353a(0)) {
            m13341a(0, m13337a(str));
        }
    }

    /* renamed from: c */
    public static void m13359c(String str) {
        if (m13353a(0)) {
            m13341a(1, m13337a(str));
        }
    }

    /* renamed from: d */
    public static void m13361d(String str) {
        if (m13353a(4)) {
            m13341a(4, m13337a(str));
        }
    }

    /* renamed from: e */
    public static void m13363e(String str) {
        if (f14306a) {
            m13347a(str);
            return;
        }
        m13337a(str);
        if (f14308b) {
            return;
        }
        m13347a(str);
    }

    /* renamed from: a */
    public static void m13345a(LoggerInterface loggerInterface) {
        f14301a = loggerInterface;
    }

    /* renamed from: a */
    private static boolean m13353a(int i2) {
        return i2 >= f14299a || m13352a();
    }

    /* renamed from: b */
    public static void m13357b(String str, String str2) {
        if (m13353a(1)) {
            m13341a(1, m13355b(str, str2));
        }
    }

    /* renamed from: c */
    public static void m13360c(String str, String str2) {
        if (m13353a(4)) {
            m13341a(4, m13355b(str, str2));
        }
    }

    /* renamed from: d */
    public static void m13362d(String str, String str2) {
        if (f14306a) {
            m13348a(str, str2);
            return;
        }
        m13355b(str, str2);
        if (f14308b) {
            return;
        }
        m13348a(str, str2);
    }

    /* renamed from: a */
    public static void m13347a(String str) {
        if (m13353a(2)) {
            m13341a(2, m13337a(str));
        }
    }

    /* renamed from: b */
    public static void m13358b(String str, Object... objArr) {
        if (m13353a(1)) {
            m13341a(1, m13339a(str, objArr));
        }
    }

    /* renamed from: a */
    public static void m13348a(String str, String str2) {
        if (m13353a(2)) {
            m13341a(2, m13355b(str, str2));
        }
    }

    /* renamed from: b */
    private static String m13355b(String str, String str2) {
        return m13354b() + m13338a(str, str2);
    }

    /* renamed from: a */
    public static void m13350a(String str, Object... objArr) {
        if (m13353a(2)) {
            m13341a(2, m13339a(str, objArr));
        }
    }

    /* renamed from: b */
    private static String m13354b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* renamed from: a */
    public static void m13349a(String str, Throwable th) {
        if (m13353a(4)) {
            m13342a(4, m13337a(str), th);
        }
    }

    /* renamed from: a */
    public static void m13351a(Throwable th) {
        if (m13353a(4)) {
            m13343a(4, th);
        }
    }

    /* renamed from: a */
    public static Integer m13335a(String str) {
        if (f14299a <= 1) {
            Integer valueOf = Integer.valueOf(f14305a.incrementAndGet());
            f14304a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f14307b.put(valueOf, str);
            f14301a.log(str + " starts");
            return valueOf;
        }
        return f14302a;
    }

    /* renamed from: a */
    public static void m13346a(Integer num) {
        if (f14299a > 1 || !f14304a.containsKey(num)) {
            return;
        }
        long longValue = f14304a.remove(num).longValue();
        String remove = f14307b.remove(num);
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        f14301a.log(remove + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a */
    public static void m13341a(int i2, String str) {
        if (i2 >= f14299a) {
            f14301a.log(str);
            return;
        }
        if (m13352a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    /* renamed from: a */
    public static void m13343a(int i2, Throwable th) {
        if (i2 >= f14299a) {
            f14301a.log("", th);
            return;
        }
        if (m13352a()) {
            String str = "-->log(" + i2 + "): ";
        }
    }

    /* renamed from: a */
    public static void m13342a(int i2, String str, Throwable th) {
        if (i2 >= f14299a) {
            f14301a.log(str, th);
            return;
        }
        if (m13352a()) {
            String str2 = "-->log(" + i2 + "): " + str;
        }
    }

    /* renamed from: a */
    private static String m13337a(String str) {
        return m13354b() + str;
    }

    /* renamed from: a */
    private static String m13339a(String str, Object... objArr) {
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

    /* renamed from: a */
    public static String m13338a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    /* renamed from: a */
    public static void m13340a(int i2) {
        if (i2 < 0 || i2 > 5) {
            m13341a(2, "set log level as " + i2);
        }
        f14299a = i2;
    }

    /* renamed from: a */
    public static int m13334a() {
        return f14299a;
    }

    /* renamed from: a */
    public static void m13344a(Context context) {
        f14300a = context;
        if (C4300j.m15681a(context)) {
            f14306a = true;
        }
        if (C4300j.m15680a()) {
            f14308b = true;
        }
    }
}
