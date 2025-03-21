package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TinkerLogger implements TinkerLog.TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String TAG = "Tinker.TinkerLogger";
    private static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i2) {
        level = i2;
        String str = "new log level: " + i2;
    }

    /* renamed from: d */
    public void m9345d(String str, String str2, Object... objArr) {
        if (level > 1 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: e */
    public void m9346e(String str, String str2, Object... objArr) {
        if (level > 4 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: i */
    public void m9347i(String str, String str2, Object... objArr) {
        if (level > 2 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2 + "  " + Log.getStackTraceString(th);
    }

    /* renamed from: v */
    public void m9348v(String str, String str2, Object... objArr) {
        if (level > 0 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }

    /* renamed from: w */
    public void m9349w(String str, String str2, Object... objArr) {
        if (level > 3 || objArr == null) {
            return;
        }
        String.format(str2, objArr);
    }
}
