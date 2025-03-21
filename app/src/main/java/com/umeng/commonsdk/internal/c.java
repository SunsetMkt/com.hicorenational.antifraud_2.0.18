package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol.java */
/* loaded from: classes2.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10772b = "preInitInvokedFlag";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10773c = "policyGrantInvokedFlag";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10774d = "policyGrantResult";

    /* renamed from: f, reason: collision with root package name */
    private static int f10775f = 1;

    /* renamed from: e, reason: collision with root package name */
    private Context f10783e;

    /* renamed from: a, reason: collision with root package name */
    public static final String f10771a = at.b().b(at.q);

    /* renamed from: g, reason: collision with root package name */
    private static Class<?> f10776g = null;

    /* renamed from: h, reason: collision with root package name */
    private static Method f10777h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Method f10778i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Method f10779j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile String f10780k = "";

    /* renamed from: l, reason: collision with root package name */
    private static volatile String f10781l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f10782m = false;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f10783e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f10781l)) {
            return f10781l;
        }
        Class<?> cls = f10776g;
        if (cls == null || (method = f10777h) == null || f10779j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f10779j.invoke(invoke, new Object[0]);
            try {
                f10781l = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                f10776g = cls;
                Method declaredMethod = f10776g.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    f10777h = declaredMethod;
                }
                Method declaredMethod2 = f10776g.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    f10778i = declaredMethod2;
                }
                Method declaredMethod3 = f10776g.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    f10779j = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bj a2 = bj.a(this.f10783e);
        bk a3 = a2.a(bl.f10169c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.f10161a;
                String str2 = a3.f10162b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.f10783e.getApplicationContext(), new JSONObject(a3.f10163c), new JSONObject(a3.f10164d), a3.f10165e, str2, a3.f10166f);
                if (a4 == null || !a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a2.a(bl.f10169c, str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (f10782m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            f10782m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f10782m = true;
            a(this.f10783e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f10783e.getSharedPreferences(h.f10946a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(h.f10947b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f10783e, a.w, b.a(c.this.f10783e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f10782m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f10783e);
            f10775f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f10783e != null) {
                        UMWorkDispatch.sendEvent(c.this.f10783e, a.x, b.a(c.this.f10783e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f10783e, true);
        }
    }

    private void g() {
        if (f10775f <= 0) {
            h();
            e(this.f10783e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f10783e)) {
            f(this.f10783e);
            UMInnerManager.sendInnerPackage(this.f10783e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f10783e)) {
                Context context = this.f10783e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, com.heytap.mcssdk.constant.a.r);
            }
            Context context2 = this.f10783e;
            UMWorkDispatch.sendEvent(context2, o.a.y, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f10783e;
            UMWorkDispatch.sendEvent(context3, a.t, b.a(context3).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02ba A[Catch: all -> 0x044a, TryCatch #1 {all -> 0x044a, blocks: (B:22:0x0089, B:24:0x0091, B:26:0x00a0, B:27:0x00a3, B:28:0x00ae, B:49:0x0110, B:53:0x0142, B:60:0x015a, B:62:0x0176, B:64:0x017c, B:65:0x018c, B:67:0x01b7, B:73:0x01c1, B:75:0x01c5, B:77:0x01d9, B:102:0x0276, B:104:0x028d, B:106:0x0298, B:109:0x029f, B:111:0x02a5, B:113:0x02b0, B:117:0x02ba, B:119:0x02c0, B:121:0x02cc, B:123:0x02d3), top: B:19:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d3 A[Catch: all -> 0x044a, TRY_LEAVE, TryCatch #1 {all -> 0x044a, blocks: (B:22:0x0089, B:24:0x0091, B:26:0x00a0, B:27:0x00a3, B:28:0x00ae, B:49:0x0110, B:53:0x0142, B:60:0x015a, B:62:0x0176, B:64:0x017c, B:65:0x018c, B:67:0x01b7, B:73:0x01c1, B:75:0x01c5, B:77:0x01d9, B:102:0x0276, B:104:0x028d, B:106:0x0298, B:109:0x029f, B:111:0x02a5, B:113:0x02b0, B:117:0x02ba, B:119:0x02c0, B:121:0x02cc, B:123:0x02d3), top: B:19:0x0077 }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r13, int r14) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f10780k)) {
            return f10780k;
        }
        Class<?> cls = f10776g;
        if (cls == null || (method = f10777h) == null || f10778i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f10778i.invoke(invoke, this.f10783e);
            try {
                f10780k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("umid"), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new Object[0])) == null || (declaredMethod = a2.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.f10946a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.f10947b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f10947b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bl.f10178l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, final boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f10946a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = av.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f10948c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.f10947b, a2);
                        edit2.commit();
                    }
                    if (z) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r1)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L94
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r3 = "startTime"
            java.lang.String r2 = com.umeng.common.b.a(r11, r2, r3)
            java.lang.String r3 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r4 = "period"
            java.lang.String r3 = com.umeng.common.b.a(r11, r3, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            r5 = 0
            if (r4 != 0) goto L32
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L32
            long r7 = r2.longValue()     // Catch: java.lang.Throwable -> L32
            goto L33
        L32:
            r7 = r5
        L33:
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            java.lang.Long r2 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L42
            long r2 = r2.longValue()     // Catch: java.lang.Throwable -> L42
            goto L43
        L42:
            r2 = r5
        L43:
            java.lang.String r4 = "MobclickRT"
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 == 0) goto L8a
            int r9 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r9 != 0) goto L4e
            goto L8a
        L4e:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r7
            r7 = 60
            long r2 = r2 * r7
            r7 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r7
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L73
            java.lang.String r0 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L94
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L94
        L73:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r0)
            boolean r0 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r0 != 0) goto L94
            java.lang.String r0 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L94
        L8a:
            java.lang.String r0 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = av.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
