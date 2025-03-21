package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
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

/* renamed from: com.umeng.message.proguard.t */
/* loaded from: classes2.dex */
public final class C3600t {

    /* renamed from: a */
    private static final C3600t f13352a = new C3600t();

    /* renamed from: b */
    private WeakReference<Activity> f13353b;

    /* renamed from: g */
    private C3599s f13358g;

    /* renamed from: c */
    private final Handler f13354c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private boolean f13355d = true;

    /* renamed from: e */
    private boolean f13356e = false;

    /* renamed from: f */
    private boolean f13357f = false;

    /* renamed from: h */
    private final Runnable f13359h = new Runnable() { // from class: com.umeng.message.proguard.t.1
        @Override // java.lang.Runnable
        public final void run() {
            C3600t c3600t = C3600t.this;
            c3600t.f13356e = !(c3600t.f13356e && C3600t.this.f13355d) && C3600t.this.f13356e;
        }
    };

    /* renamed from: i */
    private final Application.ActivityLifecycleCallbacks f13360i = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.t.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            C3599s unused = C3600t.this.f13358g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                C3600t.this.f13355d = true;
                C3600t.this.f13354c.removeCallbacks(C3600t.this.f13359h);
                C3600t.this.f13354c.postDelayed(C3600t.this.f13359h, 1000L);
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                C3600t.this.f13353b = new WeakReference(activity);
                C3600t.this.f13355d = false;
                C3600t.this.f13354c.removeCallbacks(C3600t.this.f13359h);
                C3600t.this.f13356e = true;
            } catch (Throwable unused) {
            }
            C3599s unused2 = C3600t.this.f13358g;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (C3600t.this.f13358g != null) {
                try {
                    C3561aj m12251a = C3561aj.m12251a();
                    if (m12251a.f13202b) {
                        final String name = activity.getClass().getName();
                        final C3562ak c3562ak = m12251a.f13201a;
                        if (c3562ak.f13204b.m12263a()) {
                            if (!c3562ak.f13204b.f13215a.m12292b("e_s", true)) {
                                if (!(Math.abs(System.currentTimeMillis() - c3562ak.f13204b.m12264b()) > 86400000)) {
                                    return;
                                }
                            }
                            C3563al c3563al = c3562ak.f13204b;
                            if (Math.abs(System.currentTimeMillis() - c3563al.m12264b()) > Math.max(600L, Math.min(c3563al.f13215a.m12289b("req_interval", 1800L), 86400L)) * 1000) {
                                c3562ak.f13204b.f13215a.m12284a("req_ts", System.currentTimeMillis());
                                C3578b.m12327c(new Runnable() { // from class: com.umeng.message.proguard.ak.2
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
                                            if (C3584d.m12361h(C3604x.m12460a())) {
                                                C3562ak c3562ak2 = C3562ak.this;
                                                String str11 = name;
                                                Application m12460a = C3604x.m12460a();
                                                String zid = UMUtils.getZid(m12460a);
                                                if (TextUtils.isEmpty(zid)) {
                                                    UPLog.m12142d("Notify", "zid skip.");
                                                    return;
                                                }
                                                String registrationId = PushAgent.getInstance(m12460a).getRegistrationId();
                                                if (TextUtils.isEmpty(registrationId)) {
                                                    UPLog.m12142d("Notify", "deviceToken skip.");
                                                    return;
                                                }
                                                String messageAppkey = PushAgent.getInstance(m12460a).getMessageAppkey();
                                                if (TextUtils.isEmpty(messageAppkey)) {
                                                    UPLog.m12142d("Notify", "appkey skip.");
                                                    return;
                                                }
                                                String packageName = m12460a.getPackageName();
                                                if (TextUtils.isEmpty(packageName)) {
                                                    UPLog.m12142d("Notify", "pkgName skip.");
                                                    return;
                                                }
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put(C3351bh.f11613al, zid);
                                                jSONObject.put("appkey", messageAppkey);
                                                jSONObject.put("package_name", packageName);
                                                jSONObject.put(C3351bh.f11554F, C3584d.m12356f());
                                                jSONObject.put("device_model", C3584d.m12352d());
                                                jSONObject.put(C3351bh.f11575a, registrationId);
                                                jSONObject.put("os_version", Build.VERSION.RELEASE);
                                                jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
                                                jSONObject.put("app_version", C3584d.m12349b(m12460a));
                                                jSONObject.put("version_code", C3584d.m12345a(m12460a));
                                                jSONObject.put("ts", System.currentTimeMillis());
                                                if (C3584d.m12363i()) {
                                                    jSONObject.put("harmony_ver", C3584d.m12364j());
                                                }
                                                JSONObject jSONObject2 = null;
                                                try {
                                                    jSONObject2 = C3587g.m12400a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/req", messageAppkey, false);
                                                } catch (Exception e2) {
                                                    UPLog.m12142d("Notify", "request fail:", e2.getMessage());
                                                }
                                                if (jSONObject2 == null || jSONObject2.optInt("code") == 13043) {
                                                    return;
                                                }
                                                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                                                if (optJSONObject == null) {
                                                    c3562ak2.f13204b.m12262a(false);
                                                    return;
                                                }
                                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("config");
                                                try {
                                                    if (optJSONObject2 == null) {
                                                        c3562ak2.f13204b.m12262a(false);
                                                        return;
                                                    }
                                                    int optInt = optJSONObject2.optInt("ipad");
                                                    boolean z = optJSONObject2.optInt("aps") == 1;
                                                    c3562ak2.f13204b.f13215a.m12284a("req_interval", optInt);
                                                    c3562ak2.f13204b.m12262a(z);
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
                                                        C3562ak c3562ak3 = c3562ak2;
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
                                                                    boolean m12255a = C3562ak.m12255a(m12460a, str11, optString, optString2, optString3);
                                                                    if (m12255a) {
                                                                        str3 = optString;
                                                                        str4 = str7;
                                                                    } else {
                                                                        str3 = optString;
                                                                        str4 = str7;
                                                                        optJSONObject4.put("msg", "cur:" + packageName + " start failed:" + optString2);
                                                                    }
                                                                    boolean z3 = z2 | m12255a;
                                                                    optJSONObject4.put(ITagManager.SUCCESS, m12255a ? 1 : 0);
                                                                    if (i3 < min - 1) {
                                                                        try {
                                                                            Thread.sleep(500L);
                                                                        } catch (InterruptedException unused) {
                                                                        }
                                                                    }
                                                                    z2 = z3;
                                                                    i3++;
                                                                    c3562ak2 = c3562ak3;
                                                                    str8 = str5;
                                                                    optString = str3;
                                                                    str9 = str6;
                                                                    str7 = str4;
                                                                }
                                                                str3 = optString;
                                                                str4 = str7;
                                                                i3++;
                                                                c3562ak2 = c3562ak3;
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
                                                        c3562ak2 = c3562ak3;
                                                        str8 = str5;
                                                        optString = str3;
                                                        str9 = str6;
                                                        str7 = str4;
                                                    }
                                                    String str13 = optString;
                                                    String str14 = str7;
                                                    String str15 = str8;
                                                    C3562ak c3562ak4 = c3562ak2;
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    JSONObject jSONObject4 = new JSONObject();
                                                    jSONObject4.put("din", C3584d.m12351c(m12460a));
                                                    jSONObject4.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
                                                    jSONObject4.put("push_switch", C3584d.m12372p(m12460a));
                                                    jSONObject3.put("header", jSONObject4);
                                                    JSONObject jSONObject5 = new JSONObject();
                                                    jSONObject5.put("pa", "");
                                                    jSONObject5.put("action_type", 70);
                                                    jSONObject5.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(m12460a).getRegistrationId());
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
                                                    UMWorkDispatch.sendEvent(m12460a, 16385, C3602v.m12452a(), jSONObject3.toString());
                                                    if (z2) {
                                                        try {
                                                            UPushMessageNotifyApi.Callback callback = c3562ak4.f13203a;
                                                            if (callback != null) {
                                                                callback.onNotifying();
                                                            }
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    str = str2;
                                                    UPLog.m12143e(str, th);
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = "Notify";
                                            UPLog.m12143e(str, th);
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

    private C3600t() {
    }

    /* renamed from: c */
    public static boolean m12447c() {
        return f13352a.f13356e;
    }

    /* renamed from: b */
    public static void m12443b() {
        C3600t c3600t = f13352a;
        synchronized (c3600t) {
            if (c3600t.f13358g == null) {
                c3600t.f13358g = new C3599s();
            }
        }
    }

    /* renamed from: a */
    public static void m12440a() {
        C3600t c3600t = f13352a;
        if (c3600t.f13357f) {
            return;
        }
        try {
            Application m12460a = C3604x.m12460a();
            if (m12460a != null) {
                m12460a.registerActivityLifecycleCallbacks(c3600t.f13360i);
                c3600t.f13357f = true;
            }
        } catch (Throwable unused) {
        }
    }
}
