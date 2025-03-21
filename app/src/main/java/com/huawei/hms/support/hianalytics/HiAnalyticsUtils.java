package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.C2507a;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HiAnalyticsUtils {

    /* renamed from: c */
    private static final Object f7862c = new Object();

    /* renamed from: d */
    private static final Object f7863d = new Object();

    /* renamed from: e */
    private static HiAnalyticsUtils f7864e;

    /* renamed from: a */
    private int f7865a = 0;

    /* renamed from: b */
    private final boolean f7866b = HianalyticsExist.isHianalyticsExist();

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$a */
    class RunnableC2524a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7867a;

        /* renamed from: b */
        final /* synthetic */ String f7868b;

        /* renamed from: c */
        final /* synthetic */ Map f7869c;

        RunnableC2524a(Context context, String str, Map map) {
            this.f7867a = context;
            this.f7868b = str;
            this.f7869c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent(this.f7867a, this.f7868b, this.f7869c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$b */
    class RunnableC2525b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7871a;

        /* renamed from: b */
        final /* synthetic */ String f7872b;

        /* renamed from: c */
        final /* synthetic */ String f7873c;

        RunnableC2525b(Context context, String str, String str2) {
            this.f7871a = context;
            this.f7872b = str;
            this.f7873c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f7871a, this.f7872b, this.f7873c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$c */
    class RunnableC2526c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7875a;

        /* renamed from: b */
        final /* synthetic */ String f7876b;

        /* renamed from: c */
        final /* synthetic */ Map f7877c;

        RunnableC2526c(Context context, String str, Map map) {
            this.f7875a = context;
            this.f7876b = str;
            this.f7877c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f7875a, this.f7876b, this.f7877c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$d */
    class RunnableC2527d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7879a;

        /* renamed from: b */
        final /* synthetic */ String f7880b;

        /* renamed from: c */
        final /* synthetic */ Map f7881c;

        /* renamed from: d */
        final /* synthetic */ int f7882d;

        RunnableC2527d(Context context, String str, Map map, int i2) {
            this.f7879a = context;
            this.f7880b = str;
            this.f7881c = map;
            this.f7882d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f7879a, this.f7880b, this.f7881c, this.f7882d);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$e */
    class RunnableC2528e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7884a;

        /* renamed from: b */
        final /* synthetic */ String f7885b;

        /* renamed from: c */
        final /* synthetic */ Map f7886c;

        RunnableC2528e(Context context, String str, Map map) {
            this.f7884a = context;
            this.f7885b = str;
            this.f7886c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f7884a, this.f7885b, this.f7886c);
        }
    }

    /* renamed from: com.huawei.hms.support.hianalytics.HiAnalyticsUtils$f */
    class RunnableC2529f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7888a;

        /* renamed from: b */
        final /* synthetic */ String f7889b;

        /* renamed from: c */
        final /* synthetic */ Map f7890c;

        /* renamed from: d */
        final /* synthetic */ int f7891d;

        RunnableC2529f(Context context, String str, Map map, int i2) {
            this.f7888a = context;
            this.f7889b = str;
            this.f7890c = map;
            this.f7891d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HiAnalyticsUtils.getInstance().onReport(this.f7888a, this.f7889b, this.f7890c, this.f7891d);
        }
    }

    private HiAnalyticsUtils() {
    }

    /* renamed from: a */
    private static LinkedHashMap<String, String> m7696a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    private void m7702b(Context context) {
        synchronized (f7863d) {
            int i2 = this.f7865a;
            if (i2 < 60) {
                this.f7865a = i2 + 1;
            } else {
                this.f7865a = 0;
                if (this.f7866b) {
                    HiAnalyticsOfCpUtils.onReport(context, 0);
                    HiAnalyticsOfCpUtils.onReport(context, 1);
                } else {
                    HmsHiAnalyticsUtils.onReport();
                }
            }
        }
    }

    /* renamed from: c */
    private void m7706c(Context context, String str, Map map) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2528e(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th.getMessage());
        }
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f7862c) {
            if (f7864e == null) {
                f7864e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f7864e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.m7717i("HiAnalyticsUtils", "Enable Log");
        if (this.f7866b) {
            HiAnalyticTools.enableLog(context);
        } else {
            HmsHiAnalyticsUtils.enableLog();
        }
    }

    public boolean getInitFlag() {
        return !this.f7866b ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public int getOobeAnalyticsState(Context context) {
        if (context == null) {
            return 0;
        }
        int m7695a = m7695a(context);
        if (m7695a == 1) {
            return m7695a;
        }
        Bundle bundle = new Bundle();
        bundle.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        try {
            Bundle call = context.getApplicationContext().getContentResolver().call(Uri.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", (String) null, bundle);
            if (call == null) {
                return m7695a;
            }
            m7695a = call.getInt("SWITCH_IS_CHECKED");
            HMSLog.m7717i("HiAnalyticsUtils", "get hms analyticsOobe state " + m7695a);
            return m7695a;
        } catch (IllegalArgumentException unused) {
            HMSLog.m7717i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
            return m7695a;
        } catch (SecurityException unused2) {
            HMSLog.m7717i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
            return m7695a;
        } catch (Exception unused3) {
            HMSLog.m7717i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
            return m7695a;
        }
    }

    public boolean hasError(Context context) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m7701a(initFlag, andRefreshAnalyticsState != 2, map)) {
            m7698a(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7866b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, m7696a(map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, m7696a(map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, m7696a(map));
                HmsHiAnalyticsUtils.onEvent(1, str, m7696a(map));
            }
            m7702b(context);
        }
    }

    public void onEvent2(Context context, String str, String str2) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (context == null) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (!initFlag && andRefreshAnalyticsState != 2 && m7700a(str2)) {
            m7697a(context, str, str2);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7866b) {
                HiAnalyticsOfCpUtils.onEvent(context, str, str2);
            } else {
                HmsHiAnalyticsUtils.onEvent(context, str, str2);
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m7701a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            m7703b(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7866b) {
                HiAnalyticsOfCpUtils.onEvent(context, 0, str, m7696a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onEvent(context, 1, str, m7696a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onEvent(0, str, m7696a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onEvent(1, str, m7696a((Map<String, String>) map));
            }
            m7702b(context);
        }
    }

    public void onReport(Context context, String str, Map map) {
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map == null || map.isEmpty() || context == null) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + andRefreshAnalyticsState);
            return;
        }
        boolean initFlag = getInitFlag();
        if (m7701a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
            m7706c(context, str, map);
        }
        if (andRefreshAnalyticsState == 1 && initFlag) {
            if (this.f7866b) {
                HiAnalyticsOfCpUtils.onStreamEvent(context, 0, str, m7696a((Map<String, String>) map));
                HiAnalyticsOfCpUtils.onStreamEvent(context, 1, str, m7696a((Map<String, String>) map));
            } else {
                HmsHiAnalyticsUtils.onStreamEvent(0, str, m7696a((Map<String, String>) map));
                HmsHiAnalyticsUtils.onStreamEvent(1, str, m7696a((Map<String, String>) map));
            }
        }
    }

    public void enableLog() {
        HMSLog.m7717i("HiAnalyticsUtils", "Enable Log");
        if (!this.f7866b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.m7717i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    /* renamed from: a */
    private int m7695a(Context context) {
        int i2 = 0;
        try {
            i2 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
            HMSLog.m7717i("HiAnalyticsUtils", "getOobeStateForSettings value is " + i2);
            return i2;
        } catch (Settings.SettingNotFoundException e2) {
            HMSLog.m7717i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e2.getMessage());
            return i2;
        }
    }

    /* renamed from: a */
    private boolean m7701a(boolean z, boolean z2, Map<?, ?> map) {
        return !z && z2 && m7705b(map);
    }

    /* renamed from: b */
    private boolean m7705b(Map<?, ?> map) {
        try {
            Iterator<?> it = map.values().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    j2 += ((String) r3).getBytes(Charset.forName("UTF-8")).length;
                }
            }
            return j2 <= 512;
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private boolean m7700a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.getBytes(Charset.forName("UTF-8")).length <= 512;
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th.getMessage());
            return false;
        }
    }

    public void onReport(Context context, String str, Map map, int i2) {
        if (i2 != 0 && i2 != 1) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m7701a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m7704b(context, str, map, i2);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f7866b) {
                    HmsHiAnalyticsUtils.onStreamEvent(i2, str, m7696a((Map<String, String>) map));
                    return;
                } else {
                    HiAnalyticsOfCpUtils.onStreamEvent(context, i2, str, m7696a((Map<String, String>) map));
                    return;
                }
            }
            return;
        }
        HMSLog.m7715e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: a */
    private void m7698a(Context context, String str, Map<String, String> map) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2524a(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th.getMessage());
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i2) {
        if (i2 != 0 && i2 != 1) {
            HMSLog.m7715e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
            return;
        }
        int andRefreshAnalyticsState = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(context);
        if (map != null && !map.isEmpty() && context != null) {
            boolean initFlag = getInitFlag();
            if (m7701a(initFlag, andRefreshAnalyticsState != 2, (Map<?, ?>) map)) {
                m7699a(context, str, map, i2);
            }
            if (andRefreshAnalyticsState == 1 && initFlag) {
                if (!this.f7866b) {
                    HmsHiAnalyticsUtils.onEvent(i2, str, m7696a((Map<String, String>) map));
                } else {
                    HiAnalyticsOfCpUtils.onEvent(context, i2, str, m7696a((Map<String, String>) map));
                }
                m7702b(context);
                return;
            }
            return;
        }
        HMSLog.m7715e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + andRefreshAnalyticsState);
    }

    /* renamed from: b */
    private void m7703b(Context context, String str, Map map) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2526c(context.getApplicationContext(), str, map));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th.getMessage());
        }
    }

    /* renamed from: a */
    private void m7697a(Context context, String str, String str2) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2525b(context.getApplicationContext(), str, str2));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th.getMessage());
        }
    }

    /* renamed from: b */
    private void m7704b(Context context, String str, Map map, int i2) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2529f(context.getApplicationContext(), str, map, i2));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th.getMessage());
        }
    }

    /* renamed from: a */
    private void m7699a(Context context, String str, Map map, int i2) {
        try {
            C2507a.m7656c().m7658a(new RunnableC2527d(context.getApplicationContext(), str, map, i2));
        } catch (Throwable th) {
            HMSLog.m7715e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th.getMessage());
        }
    }
}
