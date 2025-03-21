package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.filter.C3312a;
import com.umeng.analytics.filter.C3313b;
import com.umeng.analytics.pro.C3397d;
import com.umeng.analytics.pro.C3408i;
import com.umeng.analytics.pro.C3409j;
import com.umeng.analytics.pro.C3410k;
import com.umeng.analytics.pro.C3411l;
import com.umeng.analytics.pro.C3412m;
import com.umeng.analytics.pro.C3414o;
import com.umeng.analytics.pro.C3415p;
import com.umeng.analytics.pro.C3418s;
import com.umeng.analytics.pro.C3420u;
import com.umeng.analytics.pro.C3421v;
import com.umeng.analytics.pro.C3424y;
import com.umeng.analytics.pro.InterfaceC3413n;
import com.umeng.analytics.pro.InterfaceC3419t;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C3531d;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InternalAgent.java */
/* renamed from: com.umeng.analytics.b */
/* loaded from: classes2.dex */
public class C3310b implements InterfaceC3413n, InterfaceC3419t {

    /* renamed from: A */
    private static final String f11370A = "umsp_2";

    /* renamed from: B */
    private static final String f11371B = "umsp_3";

    /* renamed from: C */
    private static final String f11372C = "umsp_4";

    /* renamed from: D */
    private static final String f11373D = "umsp_5";

    /* renamed from: a */
    private static Context f11374a = null;

    /* renamed from: h */
    private static final String f11375h = "sp_uapp";

    /* renamed from: i */
    private static final String f11376i = "prepp_uapp";

    /* renamed from: o */
    private static final int f11377o = 128;

    /* renamed from: p */
    private static final int f11378p = 256;

    /* renamed from: q */
    private static String f11379q = "";

    /* renamed from: r */
    private static String f11380r = "";

    /* renamed from: t */
    private static final String f11382t = "ekv_bl_ver";

    /* renamed from: w */
    private static final String f11384w = "ekv_wl_ver";

    /* renamed from: z */
    private static final String f11385z = "umsp_1";

    /* renamed from: b */
    private ISysListener f11386b;

    /* renamed from: c */
    private C3415p f11387c;

    /* renamed from: d */
    private C3421v f11388d;

    /* renamed from: e */
    private C3410k f11389e;

    /* renamed from: f */
    private C3420u f11390f;

    /* renamed from: g */
    private C3411l f11391g;

    /* renamed from: j */
    private boolean f11392j;

    /* renamed from: k */
    private volatile JSONObject f11393k;

    /* renamed from: l */
    private volatile JSONObject f11394l;

    /* renamed from: m */
    private volatile JSONObject f11395m;

    /* renamed from: n */
    private boolean f11396n;

    /* renamed from: u */
    private C3312a f11397u;

    /* renamed from: x */
    private C3313b f11398x;

    /* renamed from: y */
    private C3412m f11399y;

    /* renamed from: s */
    private static final String f11381s = C3397d.f11921al;

    /* renamed from: v */
    private static final String f11383v = C3397d.f11922am;

    /* compiled from: InternalAgent.java */
    /* renamed from: com.umeng.analytics.b$a */
    private static class a {

