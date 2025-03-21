package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3338av;
import com.umeng.analytics.pro.C3353bj;
import com.umeng.analytics.pro.C3354bk;
import com.umeng.analytics.pro.C3355bl;
import com.umeng.analytics.pro.C3414o;
import com.umeng.ccg.C3440c;
import com.umeng.ccg.C3441d;
import com.umeng.ccg.ConfigListener;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.C3494b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.C3508h;
import com.umeng.commonsdk.utils.C3531d;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol.java */
/* renamed from: com.umeng.commonsdk.internal.c */
/* loaded from: classes2.dex */
public class C3472c implements UMLogDataProtocol {

    /* renamed from: b */
    public static final String f12617b = "preInitInvokedFlag";

    /* renamed from: c */
    public static final String f12618c = "policyGrantInvokedFlag";

    /* renamed from: d */
    public static final String f12619d = "policyGrantResult";

    /* renamed from: f */
    private static int f12620f = 1;

    /* renamed from: e */
    private Context f12628e;

    /* renamed from: a */
    public static final String f12616a = C3336at.m10865b().m10868b(C3336at.f11503q);

    /* renamed from: g */
    private static Class<?> f12621g = null;

    /* renamed from: h */
    private static Method f12622h = null;

    /* renamed from: i */
    private static Method f12623i = null;

    /* renamed from: j */
    private static Method f12624j = null;

    /* renamed from: k */
    private static volatile String f12625k = "";

    /* renamed from: l */
    private static volatile String f12626l = "";

    /* renamed from: m */
    private static boolean f12627m = false;

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12629a;

        /* renamed from: b */
        final /* synthetic */ boolean f12630b;

