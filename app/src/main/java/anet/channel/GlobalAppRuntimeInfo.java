package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class GlobalAppRuntimeInfo {
    private static Context a;

    /* JADX INFO: renamed from: e */
    private static String f1336e;

    /* JADX INFO: renamed from: f */
    private static String f1337f;

    /* JADX INFO: renamed from: g */
    private static String f1338g;

    /* JADX INFO: renamed from: k */
    private static volatile long f1342k;

    /* JADX INFO: renamed from: l */
    private static String f1343l;

    /* JADX INFO: renamed from: b */
    private static ENV f1333b = ENV.ONLINE;

    /* JADX INFO: renamed from: c */
    private static String f1334c = "";

    /* JADX INFO: renamed from: d */
    private static String f1335d = "";

    /* JADX INFO: renamed from: h */
    private static volatile boolean f1339h = true;

    /* JADX INFO: renamed from: i */
    private static SharedPreferences f1340i = null;

    /* JADX INFO: renamed from: j */
    private static volatile CopyOnWriteArrayList<String> f1341j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (f1341j == null) {
                f1341j = new CopyOnWriteArrayList<>();
            }
            f1341j.add(str);
            f1341j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f1341j;
    }

    public static Context getContext() {
        return a;
    }

    public static String getCurrentProcess() {
        return f1335d;
    }

    public static ENV getEnv() {
        return f1333b;
    }

    @Deprecated
    public static long getInitTime() {
        return f1342k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.a;
        }
        return -1;
    }

    public static String getTtid() {
        return f1336e;
    }

    public static String getUserId() {
        return f1337f;
    }

    public static String getUtdid() {
        Context context;
        if (f1338g == null && (context = a) != null) {
            f1338g = Utils.getDeviceId(context);
        }
        return f1338g;
    }

    public static boolean isAppBackground() {
        if (a == null) {
            return true;
        }
        return f1339h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f1334c) || TextUtils.isEmpty(f1335d)) {
            return true;
        }
        return f1334c.equalsIgnoreCase(f1335d);
    }

    public static void setBackground(boolean z) {
        f1339h = z;
    }

    public static void setContext(Context context) {
        a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f1335d)) {
                f1335d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f1334c)) {
                f1334c = Utils.getMainProcessName(context);
            }
            if (f1340i == null) {
                f1340i = PreferenceManager.getDefaultSharedPreferences(context);
                f1337f = f1340i.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f1335d, "TargetProcess", f1334c);
        }
    }

    public static void setCurrentProcess(String str) {
        f1335d = str;
    }

    public static void setEnv(ENV env) {
        f1333b = env;
    }

    @Deprecated
    public static void setInitTime(long j2) {
        f1342k = j2;
    }

    public static void setTargetProcess(String str) {
        f1334c = str;
    }

    public static void setTtid(String str) {
        f1336e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIndexOf = str.indexOf("@");
            String strSubstring = null;
            String strSubstring2 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            String strSubstring3 = str.substring(iIndexOf + 1);
            int iLastIndexOf = strSubstring3.lastIndexOf(d.c.a.b.a.a.s1);
            if (iLastIndexOf != -1) {
                String strSubstring4 = strSubstring3.substring(0, iLastIndexOf);
                strSubstring = strSubstring3.substring(iLastIndexOf + 1);
                strSubstring3 = strSubstring4;
            }
            f1343l = strSubstring;
            AmdcRuntimeInfo.setAppInfo(strSubstring3, strSubstring, strSubstring2);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f1337f;
        if (str2 == null || !str2.equals(str)) {
            f1337f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f1340i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f1338g;
        if (str2 == null || !str2.equals(str)) {
            f1338g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f1334c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f1334c.equalsIgnoreCase(str);
    }
}
