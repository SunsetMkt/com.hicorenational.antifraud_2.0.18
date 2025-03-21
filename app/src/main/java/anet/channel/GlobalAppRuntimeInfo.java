package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.fulltrace.C0785a;
import anet.channel.fulltrace.C0786b;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GlobalAppRuntimeInfo {

    /* renamed from: a */
    private static Context f670a;

    /* renamed from: e */
    private static String f674e;

    /* renamed from: f */
    private static String f675f;

    /* renamed from: g */
    private static String f676g;

    /* renamed from: k */
    private static volatile long f680k;

    /* renamed from: l */
    private static String f681l;

    /* renamed from: b */
    private static ENV f671b = ENV.ONLINE;

    /* renamed from: c */
    private static String f672c = "";

    /* renamed from: d */
    private static String f673d = "";

    /* renamed from: h */
    private static volatile boolean f677h = true;

    /* renamed from: i */
    private static SharedPreferences f678i = null;

    /* renamed from: j */
    private static volatile CopyOnWriteArrayList<String> f679j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (f679j == null) {
                f679j = new CopyOnWriteArrayList<>();
            }
            f679j.add(str);
            f679j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f679j;
    }

    public static Context getContext() {
        return f670a;
    }

    public static String getCurrentProcess() {
        return f673d;
    }

    public static ENV getEnv() {
        return f671b;
    }

    @Deprecated
    public static long getInitTime() {
        return f680k;
    }

    @Deprecated
    public static int getStartType() {
        C0786b sceneInfo = C0785a.m516a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f852a;
        }
        return -1;
    }

    public static String getTtid() {
        return f674e;
    }

    public static String getUserId() {
        return f675f;
    }

    public static String getUtdid() {
        Context context;
        if (f676g == null && (context = f670a) != null) {
            f676g = Utils.getDeviceId(context);
        }
        return f676g;
    }

    public static boolean isAppBackground() {
        if (f670a == null) {
            return true;
        }
        return f677h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f672c) || TextUtils.isEmpty(f673d)) {
            return true;
        }
        return f672c.equalsIgnoreCase(f673d);
    }

    public static void setBackground(boolean z) {
        f677h = z;
    }

    public static void setContext(Context context) {
        f670a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f673d)) {
                f673d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f672c)) {
                f672c = Utils.getMainProcessName(context);
            }
            if (f678i == null) {
                f678i = PreferenceManager.getDefaultSharedPreferences(context);
                f675f = f678i.getString("UserId", null);
            }
            ALog.m715e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f673d, "TargetProcess", f672c);
        }
    }

    public static void setCurrentProcess(String str) {
        f673d = str;
    }

    public static void setEnv(ENV env) {
        f671b = env;
    }

    @Deprecated
    public static void setInitTime(long j2) {
        f680k = j2;
    }

    public static void setTargetProcess(String str) {
        f672c = str;
    }

    public static void setTtid(String str) {
        f674e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int indexOf = str.indexOf("@");
            String str2 = null;
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            String substring2 = str.substring(indexOf + 1);
            int lastIndexOf = substring2.lastIndexOf(AbstractC1191a.f2606s1);
            if (lastIndexOf != -1) {
                String substring3 = substring2.substring(0, lastIndexOf);
                str2 = substring2.substring(lastIndexOf + 1);
                substring2 = substring3;
            }
            f681l = str2;
            AmdcRuntimeInfo.setAppInfo(substring2, str2, substring);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f675f;
        if (str2 == null || !str2.equals(str)) {
            f675f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f678i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f676g;
        if (str2 == null || !str2.equals(str)) {
            f676g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f672c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f672c.equalsIgnoreCase(str);
    }
}