        AnonymousClass1(Context context, boolean z) {
            r1 = context;
            r2 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences sharedPreferences = r1.getSharedPreferences(C3508h.f12800a, 0);
                long currentTimeMillis = System.currentTimeMillis();
                String m10871a = C3338av.m10871a(r1);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (!TextUtils.isEmpty(m10871a) && sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(C3508h.f12802c, (currentTimeMillis2 - currentTimeMillis) + "");
                    edit.commit();
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    edit2.putString(C3508h.f12801b, m10871a);
                    edit2.commit();
                }
                if (r2) {
                    UMConfigureImpl.removeInterruptFlag();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12631a;

        /* renamed from: b */
        final /* synthetic */ OnGetOaidListener f12632b;

        AnonymousClass2(Context context, OnGetOaidListener onGetOaidListener) {
            r1 = context;
            r2 = onGetOaidListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String m10871a = C3338av.m10871a(r1);
            OnGetOaidListener onGetOaidListener = r2;
            if (onGetOaidListener != null) {
                onGetOaidListener.onGetOaid(m10871a);
            }
        }
    }

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$3 */
    static class AnonymousClass3 implements OnGetOaidListener {

        /* renamed from: a */
        final /* synthetic */ Context f12633a;

        AnonymousClass3(Context context) {
            r1 = context;
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = r1.getSharedPreferences(C3508h.f12800a, 0);
                if (sharedPreferences == null || sharedPreferences.getString(C3508h.f12801b, "").equalsIgnoreCase(str)) {
                    return;
                }
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(C3508h.f12801b, str);
                edit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$4 */
    class AnonymousClass4 implements OnGetOaidListener {
        AnonymousClass4() {
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
            if (TextUtils.isEmpty(str)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                return;
            }
            try {
                SharedPreferences sharedPreferences = C3472c.this.f12628e.getSharedPreferences(C3508h.f12800a, 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(C3508h.f12801b, str);
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(C3472c.this.f12628e, C3470a.f12609w, C3471b.m11589a(C3472c.this.f12628e).m11590a(), null);
        }
    }

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$5 */
    class AnonymousClass5 implements onMessageSendListener {
        AnonymousClass5() {
        }

        @Override // com.umeng.commonsdk.utils.onMessageSendListener
        public void onMessageSend() {
            if (C3472c.this.f12628e != null) {
                UMWorkDispatch.sendEvent(C3472c.this.f12628e, C3470a.f12610x, C3471b.m11589a(C3472c.this.f12628e).m11590a(), null);
            }
            UMConfigureImpl.removeMessageSendListener(this);
        }
    }

    /* compiled from: UMInternalDataProtocol.java */
    /* renamed from: com.umeng.commonsdk.internal.c$6 */
    class AnonymousClass6 implements ConfigListener {
        AnonymousClass6() {
        }

        @Override // com.umeng.ccg.ConfigListener
        public void onConfigReady(JSONObject jSONObject) {
            if (jSONObject == null || !(jSONObject instanceof JSONObject)) {
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                return;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject.toString());
            C3440c.m11465a(C3472c.this.f12628e, 201, C3441d.m11471a(), jSONObject);
        }
    }

    static {
        m11598c();
    }

    public C3472c(Context context) {
        if (context != null) {
            this.f12628e = context.getApplicationContext();
        }
    }

    /* renamed from: b */
    public static String m11596b() {
        Method method;
        if (!TextUtils.isEmpty(f12626l)) {
            return f12626l;
        }
        Class<?> cls = f12621g;
        if (cls == null || (method = f12622h) == null || f12624j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f12624j.invoke(invoke, new Object[0]);
            try {
                f12626l = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: c */
    private static void m11598c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                f12621g = cls;
                Method declaredMethod = f12621g.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    f12622h = declaredMethod;
                }
                Method declaredMethod2 = f12621g.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    f12623i = declaredMethod2;
                }
                Method declaredMethod3 = f12621g.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    f12624j = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m11600d() {
        C3353bj m10987a = C3353bj.m10987a(this.f12628e);
        C3354bk m10992a = m10987a.m10992a(C3355bl.f11731c);
        if (m10992a != null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = m10992a.f11723a;
                String str2 = m10992a.f11724b;
                JSONObject m11732a = new C3494b().m11732a(this.f12628e.getApplicationContext(), new JSONObject(m10992a.f11725c), new JSONObject(m10992a.f11726d), m10992a.f11727e, str2, m10992a.f11728f);
                if (m11732a == null || !m11732a.has("exception")) {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                m10987a.m10994a(C3355bl.f11731c, str);
                m10987a.m10996b();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    private void m11602e() {
        if (f12627m) {
            if (FieldManager.allow(C3531d.f12959G)) {
                return;
            }
            f12627m = false;
        } else if (FieldManager.allow(C3531d.f12959G)) {
            f12627m = true;
            m11594a(this.f12628e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                AnonymousClass4() {
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = C3472c.this.f12628e.getSharedPreferences(C3508h.f12800a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(C3508h.f12801b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(C3472c.this.f12628e, C3470a.f12609w, C3471b.m11589a(C3472c.this.f12628e).m11590a(), null);
                }
            });
        }
    }

    /* renamed from: f */
    private void m11604f() {
        if (FieldManager.allow(C3531d.f12959G)) {
            f12627m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f12628e);
            f12620f++;
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                AnonymousClass5() {
                }

                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (C3472c.this.f12628e != null) {
                        UMWorkDispatch.sendEvent(C3472c.this.f12628e, C3470a.f12610x, C3471b.m11589a(C3472c.this.f12628e).m11590a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            m11595a(this.f12628e, true);
        }
    }

    /* renamed from: g */
    private void m11606g() {
        if (f12620f <= 0) {
            m11607h();
            m11603e(this.f12628e);
        }
    }

    /* renamed from: h */
    private void m11607h() {
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f12628e)) {
            m11605f(this.f12628e);
            UMInnerManager.sendInnerPackage(this.f12628e);
            if (!FieldManager.allow(C3531d.f12997ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f12628e)) {
                Context context = this.f12628e;
                UMWorkDispatch.sendEvent(context, C3470a.f12581G, C3471b.m11589a(context).m11590a(), null, C2084a.f6136r);
            }
            Context context2 = this.f12628e;
            UMWorkDispatch.sendEvent(context2, C3414o.a.f12221y, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f12628e;
            UMWorkDispatch.sendEvent(context3, C3470a.f12606t, C3471b.m11589a(context3).m11590a(), null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.C3472c.workEvent(java.lang.Object, int):void");
    }

    /* renamed from: a */
    public String m11608a() {
        Method method;
        if (!TextUtils.isEmpty(f12625k)) {
            return f12625k;
        }
        Class<?> cls = f12621g;
        if (cls == null || (method = f12622h) == null || f12623i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f12623i.invoke(invoke, this.f12628e);
            try {
                f12625k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: b */
    private void m11597b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3494b.m11723a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(C3494b.m11723a("umid"), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m11593a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3494b.m11723a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(C3494b.m11723a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(C3494b.m11723a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m11603e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> m11592a = m11592a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = m11592a.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(m11592a, new Object[0])) == null || (declaredMethod = m11592a.getDeclaredMethod("init", Context.class, String.class, m11592a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private static void m11599c(Context context) {
        if (FieldManager.allow(C3531d.f12959G)) {
            m11594a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3

                /* renamed from: a */
                final /* synthetic */ Context f12633a;

                AnonymousClass3(Context context2) {
                    r1 = context2;
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = r1.getSharedPreferences(C3508h.f12800a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(C3508h.f12801b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(C3508h.f12801b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private static void m11605f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + C3355bl.f11740l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m11595a(Context context, boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1

            /* renamed from: a */
            final /* synthetic */ Context f12629a;

            /* renamed from: b */
            final /* synthetic */ boolean f12630b;

            AnonymousClass1(Context context2, boolean z2) {
                r1 = context2;
                r2 = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = r1.getSharedPreferences(C3508h.f12800a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String m10871a = C3338av.m10871a(r1);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(m10871a) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(C3508h.f12802c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(C3508h.f12801b, m10871a);
                        edit2.commit();
                    }
                    if (r2) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11601d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r0 = com.umeng.common.C3443b.m11504a(r11, r0, r1)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L94
            java.lang.String r2 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r3 = "startTime"
            java.lang.String r2 = com.umeng.common.C3443b.m11504a(r11, r2, r3)
            java.lang.String r3 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r4 = "period"
            java.lang.String r3 = com.umeng.common.C3443b.m11504a(r11, r3, r4)
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
            com.umeng.commonsdk.debug.UMRTLog.m11556i(r4, r0)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.C3443b.m11505a(r11, r0)
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
            com.umeng.commonsdk.debug.UMRTLog.m11556i(r4, r0)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L94
        L8a:
            java.lang.String r0 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.m11556i(r4, r0)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.C3443b.m11505a(r11, r0)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.C3472c.m11601d(android.content.Context):void");
    }

    /* renamed from: a */
    private static void m11594a(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2

            /* renamed from: a */
            final /* synthetic */ Context f12631a;

            /* renamed from: b */
            final /* synthetic */ OnGetOaidListener f12632b;

            AnonymousClass2(Context context2, OnGetOaidListener onGetOaidListener2) {
                r1 = context2;
                r2 = onGetOaidListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String m10871a = C3338av.m10871a(r1);
                OnGetOaidListener onGetOaidListener2 = r2;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(m10871a);
                }
            }
        }).start();
    }

    /* renamed from: a */
    private static Class<?> m11592a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