        /* renamed from: a */
        private static final C3310b f11400a = new C3310b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f11374a = appContext.getApplicationContext();
        }
    }

    /* renamed from: a */
    public static C3310b m10736a() {
        return a.f11400a;
    }

    /* renamed from: i */
    private void m10741i(Context context) {
        try {
            if (context == null) {
                MLog.m11744e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f11393k == null) {
                this.f11393k = new JSONObject();
            }
            if (this.f11394l == null) {
                this.f11394l = new JSONObject();
            }
            String string = sharedPreferences.getString(f11376i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f11395m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f11395m == null) {
                this.f11395m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    public JSONObject m10763b() {
        return this.f11393k;
    }

    /* renamed from: c */
    public JSONObject m10768c() {
        return this.f11395m;
    }

    /* renamed from: d */
    public JSONObject m10771d() {
        return this.f11394l;
    }

    /* renamed from: e */
    public void m10776e() {
        this.f11394l = null;
    }

    /* renamed from: f */
    public String m10777f() {
        if (UMUtils.isMainProgress(f11374a)) {
            return f11379q;
        }
        MLog.m11744e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    /* renamed from: g */
    public String m10780g() {
        if (UMUtils.isMainProgress(f11374a)) {
            return f11380r;
        }
        MLog.m11744e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    /* renamed from: h */
    public void m10783h() {
        try {
            if (f11374a != null) {
                if (!UMUtils.isMainProgress(f11374a)) {
                    MLog.m11744e("onStartSessionInternal can not be called in child process");
                    return;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12207k, CoreProtocol.getInstance(f11374a), Long.valueOf(currentTimeMillis));
                    UMWorkDispatch.sendEvent(f11374a, 4103, CoreProtocol.getInstance(f11374a), Long.valueOf(currentTimeMillis));
                }
            }
            if (this.f11386b != null) {
                this.f11386b.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    void m10785j() {
        try {
            if (f11374a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f11374a, 4102, CoreProtocol.getInstance(f11374a), jSONObject);
            UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12211o, CoreProtocol.getInstance(f11374a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11746e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    /* renamed from: k */
    public synchronized void m10786k() {
        if (f11374a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f11393k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f11374a).edit();
            edit.putString(f11375h, this.f11393k.toString());
            edit.commit();
        } else {
            this.f11393k = new JSONObject();
        }
    }

    /* renamed from: l */
    public synchronized JSONObject m10787l() {
        if (f11374a == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f11393k == null) {
            this.f11393k = new JSONObject();
        }
        return this.f11393k;
    }

    /* renamed from: m */
    public synchronized void m10788m() {
        try {
            if (f11374a != null) {
                if (!UMUtils.isMainProgress(f11374a)) {
                    MLog.m11744e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f11374a).edit();
                    edit.remove(f11375h);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3413n
    /* renamed from: n */
    public void mo10789n() {
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.m11530b()) {
            if (!FieldManager.allow(C3531d.f12956D)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(C3414o.a.f12191A)) {
                    return;
                }
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f11374a;
                UMWorkDispatch.sendEvent(context, C3414o.a.f12191A, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private C3310b() {
        this.f11387c = new C3415p();
        this.f11388d = new C3421v();
        this.f11389e = new C3410k();
        this.f11390f = C3420u.m11389a();
        this.f11391g = null;
        this.f11392j = false;
        this.f11393k = null;
        this.f11394l = null;
        this.f11395m = null;
        this.f11396n = false;
        this.f11397u = null;
        this.f11398x = null;
        this.f11399y = null;
        this.f11387c.m11361a(this);
    }

    /* renamed from: a */
    public void m10744a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (this.f11397u == null) {
                this.f11397u = new C3312a(f11381s, "ekv_bl_ver");
                this.f11397u.register(f11374a);
            }
            if (this.f11398x == null) {
                this.f11398x = new C3313b(f11383v, "ekv_wl_ver");
                this.f11398x.register(f11374a);
            }
            if (UMUtils.isMainProgress(f11374a)) {
                if (!this.f11392j) {
                    this.f11392j = true;
                    m10741i(f11374a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.f11396n) {
                            this.f11391g = C3411l.m11269a(context);
                            if (this.f11391g.m11287a()) {
                                this.f11396n = true;
                            }
                            this.f11399y = C3412m.m11292a();
                            try {
                                C3412m.m11293a(context);
                                this.f11399y.m11298a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    this.f11396n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(C3409j.f12069B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f11374a));
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    void m10767b(String str) {
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f11388d.m11412b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    void m10769c(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12127p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.m11549aq(C3409j.f12128q, 2, "\\|");
        }
        try {
            if (!this.f11392j || !this.f11396n) {
                m10744a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f11389e.m11412b(context.getClass().getName());
            }
            m10784i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11746e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            f11380r = context.getClass().getName();
        }
    }

    /* renamed from: d */
    void m10772d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onKillProcess can not be called in child process");
                return;
            }
            if (this.f11391g != null) {
                this.f11391g.m11290c();
            }
            C3411l.m11271a(context, "onKillProcess");
            if (this.f11389e != null) {
                this.f11389e.m11411b();
            }
            if (this.f11388d != null) {
                this.f11388d.m11411b();
            }
            if (f11374a != null) {
                if (this.f11390f != null) {
                    this.f11390f.m11407c(f11374a, Long.valueOf(System.currentTimeMillis()));
                }
                C3414o.m11300a(f11374a).m11345d();
                C3421v.m11409a(f11374a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    C3411l.m11279c(f11374a);
                }
                PreferenceWrapper.getDefault(f11374a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public synchronized Object m10774e(Context context, String str) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12103ai, 0, "\\|");
            return null;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.m11549aq(C3409j.f12101ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f11385z) && !str.equals(f11370A) && !str.equals(f11371B) && !str.equals(f11372C) && !str.equals(f11373D)) {
            MLog.m11744e("please check key or value, must be correct!");
            return null;
        }
        if (this.f11393k == null) {
            this.f11393k = new JSONObject();
        } else if (this.f11393k.has(str)) {
            return this.f11393k.opt(str);
        }
        return null;
    }

    /* renamed from: f */
    public synchronized void m10778f(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12102ah, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        this.f11393k = new JSONObject();
        UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12216t, CoreProtocol.getInstance(f11374a), null);
    }

    /* renamed from: g */
    public synchronized void m10781g(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12110ap, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (this.f11395m.length() > 0) {
            UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12220x, CoreProtocol.getInstance(f11374a), null);
        }
        this.f11395m = new JSONObject();
    }

    /* renamed from: b */
    void m10764b(Context context) {
        if (context == null) {
            MLog.m11744e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.m11549aq(C3409j.f12126o, 2, "\\|");
        }
        try {
            if (!this.f11392j || !this.f11396n) {
                m10744a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f11389e.m11410a(context.getClass().getName());
            }
            m10783h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f11379q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.m11746e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    /* renamed from: h */
    public synchronized JSONObject m10782h(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12111aq, 0, "\\|");
            return null;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (this.f11395m == null) {
            this.f11395m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f11395m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f11395m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* renamed from: i */
    public void m10784i() {
        try {
            if (f11374a != null) {
                if (!UMUtils.isMainProgress(f11374a)) {
                    MLog.m11744e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12204h, CoreProtocol.getInstance(f11374a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(f11374a, 4100, CoreProtocol.getInstance(f11374a), null);
                UMWorkDispatch.sendEvent(f11374a, 4099, CoreProtocol.getInstance(f11374a), null);
                UMWorkDispatch.sendEvent(f11374a, 4105, CoreProtocol.getInstance(f11374a), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f11386b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    /* renamed from: f */
    public synchronized void m10779f(Context context, String str) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12108an, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (this.f11395m == null) {
            this.f11395m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f11395m.has(str)) {
                this.f11395m.remove(str);
                UMWorkDispatch.sendEvent(f11374a, 8200, CoreProtocol.getInstance(f11374a), this.f11395m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.m11549aq(C3409j.f12109ao, 0, "\\|");
            }
            return;
        }
        MLog.m11744e("please check propertics, property is null!");
    }

    /* renamed from: c */
    private boolean m10740c(String str) {
        if (this.f11397u.enabled() && this.f11397u.matchHit(str)) {
            return true;
        }
        if (!this.f11398x.enabled()) {
            return false;
        }
        if (!this.f11398x.matchHit(str)) {
            return true;
        }
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    /* renamed from: d */
    public synchronized void m10773d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.m11549aq(C3409j.f12102ah, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.m11549aq(C3409j.f12101ag, 0, "\\|");
            return;
        }
        if (!str.equals(f11385z) && !str.equals(f11370A) && !str.equals(f11371B) && !str.equals(f11372C) && !str.equals(f11373D)) {
            MLog.m11744e("please check key or value, must be correct!");
            return;
        }
        if (this.f11393k == null) {
            this.f11393k = new JSONObject();
        }
        if (this.f11393k.has(str)) {
            this.f11393k.remove(str);
            UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12217u, CoreProtocol.getInstance(f11374a), str);
        }
    }

    /* renamed from: b */
    public void m10765b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.m11549aq(C3409j.f12081N, 0, "\\|");
                return;
            }
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f11392j || !this.f11396n) {
                m10744a(f11374a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(C3397d.f11906aE, str);
                m10737a(f11374a, C3397d.f11905aD, (Map<String, Object>) hashMap, -1L, false);
                return;
            }
            UMLog.m11549aq(C3409j.f12082O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
    }

    /* renamed from: e */
    public synchronized String m10775e(Context context) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12103ai, 0, "\\|");
            return null;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f11393k != null) {
            return this.f11393k.toString();
        }
        this.f11393k = new JSONObject();
        return null;
    }

    /* renamed from: c */
    void m10770c(Context context, String str) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12137z, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("setSecret can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        AnalyticsConfig.m10733a(f11374a, str);
    }

    /* renamed from: a */
    void m10758a(String str) {
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f11388d.m11410a(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m10756a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("setSysListener can not be called in child process");
        } else {
            this.f11386b = iSysListener;
        }
    }

    /* renamed from: a */
    public void m10745a(Context context, int i2) {
        if (context == null) {
            MLog.m11744e("unexpected null context in setVerticalType");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        AnalyticsConfig.m10732a(f11374a, i2);
    }

    /* renamed from: b */
    public synchronized void m10766b(Object obj) {
        if (f11374a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f11374a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f11376i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(f11376i).commit();
        }
    }

    /* renamed from: a */
    public void m10750a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f11392j || !this.f11396n) {
                m10744a(f11374a);
            }
            String str2 = "";
            if (this.f11393k == null) {
                this.f11393k = new JSONObject();
            } else {
                str2 = this.f11393k.toString();
            }
            C3418s.m11372a(f11374a).m11385a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
    }

    /* renamed from: b */
    private boolean m10739b(String str, Object obj) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            MLog.m11744e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i2 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i2 = 0;
        }
        if (i2 > 128) {
            MLog.m11744e("key length is " + i2 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.m11744e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.m11744e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    /* renamed from: a */
    void m10747a(Context context, String str) {
        if (context == null) {
            UMLog.m11549aq(C3409j.f12134w, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.m11549aq(C3409j.f12135x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.f11392j || !this.f11396n) {
                m10744a(f11374a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(C3397d.f11891Q, 2);
            jSONObject.put(C3397d.f11892R, str);
            jSONObject.put("__ii", this.f11390f.m11405c());
            UMWorkDispatch.sendEvent(f11374a, 4106, CoreProtocol.getInstance(f11374a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
    }

    /* renamed from: a */
    void m10753a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f11392j || !this.f11396n) {
                    m10744a(f11374a);
                }
                m10747a(f11374a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.m11748e(e2);
                    return;
                }
                return;
            }
        }
        UMLog.m11549aq(C3409j.f12136y, 0, "\\|");
    }

    /* renamed from: a */
    public void m10749a(Context context, String str, String str2, long j2, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!this.f11392j || !this.f11396n) {
                m10744a(f11374a);
            }
            if (m10740c(str)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f11393k == null) {
                this.f11393k = new JSONObject();
            } else {
                str3 = this.f11393k.toString();
            }
            C3418s.m11372a(f11374a).m11383a(str, str2, j2, i2, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
    }

    /* renamed from: a */
    void m10752a(Context context, String str, Map<String, Object> map, long j2) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(C3397d.f11907aF).contains(str)) {
                UMLog.m11549aq(C3409j.f12113b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.m11549aq(C3409j.f12115d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(C3397d.f11907aF).contains(it.next().getKey())) {
                    UMLog.m11549aq(C3409j.f12116e, 0, "\\|");
                    return;
                }
            }
            m10737a(context, str, map, j2, false);
            return;
        }
        UMLog.m11549aq(C3409j.f12114c, 0, "\\|");
    }

    /* renamed from: a */
    public void m10751a(Context context, String str, Map<String, Object> map) {
        m10737a(context, str, map, -1L, true);
    }

    /* renamed from: a */
    private void m10737a(Context context, String str, Map<String, Object> map, long j2, boolean z) {
        try {
            if (context == null) {
                MLog.m11744e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f11374a == null) {
                f11374a = context.getApplicationContext();
            }
            if (!this.f11392j || !this.f11396n) {
                m10744a(f11374a);
            }
            if (m10740c(str)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f11393k == null) {
                this.f11393k = new JSONObject();
            } else {
                str2 = this.f11393k.toString();
            }
            C3418s.m11372a(f11374a).m11384a(str, map, j2, str2, z);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11748e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.InterfaceC3419t
    /* renamed from: a */
    public void mo10760a(Throwable th) {
        try {
            if (f11374a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                if (this.f11388d != null) {
                    this.f11388d.m11411b();
                }
                C3411l.m11271a(f11374a, "onAppCrash");
                if (this.f11389e != null) {
                    this.f11389e.m11411b();
                }
                if (this.f11391g != null) {
                    this.f11391g.m11290c();
                }
                if (this.f11390f != null) {
                    this.f11390f.m11407c(f11374a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(C3397d.f11891Q, 1);
                    jSONObject.put(C3397d.f11892R, DataHelper.convertExceptionToString(th));
                    C3408i.m11232a(f11374a).m11250a(this.f11390f.m11405c(), jSONObject.toString(), 1);
                }
                C3414o.m11300a(f11374a).m11345d();
                C3421v.m11409a(f11374a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    C3411l.m11279c(f11374a);
                }
                PreferenceWrapper.getDefault(f11374a).edit().commit();
            }
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.m11746e("Exception in onAppCrash", e2);
            }
        }
    }

    /* renamed from: a */
    void m10759a(String str, String str2) {
        try {
            if (f11374a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f11374a)) {
                MLog.m11744e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3397d.f11887M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            UMWorkDispatch.sendEvent(f11374a, 4101, CoreProtocol.getInstance(f11374a), jSONObject);
            UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12211o, CoreProtocol.getInstance(f11374a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.m11746e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    /* renamed from: a */
    void m10762a(boolean z) {
        Context context = f11374a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m11744e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z;
        }
    }

    /* renamed from: a */
    void m10761a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* renamed from: a */
    void m10742a(double d2, double d3) {
        Context context = f11374a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m11744e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f11347a == null) {
            AnalyticsConfig.f11347a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f11347a;
        dArr[0] = d2;
        dArr[1] = d3;
    }

    /* renamed from: a */
    void m10746a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.m11744e("unexpected null context in setScenarioType");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            m10745a(f11374a, eScenarioType.toValue());
        }
        if (this.f11392j && this.f11396n) {
            return;
        }
        m10744a(f11374a);
    }

    /* renamed from: a */
    void m10743a(long j2) {
        Context context = f11374a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.m11744e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j2;
            C3424y.m11419a().m11428a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    /* renamed from: a */
    public synchronized void m10748a(Context context, String str, Object obj) {
        int i2 = 0;
        if (context == null) {
            UMLog.m11549aq(C3409j.f12100af, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f11385z) && !str.equals(f11370A) && !str.equals(f11371B) && !str.equals(f11372C) && !str.equals(f11373D)) {
                MLog.m11744e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.m11744e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f11393k == null) {
                    this.f11393k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.m11744e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.m11744e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.f11393k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.m11744e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.f11393k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.m11744e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.f11393k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.m11744e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.f11393k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.m11744e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.f11393k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.m11744e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.f11393k.put(str, jSONArray6);
                    } else {
                        MLog.m11744e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.m11744e("please check value, illegal type!");
                        return;
                    }
                    this.f11393k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12215s, CoreProtocol.getInstance(f11374a), this.f11393k.toString());
            return;
        }
        UMLog.m11549aq(C3409j.f12101ag, 0, "\\|");
    }

    /* renamed from: a */
    private void m10738a(String str, Object obj) {
        try {
            if (this.f11393k == null) {
                this.f11393k = new JSONObject();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.f11393k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.f11393k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f11393k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public synchronized void m10757a(Object obj) {
        if (f11374a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f11374a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f11375h, this.f11393k.toString()).commit();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m10754a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.m11748e(th);
        }
        if (context == null) {
            UMLog.m11549aq(C3409j.f12104aj, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        C3418s.m11372a(f11374a).m11386a(list);
    }

    /* renamed from: a */
    public synchronized void m10755a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.m11549aq(C3409j.f12106al, 0, "\\|");
            return;
        }
        if (f11374a == null) {
            f11374a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f11374a)) {
            MLog.m11744e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f11392j || !this.f11396n) {
            m10744a(f11374a);
        }
        if (this.f11395m == null) {
            this.f11395m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f11395m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (m10739b(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.m11744e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f11395m = jSONObject2;
            if (this.f11395m.length() > 0) {
                UMWorkDispatch.sendEvent(f11374a, C3414o.a.f12218v, CoreProtocol.getInstance(f11374a), this.f11395m.toString());
            }
            return;
        }
        UMLog.m11549aq(C3409j.f12107am, 0, "\\|");
    }
}
