package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.ConfigListener;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import i.q2.t.m0;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalDataProtocol.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements UMLogDataProtocol {

    /* JADX INFO: renamed from: b */
    public static final String f7592b = "preInitInvokedFlag";

    /* JADX INFO: renamed from: c */
    public static final String f7593c = "policyGrantInvokedFlag";

    /* JADX INFO: renamed from: d */
    public static final String f7594d = "policyGrantResult";

    /* JADX INFO: renamed from: f */
    private static int f7595f = 1;

    /* JADX INFO: renamed from: e */
    private Context f7603e;
    public static final String a = at.b().b(at.q);

    /* JADX INFO: renamed from: g */
    private static Class<?> f7596g = null;

    /* JADX INFO: renamed from: h */
    private static Method f7597h = null;

    /* JADX INFO: renamed from: i */
    private static Method f7598i = null;

    /* JADX INFO: renamed from: j */
    private static Method f7599j = null;

    /* JADX INFO: renamed from: k */
    private static volatile String f7600k = "";

    /* JADX INFO: renamed from: l */
    private static volatile String f7601l = "";

    /* JADX INFO: renamed from: m */
    private static boolean f7602m = false;

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$1 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ boolean f7604b;

        AnonymousClass1(Context context, boolean z) {
            context = context;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = av.a(context);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(h.f7725c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                    editorEdit.commit();
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                    editorEdit2.putString(h.f7724b, strA);
                    editorEdit2.commit();
                }
                if (z) {
                    UMConfigureImpl.removeInterruptFlag();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$2 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ OnGetOaidListener f7605b;

        AnonymousClass2(Context context, OnGetOaidListener onGetOaidListener) {
            context = context;
            onGetOaidListener = onGetOaidListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = av.a(context);
            OnGetOaidListener onGetOaidListener = onGetOaidListener;
            if (onGetOaidListener != null) {
                onGetOaidListener.onGetOaid(strA);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$3 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    static class AnonymousClass3 implements OnGetOaidListener {
        final /* synthetic */ Context a;

        AnonymousClass3(Context context) {
            context = context;
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                if (sharedPreferences == null || sharedPreferences.getString(h.f7724b, "").equalsIgnoreCase(str)) {
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u66f4\u65b0\u672c\u5730\u7f13\u5b58OAID");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(h.f7724b, str);
                editorEdit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$4 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    class AnonymousClass4 implements OnGetOaidListener {
        AnonymousClass4() {
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID\u4e91\u63a7\u53c2\u6570\u66f4\u65b0(\u4e0d\u91c7\u96c6->\u91c7\u96c6)\uff1a\u91c7\u96c6\u5b8c\u6210");
            if (TextUtils.isEmpty(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid\u8fd4\u56denull\u6216\u8005\u7a7a\u4e32\uff0c\u4e0d\u9700\u8981 \u4f2a\u51b7\u542f\u52a8\u3002");
                return;
            }
            try {
                SharedPreferences sharedPreferences = c.this.f7603e.getSharedPreferences(h.a, 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(h.f7724b, str);
                    editorEdit.commit();
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(c.this.f7603e, a.w, b.a(c.this.f7603e).a(), null);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$5 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    class AnonymousClass5 implements onMessageSendListener {
        AnonymousClass5() {
        }

        @Override // com.umeng.commonsdk.utils.onMessageSendListener
        public void onMessageSend() {
            if (c.this.f7603e != null) {
                UMWorkDispatch.sendEvent(c.this.f7603e, a.x, b.a(c.this.f7603e).a(), null);
            }
            UMConfigureImpl.removeMessageSendListener(this);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.internal.c$6 */
    /* JADX INFO: compiled from: UMInternalDataProtocol.java */
    class AnonymousClass6 implements ConfigListener {
        AnonymousClass6() {
        }

        @Override // com.umeng.ccg.ConfigListener
        public void onConfigReady(JSONObject jSONObject) {
            if (jSONObject == null || !(jSONObject instanceof JSONObject)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject.toString());
            com.umeng.ccg.c.a(c.this.f7603e, 201, com.umeng.ccg.d.a(), jSONObject);
        }
    }

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f7603e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f7601l)) {
            return f7601l;
        }
        Class<?> cls = f7596g;
        if (cls == null || (method = f7597h) == null || f7599j == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return "";
            }
            String str = (String) f7599j.invoke(objInvoke, new Object[0]);
            try {
                f7601l = str;
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
                f7596g = cls;
                Method declaredMethod = f7596g.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    f7597h = declaredMethod;
                }
                Method declaredMethod2 = f7596g.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    f7598i = declaredMethod2;
                }
                Method declaredMethod3 = f7596g.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    f7599j = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bj bjVarA = bj.a(this.f7603e);
        bk bkVarA = bjVarA.a(bl.f7100c);
        if (bkVarA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u6210\u771f\u6b63\u4fe1\u5c01\u3002");
            try {
                String str = bkVarA.a;
                String str2 = bkVarA.f7094b;
                JSONObject jSONObjectA = new com.umeng.commonsdk.statistics.b().a(this.f7603e.getApplicationContext(), new JSONObject(bkVarA.f7095c), new JSONObject(bkVarA.f7096d), bkVarA.f7097e, str2, bkVarA.f7098f);
                if (jSONObjectA == null || !jSONObjectA.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u771f\u6b63\u4fe1\u5c01 \u6210\u529f! \u5220\u9664\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u3002");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [\u6709\u72b6\u6001]\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55\u6784\u5efa\u771f\u6b63\u4fe1\u5c01 \u5931\u8d25\u3002\u5220\u9664\u4e8c\u7ea7\u7f13\u5b58\u8bb0\u5f55");
                }
                bjVarA.a(bl.f7100c, str);
                bjVarA.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (f7602m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            f7602m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f7602m = true;
            a(this.f7603e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                AnonymousClass4() {
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID\u4e91\u63a7\u53c2\u6570\u66f4\u65b0(\u4e0d\u91c7\u96c6->\u91c7\u96c6)\uff1a\u91c7\u96c6\u5b8c\u6210");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid\u8fd4\u56denull\u6216\u8005\u7a7a\u4e32\uff0c\u4e0d\u9700\u8981 \u4f2a\u51b7\u542f\u52a8\u3002");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f7603e.getSharedPreferences(h.a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString(h.f7724b, str);
                            editorEdit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f7603e, a.w, b.a(c.this.f7603e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f7602m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f7603e);
            f7595f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u8981\u8bfb\u53d6 oaid\uff0c\u9700\u7b49\u5f85\u8bfb\u53d6\u7ed3\u679c.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                AnonymousClass5() {
                }

                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f7603e != null) {
                        UMWorkDispatch.sendEvent(c.this.f7603e, a.x, b.a(c.this.f7603e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f7603e, true);
        }
    }

    private void g() {
        if (f7595f <= 0) {
            h();
            e(this.f7603e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u771f\u5b9e\u6784\u5efa\u6761\u4ef6\u6ee1\u8db3\uff0c\u5f00\u59cb\u6784\u5efa\u4e1a\u52a1\u4fe1\u5c01\u3002");
        if (UMUtils.isMainProgress(this.f7603e)) {
            f(this.f7603e);
            UMInnerManager.sendInnerPackage(this.f7603e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f7603e)) {
                Context context = this.f7603e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, com.heytap.mcssdk.constant.a.r);
            }
            Context context2 = this.f7603e;
            UMWorkDispatch.sendEvent(context2, o.a.y, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f7603e;
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

    /* JADX WARN: Removed duplicated region for block: B:289:0x02b7  */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void workEvent(Object obj, int i2) throws JSONException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        SharedPreferences.Editor editorEdit;
        boolean z = true;
        boolean z2 = false;
        ULog.i("walle", "[internal] workEvent");
        if (com.umeng.commonsdk.utils.c.a()) {
            if (32802 == i2) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u9759\u9ed8\u6a21\u5f0f\uff1a\u8fdb\u5165\u5fc3\u8df3\u5904\u7406\u903b\u8f91!");
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jB = com.umeng.commonsdk.utils.c.b(this.f7603e);
                boolean zE = com.umeng.commonsdk.utils.c.e(this.f7603e);
                if (com.umeng.commonsdk.utils.c.a(jB, jCurrentTimeMillis, com.umeng.commonsdk.utils.c.a(this.f7603e))) {
                    if (UMFrUtils.hasEnvelopeFile(this.f7603e, UMLogDataProtocol.UMBusinessType.U_Silent)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u9759\u9ed8\u5fc3\u8df3\u4fe1\u5c01\u6587\u4ef6\u5df2\u5b58\u5728\uff0c\u5c1d\u8bd5\u53d1\u9001\u4e4b!");
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u9759\u9ed8\u5fc3\u8df3\u4fe1\u5c01.");
                        b(this.f7603e);
                    }
                    UMEnvelopeBuild.registerNetReceiver(this.f7603e);
                }
                if (zE) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send REBUILD_DB msg in silent mode.");
                Context context = this.f7603e;
                UMWorkDispatch.sendEvent(context, o.a.p, CoreProtocol.getInstance(context), null, 2000L);
            }
            return;
        }
        try {
            switch (i2) {
                case a.f7581f /* 32769 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    if (cls != null) {
                        cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.f7603e);
                    }
                    break;
                case a.f7583h /* 32771 */:
                    if (obj != null && (obj instanceof com.umeng.commonsdk.internal.utils.b)) {
                        JSONObject jSONObject = new JSONObject();
                        com.umeng.commonsdk.internal.utils.b bVar = (com.umeng.commonsdk.internal.utils.b) obj;
                        try {
                            jSONObject.put("le", bVar.a);
                            jSONObject.put("vol", bVar.f7607b);
                            jSONObject.put("temp", bVar.f7608c);
                            jSONObject.put("st", bVar.f7609d);
                            jSONObject.put("ct", bVar.f7610e);
                            jSONObject.put("ts", bVar.f7611f);
                            break;
                        } catch (Throwable unused) {
                        }
                        String string = jSONObject.toString();
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "battery info: " + string);
                        Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                        if (cls2 != null) {
                            cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.f7603e, string);
                        }
                        break;
                    }
                    break;
                case a.f7587l /* 32775 */:
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    if (cls3 != null) {
                        cls3.getMethod("saveUA", Context.class, String.class).invoke(cls3, this.f7603e, (String) obj);
                    }
                    break;
                case a.f7589n /* 32777 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(bh.aQ, a.f7580e);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(bh.ax, new JSONObject());
                    JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f7603e, jSONObject2, jSONObject3);
                    if (jSONObjectBuildEnvelopeWithExtHeader != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                        ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                        break;
                    }
                    break;
                case a.o /* 32779 */:
                    Sender.handleEvent(this.f7603e, (com.umeng.commonsdk.vchannel.b) obj);
                    break;
                case a.p /* 32781 */:
                    if (!UMFrUtils.hasEnvelopeFile(this.f7603e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u96f6\u53f7\u62a5\u6587");
                        a(this.f7603e);
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u96f6\u53f7\u62a5\u6587\u4fe1\u5c01\u6587\u4ef6\u5df2\u5b58\u5728\uff0c\u5c1d\u8bd5\u53d1\u9001\u4e4b!");
                    }
                    break;
                case a.s /* 32784 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u96f6\u53f7\u62a5\u6587\u6d41\u7a0b\uff0c\u63a5\u6536\u5230\u4e91\u63a7\u914d\u7f6e\u52a0\u8f7d\u6210\u529f\u901a\u77e5(\u6210\u529f\u6536\u5230\u96f6\u53f7\u62a5\u6587\u5e94\u7b54)\u3002");
                    f();
                    f7595f--;
                    g();
                    UMUtils.saveSDKComponent();
                    break;
                case a.t /* 32785 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [\u6709\u72b6\u6001]\u63a5\u6536\u5230\u6d88\u8d39\u4e8c\u7ea7\u7f13\u5b58\u6570\u636e\u901a\u77e5.");
                    if (!bj.a(this.f7603e).c()) {
                        d();
                        if (!UMWorkDispatch.eventHasExist(a.t)) {
                            Context context2 = this.f7603e;
                            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
                        }
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [\u6709\u72b6\u6001]\u5df2\u6d88\u8d39\u5b8c\u6bd5,\u4e8c\u7ea7\u7f13\u5b58\u6570\u636e\u5e93\u4e3a\u7a7a.");
                    }
                    break;
                case a.u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.f7603e, obj);
                    break;
                case a.v /* 32787 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u89e6\u53d12\u53f7\u4ed3\u9057\u7559\u4fe1\u5c01\u68c0\u67e5\u52a8\u4f5c\u3002");
                    String strA = com.umeng.commonsdk.stateless.d.a(this.f7603e, false);
                    String strA2 = com.umeng.commonsdk.stateless.d.a(this.f7603e, true);
                    if (!TextUtils.isEmpty(strA)) {
                        File file = new File(strA);
                        if (file.exists() && file.isDirectory()) {
                            z2 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(strA2)) {
                        File file2 = new File(strA2);
                        if (!file2.exists() || !file2.isDirectory()) {
                            z = z2;
                        }
                    }
                    if (!z) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u89e6\u53d12\u53f7\u4ed3\u9057\u7559\u4fe1\u5c01\u68c0\u67e5\uff0c\u6ca1\u6709\u9700\u8981\u5904\u7406\u7684\u76ee\u5f55\uff0c\u4e0d\u9700\u8981\u5904\u7406\u3002");
                    } else if (!com.umeng.commonsdk.stateless.b.a()) {
                        new com.umeng.commonsdk.stateless.b(this.f7603e);
                        com.umeng.commonsdk.stateless.b.b();
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u89e6\u53d12\u53f7\u4ed3\u9057\u7559\u4fe1\u5c01\u68c0\u67e5\uff0cSender\u5df2\u521b\u5efa\uff0c\u4e0d\u9700\u8981\u5904\u7406\u3002");
                    }
                    break;
                case a.w /* 32788 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4e91\u63a7\u4e0b\u53d1\u53c2\u6570\u66f4\u65b0\uff0c\u89e6\u53d1 \u4f2a\u51b7\u542f\u52a8\u3002");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4e91\u63a7\u4e0b\u53d1\u53c2\u6570\u66f4\u65b0 \u524d\u53f0\u8ba1\u6570\u5668\u529f\u80fd \u6253\u5f00\uff0c\u89e6\u53d1 5\u79d2\u5468\u671f\u68c0\u67e5\u673a\u5236");
                        Context context3 = this.f7603e;
                        UMWorkDispatch.sendEventEx(context3, o.a.D, CoreProtocol.getInstance(context3), null, com.heytap.mcssdk.constant.a.r);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4e91\u63a7\u4e0b\u53d1\u53c2\u6570\u66f4\u65b0 FirstResume\u529f\u80fd \u6253\u5f00\uff0c\u89e6\u53d1 trigger");
                        l.a(this.f7603e).b(this.f7603e);
                    }
                    break;
                case a.x /* 32790 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6210\u529f\u63a5\u6536\u5230(OAID)\u8bfb\u53d6\u7ed3\u675f\u901a\u77e5\u3002");
                    f7595f--;
                    g();
                    break;
                case a.y /* 32791 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6b63\u5e38\u51b7\u542f\u52a8\u6d41\u7a0b\uff0c\u63a5\u6536\u5230\u4e91\u63a7\u914d\u7f6e\u52a0\u8f7d\u6210\u529f\u901a\u77e5\u3002");
                    UMInnerManager.sendInnerPackage(this.f7603e);
                    if (!FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f7603e)) {
                        Context context4 = this.f7603e;
                        UMWorkDispatch.sendEvent(context4, a.G, b.a(context4).a(), null, com.heytap.mcssdk.constant.a.r);
                    }
                    e(this.f7603e);
                    UMUtils.saveSDKComponent();
                    break;
                case a.z /* 32792 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4fdd\u5b58\u9690\u79c1\u6388\u6743\u7ed3\u679c.");
                    if (obj instanceof Integer) {
                        int iIntValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences = this.f7603e.getApplicationContext().getSharedPreferences(a, 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putInt("policyGrantResult", iIntValue).commit();
                        }
                    }
                    break;
                case a.A /* 32793 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u4fdd\u5b58preInit\u6267\u884c\u7ed3\u679c\u53ca\u6388\u6743API\u662f\u5426\u8c03\u7528\u7ed3\u679c.");
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject4 = (JSONObject) obj;
                        if (jSONObject4.has(a.J)) {
                            int i3 = jSONObject4.getInt(a.J);
                            int i4 = jSONObject4.getInt(a.K);
                            int i5 = jSONObject4.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences2 = this.f7603e.getApplicationContext().getSharedPreferences(a, 0);
                            if (sharedPreferences2 != null && (editorEdit = sharedPreferences2.edit()) != null) {
                                editorEdit.putInt(f7592b, i3);
                                editorEdit.putInt(f7593c, i4);
                                editorEdit.putInt("policyGrantResult", i5);
                                editorEdit.commit();
                            }
                            File file3 = new File(this.f7603e.getFilesDir().getAbsolutePath() + File.separator + bl.f7110m);
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                        }
                    }
                    break;
                case a.B /* 32800 */:
                    File file4 = new File(this.f7603e.getFilesDir().getAbsolutePath() + File.separator + bl.f7110m);
                    if (file4.exists()) {
                        file4.delete();
                    }
                    break;
                case a.C /* 32801 */:
                    SelfChecker.doCheck(this.f7603e);
                    break;
                case a.E /* 32803 */:
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.f7603e.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> ConnectivityManager is null!");
                        com.umeng.commonsdk.framework.a.a(false);
                        com.umeng.commonsdk.stateless.b.a(false);
                    } else {
                        try {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo == null) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> NetworkInfo is null!");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            } else if (activeNetworkInfo.isAvailable()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: Available");
                                com.umeng.commonsdk.framework.a.a(true);
                                com.umeng.commonsdk.stateless.b.a(true);
                            } else {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network state changed: unAvailable");
                                com.umeng.commonsdk.framework.a.a(false);
                                com.umeng.commonsdk.stateless.b.a(false);
                            }
                        } catch (Throwable unused2) {
                            com.umeng.commonsdk.framework.a.a(false);
                            com.umeng.commonsdk.stateless.b.a(false);
                            return;
                        }
                    }
                    break;
                case a.F /* 32804 */:
                    d(this.f7603e);
                    break;
                case a.G /* 32805 */:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv CLOUD_CONFIG_TRIGGER msg.");
                    CcgAgent.registerConfigListener(new ConfigListener() { // from class: com.umeng.commonsdk.internal.c.6
                        AnonymousClass6() {
                        }

                        @Override // com.umeng.ccg.ConfigListener
                        public void onConfigReady(JSONObject jSONObject5) {
                            if (jSONObject5 == null || !(jSONObject5 instanceof JSONObject)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject5.toString());
                            com.umeng.ccg.c.a(c.this.f7603e, 201, com.umeng.ccg.d.a(), jSONObject5);
                        }
                    });
                    SharedPreferences sharedPreferencesA = aq.a(this.f7603e);
                    if (sharedPreferencesA != null) {
                        long j2 = sharedPreferencesA.getLong(aq.a, 0L);
                        if (j2 < m0.f12222b) {
                            j2++;
                        }
                        sharedPreferencesA.edit().putLong(aq.a, j2).commit();
                    }
                    CcgAgent.init(this.f7603e);
                    break;
            }
        } catch (Throwable unused3) {
        }
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f7600k)) {
            return f7600k;
        }
        Class<?> cls = f7596g;
        if (cls == null || (method = f7597h) == null || f7598i == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return "";
            }
            String str = (String) f7598i.invoke(objInvoke, this.f7603e);
            try {
                f7600k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("umid"), strImprintProperty);
            JSONObject jSONObjectBuildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (jSONObjectBuildSilentEnvelopeWithExtHeader != null && jSONObjectBuildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u5fc3\u8df3\u62a5\u6587\u5931\u8d25.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u5fc3\u8df3\u62a5\u6587 \u6210\u529f!!!");
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
            JSONObject jSONObjectBuildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (jSONObjectBuildZeroEnvelopeWithExtHeader != null && jSONObjectBuildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u96f6\u53f7\u62a5\u6587\u5931\u8d25.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u6784\u5efa\u96f6\u53f7\u62a5\u6587 \u6210\u529f!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object objInvoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> clsA = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = clsA.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (objInvoke = declaredMethod2.invoke(clsA, new Object[0])) == null || (declaredMethod = clsA.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(objInvoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                final /* synthetic */ Context a;

                AnonymousClass3(Context context2) {
                    context = context2;
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.f7724b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u66f4\u65b0\u672c\u5730\u7f13\u5b58OAID");
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.f7724b, str);
                        editorEdit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bl.f7109l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            final /* synthetic */ Context a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ boolean f7604b;

            AnonymousClass1(Context context2, boolean z2) {
                context = context2;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strA = av.a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.f7725c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                        editorEdit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                        editorEdit2.putString(h.f7724b, strA);
                        editorEdit2.commit();
                    }
                    if (z) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private void d(Context context) {
        long jLongValue;
        long jLongValue2;
        if (context == null) {
            return;
        }
        String strA = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.DEBUG_KEY);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String strA2 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME);
        String strA3 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD);
        if (TextUtils.isEmpty(strA2)) {
            jLongValue = 0;
        } else {
            try {
                jLongValue = Long.valueOf(strA2).longValue();
            } catch (Throwable unused) {
                jLongValue = 0;
            }
        }
        if (TextUtils.isEmpty(strA3)) {
            jLongValue2 = 0;
        } else {
            try {
                jLongValue2 = Long.valueOf(strA3).longValue();
            } catch (Throwable unused2) {
                jLongValue2 = 0;
            }
        }
        if (jLongValue == 0 || jLongValue2 == 0) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]\u672c\u5730\u7f13\u5b58startTime\u6216\u8005duration\u503c\u65e0\u6548\uff0c\u6e05\u9664\u7f13\u5b58\u6570\u636e");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            return;
        }
        if (System.currentTimeMillis() - jLongValue > jLongValue2 * 60 * 1000) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]\u672c\u5730\u7f13\u5b58dk\u503c\u5df2\u7ecf\u8d85\u65f6\uff0c\u6e05\u9664\u7f13\u5b58\u6570\u636e\u3002");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                AnalyticsConfig.turnOffRealTimeDebug();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put(AnalyticsConfig.DEBUG_KEY, strA);
        if (AnalyticsConfig.isRealTimeDebugMode()) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]\u672c\u5730\u7f13\u5b58dk\u503c\u5728\u6709\u6548\u671f\u5185\uff0c\u5207\u6362\u5230\u57cb\u70b9\u9a8c\u8bc1\u6a21\u5f0f\u3002");
        AnalyticsConfig.turnOnRealTimeDebug(map);
    }

    private static void a(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            final /* synthetic */ Context a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ OnGetOaidListener f7605b;

            AnonymousClass2(Context context2, OnGetOaidListener onGetOaidListener2) {
                context = context2;
                onGetOaidListener = onGetOaidListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strA = av.a(context);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(strA);
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
