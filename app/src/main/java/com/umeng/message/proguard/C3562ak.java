package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.ak */
/* loaded from: classes2.dex */
public final class C3562ak {

    /* renamed from: a */
    UPushMessageNotifyApi.Callback f13203a;

    /* renamed from: b */
    public final C3563al f13204b = new C3563al();

    /* renamed from: c */
    boolean f13205c;

    /* renamed from: a */
    public final void m12257a() {
        if (this.f13204b.m12268e()) {
            C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.ak.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean m12263a = C3562ak.this.f13204b.m12263a();
                    boolean z = false;
                    try {
                        if (C3584d.m12361h(C3604x.m12460a())) {
                            z = C3562ak.m12256a(m12263a);
                        }
                    } catch (Throwable th) {
                        UPLog.m12143e("Notify", th);
                    }
                    C3562ak.this.f13204b.m12265b(!z);
                }
            });
        }
    }

    /* renamed from: a */
    public final void m12258a(Activity activity, final Intent intent) {
        this.f13205c = true;
        if (activity == null || intent == null) {
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        final String name = activity.getClass().getName();
        C3578b.m12325b(new Runnable() { // from class: com.umeng.message.proguard.ak.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C3562ak c3562ak = C3562ak.this;
                    Context context = applicationContext;
                    Intent intent2 = intent;
                    String str = name;
                    c3562ak.f13204b.m12261a(System.currentTimeMillis());
                    String stringExtra = intent2.getStringExtra("data");
                    String stringExtra2 = intent2.getStringExtra("pkg");
                    intent2.removeExtra("data");
                    intent2.removeExtra("pkg");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String str2 = new String(C3570as.m12294a("dUxpNC9mNCtQYjM5LlQxOQ=="));
                        byte[] m12294a = C3570as.m12294a("bm1ldWcuZjkvT20rTDgyMw==");
                        String m12317b = C3575ax.m12317b(stringExtra2, str2, m12294a);
                        String m12317b2 = C3575ax.m12317b(stringExtra, str2, m12294a);
                        if (!TextUtils.isEmpty(m12317b2) && !TextUtils.isEmpty(m12317b)) {
                            JSONObject jSONObject = new JSONObject(m12317b2);
                            jSONObject.put("activity", str);
                            C3563al c3563al = c3562ak.f13204b;
                            String jSONObject2 = jSONObject.toString();
                            String str3 = null;
                            if (jSONObject2 != null) {
                                try {
                                    str3 = C3570as.m12293a(jSONObject2.getBytes());
                                } catch (Exception unused) {
                                }
                            }
                            c3563al.f13215a.m12285a("info", str3);
                            jSONObject.put("action_type", 71);
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
                            jSONObject.put("msg_id", "");
                            jSONObject.put("pa", "");
                            jSONObject.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("din", C3584d.m12351c(context));
                            jSONObject4.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
                            jSONObject4.put("push_switch", C3584d.m12372p(context));
                            jSONObject3.put("header", jSONObject4);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("push", jSONArray);
                            jSONObject3.put("content", jSONObject5);
                            UMWorkDispatch.sendEvent(context, 16385, C3602v.m12452a(), jSONObject3.toString());
                            try {
                                UPushMessageNotifyApi.Callback callback = c3562ak.f13203a;
                                if (callback != null) {
                                    callback.onNotified();
                                    c3562ak.f13205c = false;
                                    return;
                                }
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        c3562ak.f13204b.m12261a(0L);
                        return;
                    }
                    c3562ak.f13204b.m12261a(0L);
                } catch (Throwable th) {
                    UPLog.m12143e("Notify", th);
                }
            }
        });
    }

    /* renamed from: a */
    static boolean m12256a(boolean z) throws Exception {
        Application m12460a = C3604x.m12460a();
        String zid = UMUtils.getZid(m12460a);
        if (TextUtils.isEmpty(zid)) {
            UPLog.m12142d("Notify", "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(m12460a).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.m12142d("Notify", "appkey skip.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(C3351bh.f11613al, zid);
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("appkey", messageAppkey);
        jSONObject.put("dps", z ? 1 : 0);
        JSONObject jSONObject2 = null;
        try {
            jSONObject2 = C3587g.m12400a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/switch", messageAppkey, false);
        } catch (Exception e2) {
            UPLog.m12142d("Notify", "uploadEnableState error:", e2.getMessage());
        }
        return jSONObject2 != null;
    }

    /* renamed from: a */
    static boolean m12255a(Context context, String str, String str2, String str3, String str4) {
        try {
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            ComponentName componentName = new ComponentName(str3, str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", str2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", messageAppkey);
            jSONObject2.put("pkg", context.getPackageName());
            jSONObject2.put("activity", str);
            jSONObject2.put(ITagManager.SUCCESS, 1);
            jSONArray.put(jSONObject2);
            jSONObject.put("pusor", jSONArray);
            String jSONObject3 = jSONObject.toString();
            String str5 = new String(C3570as.m12294a("dUxpNC9mNCtQYjM5LlQxOQ=="));
            byte[] m12294a = C3570as.m12294a("bm1ldWcuZjkvT20rTDgyMw==");
            String m12316a = C3575ax.m12316a(context.getPackageName(), str5, m12294a);
            String m12316a2 = C3575ax.m12316a(jSONObject3, str5, m12294a);
            Intent intent = new Intent();
            intent.putExtra("data", m12316a2);
            intent.putExtra("pkg", m12316a);
            intent.setPackage(str3);
            intent.setComponent(componentName);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final void m12259a(JSONObject jSONObject) {
        try {
            if (this.f13204b.m12266c()) {
                String m12267d = this.f13204b.m12267d();
                if (TextUtils.isEmpty(m12267d)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(m12267d);
                jSONObject.put("activity", jSONObject2.optString("activity"));
                jSONObject.put("pusor", jSONObject2.optJSONArray("pusor"));
                jSONObject.put("trace_id", jSONObject2.optString("trace_id"));
            }
        } catch (Throwable th) {
            UPLog.m12144e("Notify", "handle msg arrived error:", th);
        }
    }
}
