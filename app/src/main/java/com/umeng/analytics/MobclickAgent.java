package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3409j;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MobclickAgent {

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);


        /* renamed from: a */
        private int f11360a;

        EScenarioType(int i2) {
            this.f11360a = i2;
        }

        public int toValue() {
            return this.f11360a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().m10781g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        C3310b.m10736a().m10762a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    @Deprecated
    public static void enableEncrypt(boolean z) {
    }

    public static C3310b getAgent() {
        return C3310b.m10736a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().m10782h(context);
    }

    private static void init(Context context) {
        C3310b.m10736a().m10744a(context);
    }

    public static void onEvent(Context context, String str) {
        C3310b.m10736a().m10749a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.m11549aq(C3409j.f12094a, 0, "\\|");
        } else {
            C3310b.m10736a().m10752a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i2) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("__ct__", Integer.valueOf(i2));
        C3310b.m10736a().m10752a(context, str, hashMap, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        C3310b.m10736a().m10750a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        C3310b.m10736a().m10772d(context);
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.m11549aq(C3409j.f12071D, 0, "\\|");
        } else {
            C3310b.m10736a().m10767b(str);
        }
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.m11549aq(C3409j.f12070C, 0, "\\|");
        } else {
            C3310b.m10736a().m10758a(str);
        }
    }

    public static void onPause(Context context) {
        C3310b.m10736a().m10769c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        C3310b.m10736a().m10785j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12125n, 0, "\\|");
        } else {
            C3310b.m10736a().m10764b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().m10755a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, str, "DEFAULT");
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        C3310b.m10736a().m10762a(z);
    }

    @Deprecated
    public static void setCheckDevice(boolean z) {
    }

    @Deprecated
    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().m10754a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        C3310b.m10736a().m10746a(context, EScenarioType.E_UM_GAME);
    }

    @Deprecated
    public static void setLatencyWindow(long j2) {
    }

    public static void setLocation(double d2, double d3) {
        C3310b.m10736a().m10742a(d2, d3);
    }

    public static void setOpenGLContext(GL10 gl10) {
        C3310b.m10736a().m10761a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    @Deprecated
    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        C3310b.m10736a().m10770c(context, str);
    }

    public static void setSessionContinueMillis(long j2) {
        if (j2 <= 30000) {
            j2 = 30000;
        }
        C3310b.m10736a().m10743a(j2);
    }

    private static void setSysListener(ISysListener iSysListener) {
        C3310b.m10736a().m10756a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().m10779f(context, str);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.m11549aq(C3409j.f12122k, 0, "\\|");
        } else {
            C3310b.m10736a().m10749a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.m11549aq(C3409j.f12131t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.m11549aq(C3409j.f12132u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C3310b.m10736a().m10759a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.m11549aq(C3409j.f12133v, 0, "\\|");
        } else {
            C3310b.m10736a().m10759a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.m11549aq(C3409j.f12094a, 0, "\\|");
        } else {
            C3310b.m10736a().m10752a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, th, "DEFAULT");
        } catch (Throwable unused) {
        }
    }
}
