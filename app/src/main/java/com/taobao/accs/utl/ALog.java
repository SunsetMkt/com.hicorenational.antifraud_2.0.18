package com.taobao.accs.utl;

import com.xiaomi.mipush.sdk.Constants;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ALog {
    public static volatile boolean isPrintLog = true;
    private static final String preTag = "NAccs.";
    private static volatile ILog sLog;

    /* compiled from: Taobao */
    public interface ILog {
        /* renamed from: d */
        void m9187d(String str, String str2);

        /* renamed from: e */
        void m9188e(String str, String str2);

        /* renamed from: e */
        void m9189e(String str, String str2, Throwable th);

        /* renamed from: i */
        void m9190i(String str, String str2);

        boolean isPrintLog(int i2);

        boolean isValid();

        void setLogLevel(int i2);

        /* renamed from: w */
        void m9191w(String str, String str2);

        /* renamed from: w */
        void m9192w(String str, String str2, Throwable th);
    }

    /* compiled from: Taobao */
    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(AbstractC1191a.f2568g);
            sb.append(str);
        }
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(AbstractC1191a.f2568g);
                sb.append(formatKv(objArr[i2], objArr[i3]));
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(AbstractC1191a.f2568g);
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return preTag + str;
    }

    /* renamed from: d */
    public static void m9180d(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9187d(buildLogTag, buildLogMsg);
            }
        }
    }

    /* renamed from: e */
    public static void m9182e(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9188e(buildLogTag, buildLogMsg);
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(Constants.COLON_SEPARATOR);
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    /* renamed from: i */
    public static void m9183i(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9190i(buildLogTag, buildLogMsg);
            }
        }
    }

    public static boolean isPrintLog() {
        ILog iLog = sLog;
        return iLog != null ? iLog.isPrintLog(4) : isPrintLog;
    }

    public static void setLog(ILog iLog) {
        if (iLog == null || !iLog.isValid()) {
            return;
        }
        sLog = iLog;
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    /* renamed from: v */
    public static void m9184v(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    /* renamed from: w */
    public static void m9186w(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9191w(buildLogTag, buildLogMsg);
            }
        }
    }

    public static boolean isPrintLog(Level level) {
        ILog iLog = sLog;
        if (iLog != null) {
            return iLog.isPrintLog(4);
        }
        return isPrintLog;
    }

    /* renamed from: e */
    public static void m9181e(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9189e(buildLogTag, buildLogMsg, th);
            }
        }
    }

    /* renamed from: w */
    public static void m9185w(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.m9192w(buildLogTag, buildLogMsg, th);
            }
        }
    }
}
