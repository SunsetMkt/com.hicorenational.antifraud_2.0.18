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

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private static final t a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f8087b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private s f8092g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f8088c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8089d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8090e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8091f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f8093h = new Runnable() { // from class: com.umeng.message.proguard.t.1
        @Override // java.lang.Runnable
        public final void run() {
            t tVar = t.this;
            tVar.f8090e = !(tVar.f8090e && t.this.f8089d) && t.this.f8090e;
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f8094i = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.t.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            s unused = t.this.f8092g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                t.this.f8089d = true;
                t.this.f8088c.removeCallbacks(t.this.f8093h);
                t.this.f8088c.postDelayed(t.this.f8093h, 1000L);
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                t.this.f8087b = new WeakReference(activity);
                t.this.f8089d = false;
                t.this.f8088c.removeCallbacks(t.this.f8093h);
                t.this.f8090e = true;
            } catch (Throwable unused) {
            }
            s unused2 = t.this.f8092g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (t.this.f8092g != null) {
                try {
                    aj ajVarA = aj.a();
                    if (ajVarA.f7984b) {
                        final String name = activity.getClass().getName();
                        final ak akVar = ajVarA.a;
                        if (akVar.f7985b.a()) {
                            if (!akVar.f7985b.a.b("e_s", true)) {
                                if (!(Math.abs(System.currentTimeMillis() - akVar.f7985b.b()) > 86400000)) {
                                    return;
                                }
                            }
                            al alVar = akVar.f7985b;
                            if (Math.abs(System.currentTimeMillis() - alVar.b()) > Math.max(600L, Math.min(alVar.a.b("req_interval", 1800L), 86400L)) * 1000) {
                                akVar.f7985b.a.a("req_ts", System.currentTimeMillis());
                                b.c(new Runnable() { // from class: com.umeng.message.proguard.ak.2
                                    /* JADX WARN: Not initialized variable reg: 19, insn: 0x02b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:106:0x02b6 */
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
                                            if (!d.h(x.a())) {
                                                return;
                                            }
                                            ak akVar2 = ak.this;
                                            String str11 = name;
                                            Application applicationA = x.a();
                                            String zid = UMUtils.getZid(applicationA);
                                            if (TextUtils.isEmpty(zid)) {
                                                UPLog.d("Notify", "zid skip.");
                                                return;
                                            }
                                            String registrationId = PushAgent.getInstance(applicationA).getRegistrationId();
                                            if (TextUtils.isEmpty(registrationId)) {
                                                UPLog.d("Notify", "deviceToken skip.");
                                                return;
                                            }
                                            String messageAppkey = PushAgent.getInstance(applicationA).getMessageAppkey();
                                            if (TextUtils.isEmpty(messageAppkey)) {
                                                UPLog.d("Notify", "appkey skip.");
                                                return;
                                            }
                                            String packageName = applicationA.getPackageName();
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
                                            jSONObject.put(bh.a, registrationId);
                                            jSONObject.put("os_version", Build.VERSION.RELEASE);
                                            jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
                                            jSONObject.put("app_version", d.b(applicationA));
                                            jSONObject.put("version_code", d.a(applicationA));
                                            jSONObject.put("ts", System.currentTimeMillis());
                                            if (d.i()) {
                                                jSONObject.put("harmony_ver", d.j());
                                            }
                                            JSONObject jSONObjectA = null;
                                            try {
                                                jSONObjectA = g.a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/req", messageAppkey, false);
                                            } catch (Exception e2) {
                                                UPLog.d("Notify", "request fail:", e2.getMessage());
                                            }
                                            if (jSONObjectA == null || jSONObjectA.optInt("code") == 13043) {
                                                return;
                                            }
                                            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject("data");
                                            if (jSONObjectOptJSONObject == null) {
                                                akVar2.f7985b.a(false);
                                                return;
                                            }
                                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("config");
                                            try {
                                                if (jSONObjectOptJSONObject2 == null) {
                                                    akVar2.f7985b.a(false);
                                                    return;
                                                }
                                                int iOptInt = jSONObjectOptJSONObject2.optInt("ipad");
                                                boolean z = jSONObjectOptJSONObject2.optInt("aps") == 1;
                                                akVar2.f7985b.a.a("req_interval", iOptInt);
                                                akVar2.f7985b.a(z);
                                                String strOptString = jSONObjectOptJSONObject.optString("trace_id");
                                                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("action");
                                                if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) == 0) {
                                                    return;
                                                }
                                                if (length > 5) {
                                                    int i2 = 5;
                                                    while (i2 < length) {
                                                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i2);
                                                        String str12 = str10;
                                                        if (jSONObjectOptJSONObject3 != null) {
                                                            jSONObjectOptJSONObject3.put(ITagManager.SUCCESS, 0);
                                                        }
                                                        i2++;
                                                        str10 = str12;
                                                    }
                                                }
                                                int iMin = Math.min(5, length);
                                                int i3 = 0;
                                                boolean z2 = false;
                                                while (i3 < iMin) {
                                                    ak akVar3 = akVar2;
                                                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i3);
                                                    if (jSONObjectOptJSONObject4 != null) {
                                                        str5 = str8;
                                                        String strOptString2 = jSONObjectOptJSONObject4.optString("pkg");
                                                        String strOptString3 = jSONObjectOptJSONObject4.optString("activity");
                                                        String strOptString4 = jSONObjectOptJSONObject4.optString(str9);
                                                        if (TextUtils.isEmpty(strOptString2)) {
                                                            jSONObjectOptJSONObject4.put(ITagManager.SUCCESS, 0);
                                                            str3 = strOptString;
                                                            str4 = str7;
                                                        } else {
                                                            str6 = str9;
                                                            if (TextUtils.equals(strOptString2, packageName) || TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4)) {
                                                                jSONObjectOptJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                str3 = strOptString;
                                                                str4 = str7;
                                                                i3++;
                                                                akVar2 = akVar3;
                                                                str8 = str5;
                                                                strOptString = str3;
                                                                str9 = str6;
                                                                str7 = str4;
                                                            } else {
                                                                boolean zA = ak.a(applicationA, str11, strOptString, strOptString2, strOptString3);
                                                                if (zA) {
                                                                    str3 = strOptString;
                                                                    str4 = str7;
                                                                } else {
                                                                    str3 = strOptString;
                                                                    str4 = str7;
                                                                    jSONObjectOptJSONObject4.put("msg", "cur:" + packageName + " start failed:" + strOptString2);
                                                                }
                                                                boolean z3 = z2 | zA;
                                                                jSONObjectOptJSONObject4.put(ITagManager.SUCCESS, zA ? 1 : 0);
                                                                if (i3 < iMin - 1) {
                                                                    try {
                                                                        Thread.sleep(500L);
                                                                    } catch (InterruptedException unused) {
                                                                    }
                                                                }
                                                                z2 = z3;
                                                                i3++;
                                                                akVar2 = akVar3;
                                                                str8 = str5;
                                                                strOptString = str3;
                                                                str9 = str6;
                                                                str7 = str4;
                                                            }
                                                        }
                                                    } else {
                                                        str3 = strOptString;
                                                        str4 = str7;
                                                        str5 = str8;
                                                    }
                                                    str6 = str9;
                                                    i3++;
                                                    akVar2 = akVar3;
                                                    str8 = str5;
                                                    strOptString = str3;
                                                    str9 = str6;
                                                    str7 = str4;
                                                }
                                                String str13 = strOptString;
                                                String str14 = str7;
                                                String str15 = str8;
                                                ak akVar4 = akVar2;
                                                JSONObject jSONObject2 = new JSONObject();
                                                JSONObject jSONObject3 = new JSONObject();
                                                jSONObject3.put("din", d.c(applicationA));
                                                jSONObject3.put(bh.aO, MsgConstant.SDK_VERSION);
                                                jSONObject3.put("push_switch", d.p(applicationA));
                                                jSONObject2.put("header", jSONObject3);
                                                JSONObject jSONObject4 = new JSONObject();
                                                jSONObject4.put("pa", "");
                                                jSONObject4.put("action_type", 70);
                                                jSONObject4.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(applicationA).getRegistrationId());
                                                jSONObject4.put("msg_id", "");
                                                jSONObject4.put("activity", str11);
                                                jSONObject4.put("putar", jSONArrayOptJSONArray);
                                                jSONObject4.put(str14, str13);
                                                jSONObject4.put(str15, System.currentTimeMillis());
                                                JSONArray jSONArray = new JSONArray();
                                                jSONArray.put(jSONObject4);
                                                JSONObject jSONObject5 = new JSONObject();
                                                jSONObject5.put("push", jSONArray);
                                                jSONObject2.put("content", jSONObject5);
                                                UMWorkDispatch.sendEvent(applicationA, 16385, v.a(), jSONObject2.toString());
                                                if (z2) {
                                                    try {
                                                        UPushMessageNotifyApi.Callback callback = akVar4.a;
                                                        if (callback != null) {
                                                            callback.onNotifying();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable unused2) {
                                                        return;
                                                    }
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                str = str2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = "Notify";
                                        }
                                        UPLog.e(str, th);
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
        return a.f8090e;
    }

    public static void b() {
        t tVar = a;
        synchronized (tVar) {
            if (tVar.f8092g == null) {
                tVar.f8092g = new s();
            }
        }
    }

    public static void a() {
        t tVar = a;
        if (tVar.f8091f) {
            return;
        }
        try {
            Application applicationA = x.a();
            if (applicationA != null) {
                applicationA.registerActivityLifecycleCallbacks(tVar.f8094i);
                tVar.f8091f = true;
            }
        } catch (Throwable unused) {
        }
    }
}
