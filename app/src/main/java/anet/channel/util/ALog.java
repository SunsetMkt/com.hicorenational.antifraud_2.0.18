package anet.channel.util;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ALog {
    public static Logcat logcat = new Logcat();
    private static volatile ILog log = logcat;
    private static Object LOG_BREAK = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
    private static boolean isPrintLog = true;
    private static boolean canUseTlog = true;

    /* compiled from: Taobao */
    public interface ILog {
        /* renamed from: d */
        void mo456d(String str, String str2);

        /* renamed from: e */
        void mo457e(String str, String str2);

        /* renamed from: e */
        void mo458e(String str, String str2, Throwable th);

        /* renamed from: i */
        void mo459i(String str, String str2);

        boolean isPrintLog(int i2);

        boolean isValid();

        void setLogLevel(int i2);

        /* renamed from: w */
        void mo460w(String str, String str2);

        /* renamed from: w */
        void mo461w(String str, String str2, Throwable th);
    }

    /* compiled from: Taobao */
    public static class Level {

        /* renamed from: D */
        public static final int f1163D = 1;

        /* renamed from: E */
        public static final int f1164E = 4;

        /* renamed from: I */
        public static final int f1165I = 2;

        /* renamed from: N */
        public static final int f1166N = 5;

        /* renamed from: V */
        public static final int f1167V = 0;

        /* renamed from: W */
        public static final int f1168W = 3;
    }

    /* compiled from: Taobao */
    public static class Logcat implements ILog {
        int defaultLevel = 1;

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: d */
        public void mo456d(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: e */
        public void mo457e(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: e */
        public void mo458e(String str, String str2, Throwable th) {
        }

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: i */
        public void mo459i(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isPrintLog(int i2) {
            return i2 >= this.defaultLevel;
        }

        @Override // anet.channel.util.ALog.ILog
        public boolean isValid() {
            return true;
        }

        @Override // anet.channel.util.ALog.ILog
        public void setLogLevel(int i2) {
            if (i2 < 0 || i2 > 5) {
                this.defaultLevel = 5;
            } else {
                this.defaultLevel = i2;
            }
        }

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: w */
        public void mo460w(String str, String str2) {
        }

        @Override // anet.channel.util.ALog.ILog
        /* renamed from: w */
        public void mo461w(String str, String str2, Throwable th) {
        }
    }

    private static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(LOG_BREAK);
            sb.append("[seq:");
            sb.append(str2);
            sb.append("]");
        }
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
                sb.append(objArr[i2] != null ? objArr[i2] : "");
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(objArr[i3] != null ? objArr[i3] : "");
                i2 += 2;
            }
            if (i2 < objArr.length) {
                sb.append(AbstractC1191a.f2568g);
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return str;
    }

    /* renamed from: d */
    public static void m713d(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(1) || log == null) {
            return;
        }
        log.mo456d(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    /* renamed from: e */
    public static void m715e(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(4) || log == null) {
            return;
        }
        log.mo457e(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static ILog getLog() {
        return log;
    }

    /* renamed from: i */
    public static void m716i(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(2) || log == null) {
            return;
        }
        log.mo459i(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    public static boolean isPrintLog(int i2) {
        if (isPrintLog && log != null) {
            return log.isPrintLog(i2);
        }
        return false;
    }

    public static void setLevel(int i2) {
        if (log != null) {
            log.setLogLevel(i2);
        }
    }

    public static void setLog(ILog iLog) {
        if (iLog == null) {
            return;
        }
        if ((canUseTlog || !iLog.getClass().getSimpleName().toLowerCase().contains("tlog")) && iLog.isValid()) {
            log = iLog;
        }
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    @Deprecated
    public static void setUseTlog(boolean z) {
        if (z) {
            canUseTlog = true;
        } else {
            canUseTlog = false;
            log = logcat;
        }
    }

    /* renamed from: w */
    public static void m718w(String str, String str2, String str3, Object... objArr) {
        if (!isPrintLog(3) || log == null) {
            return;
        }
        log.mo460w(buildLogTag(str), buildLogMsg(str2, str3, objArr));
    }

    /* renamed from: e */
    public static void m714e(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(4) || log == null) {
            return;
        }
        log.mo458e(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
    }

    /* renamed from: w */
    public static void m717w(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (!isPrintLog(3) || log == null) {
            return;
        }
        log.mo461w(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
    }
}
