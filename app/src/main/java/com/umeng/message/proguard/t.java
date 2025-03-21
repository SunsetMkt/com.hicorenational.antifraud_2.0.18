package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final t f11424a = new t();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f11425b;

    /* renamed from: g, reason: collision with root package name */
    private s f11430g;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f11426c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private boolean f11427d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11428e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11429f = false;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f11431h = new Runnable() { // from class: com.umeng.message.proguard.t.1
        @Override // java.lang.Runnable
        public final void run() {
            t tVar = t.this;
            tVar.f11428e = !(tVar.f11428e && t.this.f11427d) && t.this.f11428e;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f11432i = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.t.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            s unused = t.this.f11430g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                t.this.f11427d = true;
                t.this.f11426c.removeCallbacks(t.this.f11431h);
                t.this.f11426c.postDelayed(t.this.f11431h, 1000L);
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                t.this.f11425b = new WeakReference(activity);
                t.this.f11427d = false;
                t.this.f11426c.removeCallbacks(t.this.f11431h);
                t.this.f11428e = true;
            } catch (Throwable unused) {
            }
            s unused2 = t.this.f11430g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (t.this.f11430g != null) {
                try {
                    aj a2 = aj.a();
                    if (a2.f11274b) {
                        final String name = activity.getClass().getName();
                        final ak akVar = a2.f11273a;
                        if (akVar.f11276b.a()) {
                            if (!akVar.f11276b.f11287a.b("e_s", true)) {
                                if (!(Math.abs(System.currentTimeMillis() - akVar.f11276b.b()) > 86400000)) {
                                    return;
                                }
                            }
                            al alVar = akVar.f11276b;
                            if (Math.abs(System.currentTimeMillis() - alVar.b()) > Math.max(600L, Math.min(alVar.f11287a.b("req_interval", 1800L), 86400L)) * 1000) {
                                akVar.f11276b.f11287a.a("req_ts", System.currentTimeMillis());
                                b.c(new Runnable() { // from class: com.umeng.message.proguard.ak.2

                                    /* renamed from: a */
                                    final /* synthetic */ String f11279a;

                                    public AnonymousClass2(final String name2) {
                                        r2 = name2;
                                    }

                                    /* JADX WARN: Not initialized variable reg: 19, insn: 0x02b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:123:0x02b6 */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        String str;
                                        String str2;
                                        int length;
                                        String str3;
                                        String str4;
                                        String str5;
                                        String str6;
                                        String str7 = "trace_id";
                                        String str8 = "ts";
                                        String str9 = "appkey";
                                        String str10 = "Notify";
                                        try {
                                            if (d.h(x.a())) {
                                                ak akVar2 = ak.this;
                                                String str11 = r2;
                                                Application a3 = x.a();
                                                String zid = UMUtils.getZid(a3);
                                                if (TextUtils.isEmpty(zid)) {
                                                    UPLog.d("Notify", "zid skip.");
                                                    return;
                                                }
                                                String registrationId = PushAgent.getInstance(a3).getRegistrationId();
                                                if (TextUtils.isEmpty(registrationId)) {
                                                    UPLog.d("Notify", "deviceToken skip.");
                                                    return;
                                                }
                                                String messageAppkey = PushAgent.getInstance(a3).getMessageAppkey();
                                                if (TextUtils.isEmpty(messageAppkey)) {
                                                    UPLog.d("Notify", "appkey skip.");
                                                    return;
                                                }
                                                String packageName = a3.getPackageName();
                                                if (TextUtils.isEmpty(packageName)) {
                                                    UPLog.d("Notify", "pkgName skip.");
                                                    return;
                                                }
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put(bh.al, zid);
                                                jSONObject.put("appkey", messageAppkey);
                                                jSONObject.put("package_name", packageName);
                                                jSONObject.put(bh.F, d.f());
                                                jSONObject.put("device_model", d.d());
                                                jSONObject.put(bh.f10116a, registrationId);
                                                jSONObject.put("os_version", Build.VERSION.RELEASE);
                                                jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
                                                jSONObject.put("app_version", d.b(a3));
                                                jSONObject.put("version_code", d.a(a3));
                                                jSONObject.put("ts", System.currentTimeMillis());
                                                if (d.i()) {
                                                    jSONObject.put("harmony_ver", d.j());
                                                }
                                                JSONObject jSONObject2 = null;
                                                try {
                                                    jSONObject2 = g.a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/req", messageAppkey, false);
                                                } catch (Exception e2) {
                                                    UPLog.d("Notify", "request fail:", e2.getMessage());
                                                }
                                                if (jSONObject2 == null || jSONObject2.optInt("code") == 13043) {
                                                    return;
                                                }
                                                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                                                if (optJSONObject == null) {
                                                    akVar2.f11276b.a(false);
                                                    return;
                                                }
                                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("config");
                                                try {
                                                    if (optJSONObject2 == null) {
                                                        akVar2.f11276b.a(false);
                                                        return;
                                                    }
                                                    int optInt = optJSONObject2.optInt("ipad");
                                                    boolean z = optJSONObject2.optInt("aps") == 1;
                                                    akVar2.f11276b.f11287a.a("req_interval", optInt);
                                                    akVar2.f11276b.a(z);
                                                    String optString = optJSONObject.optString("trace_id");
                                                    JSONArray optJSONArray = optJSONObject.optJSONArray("action");
                                                    if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                                                        return;
                                                    }
                                                    if (length > 5) {
                                                        int i2 = 5;
                                                        while (i2 < length) {
                                                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                                                            String str12 = str10;
                                                            if (optJSONObject3 != null) {
                                                                optJSONObject3.put(ITagManager.SUCCESS, 0);
                                                            }
                                                            i2++;
                                                            str10 = str12;
                                                        }
                                                    }
                                                    int min = Math.min(5, length);
                                                    int i3 = 0;
                                                    boolean z2 = false;
                                                    while (i3 < min) {
                                                        ak akVar3 = akVar2;
                                                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
                                                        if (optJSONObject4 != null) {
                                                            str5 = str8;
                                                            String optString2 = optJSONObject4.optString("pkg");
                                                            String optString3 = optJSONObject4.optString("activity");
                                                            String optString4 = optJSONObject4.optString(str9);
                                                            if (TextUtils.isEmpty(optString2)) {
                                                                optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                str3 = optString;
                                                                str4 = str7;
                                                            } else {
                                                                str6 = str9;
                                                                if (TextUtils.equals(optString2, packageName)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else if (TextUtils.isEmpty(optString3)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else if (TextUtils.isEmpty(optString4)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else {
                                                                    boolean a4 = ak.a(a3, str11, optString, optString2, optString3);
                                                                    if (a4) {
                                                                        str3 = optString;
                                                                        str4 = str7;
                                                                    } else {
                                                                        str3 = optString;
                                                                        str4 = str7;
                                                                        optJSONObject4.put("msg", "cur:" + packageName + " start failed:" + optString2);
                                                                    }
                                                                    boolean z3 = z2 | a4;
                                                                    optJSONObject4.put(ITagManager.SUCCESS, a4 ? 1 : 0);
                                                                    if (i3 < min - 1) {
                                                                        try {
                                                                            Thread.sleep(500L);
                                                                        } catch (InterruptedException unused) {
                                                                        }
                                                                    }
                                                                    z2 = z3;
                                                                    i3++;
                                                                    akVar2 = akVar3;
                                                                    str8 = str5;
                                                                    optString = str3;
                                                                    str9 = str6;
                                                                    str7 = str4;
                                                                }
                                                                str3 = optString;
                                                                str4 = str7;
                                                                i3++;
                                                                akVar2 = akVar3;
                                                                str8 = str5;
                                                                optString = str3;
                                                                str9 = str6;
                                                                str7 = str4;
                                                            }
                                                        } else {
                                                            str3 = optString;
                                                            str4 = str7;
                                                            str5 = str8;
                                                        }
                                                        str6 = str9;
                                                        i3++;
                                                        akVar2 = akVar3;
                                                        str8 = str5;
                                                        optString = str3;
                                                        str9 = str6;
                                                        str7 = str4;
                                                    }
                                                    String str13 = optString;
                                                    String str14 = str7;
                                                    String str15 = str8;
                                                    ak akVar4 = akVar2;
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    JSONObject jSONObject4 = new JSONObject();
                                                    jSONObject4.put("din", d.c(a3));
                                                    jSONObject4.put(bh.aO, MsgConstant.SDK_VERSION);
                                                    jSONObject4.put("push_switch", d.p(a3));
                                                    jSONObject3.put("header", jSONObject4);
                                                    JSONObject jSONObject5 = new JSONObject();
                                                    jSONObject5.put("pa", "");
                                                    jSONObject5.put("action_type", 70);
                                                    jSONObject5.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(a3).getRegistrationId());
                                                    jSONObject5.put("msg_id", "");
                                                    jSONObject5.put("activity", str11);
                                                    jSONObject5.put("putar", optJSONArray);
                                                    jSONObject5.put(str14, str13);
                                                    jSONObject5.put(str15, System.currentTimeMillis());
                                                    JSONArray jSONArray = new JSONArray();
                                                    jSONArray.put(jSONObject5);
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    jSONObject6.put("push", jSONArray);
                                                    jSONObject3.put("content", jSONObject6);
                                                    UMWorkDispatch.sendEvent(a3, 16385, v.a(), jSONObject3.toString());
                                                    if (z2) {
                                                        try {
                                                            UPushMessageNotifyApi.Callback callback = akVar4.f11275a;
                                                            if (callback != null) {
                                                                callback.onNotifying();
                                                            }
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    str = str2;
                                                    UPLog.e(str, th);
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = "Notify";
                                            UPLog.e(str, th);
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    };

    private t() {
    }

    public static boolean c() {
        return f11424a.f11428e;
    }

    public static void b() {
        t tVar = f11424a;
        synchronized (tVar) {
            if (tVar.f11430g == null) {
                tVar.f11430g = new s();
            }
        }
    }

    public static void a() {
        t tVar = f11424a;
        if (tVar.f11429f) {
            return;
        }
        try {
            Application a2 = x.a();
            if (a2 != null) {
                a2.registerActivityLifecycleCallbacks(tVar.f11432i);
                tVar.f11429f = true;
            }
        } catch (Throwable unused) {
        }
    }
}
