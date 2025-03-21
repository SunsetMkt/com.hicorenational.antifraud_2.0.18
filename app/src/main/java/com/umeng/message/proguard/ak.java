package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    UPushMessageNotifyApi.Callback f11275a;

    /* renamed from: b, reason: collision with root package name */
    public final al f11276b = new al();

    /* renamed from: c, reason: collision with root package name */
    boolean f11277c;

    public final void a() {
        if (this.f11276b.e()) {
            b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean a2 = ak.this.f11276b.a();
                    boolean z = false;
                    try {
                        if (d.h(x.a())) {
                            z = ak.a(a2);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ak.this.f11276b.b(!z);
                }
            });
        }
    }

    public final void a(Activity activity, final Intent intent) {
        this.f11277c = true;
        if (activity == null || intent == null) {
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        final String name = activity.getClass().getName();
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ak akVar = ak.this;
                    Context context = applicationContext;
                    Intent intent2 = intent;
                    String str = name;
                    akVar.f11276b.a(System.currentTimeMillis());
                    String stringExtra = intent2.getStringExtra("data");
                    String stringExtra2 = intent2.getStringExtra("pkg");
                    intent2.removeExtra("data");
                    intent2.removeExtra("pkg");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String str2 = new String(as.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
                        byte[] a2 = as.a("bm1ldWcuZjkvT20rTDgyMw==");
                        String b2 = ax.b(stringExtra2, str2, a2);
                        String b3 = ax.b(stringExtra, str2, a2);
                        if (!TextUtils.isEmpty(b3) && !TextUtils.isEmpty(b2)) {
                            JSONObject jSONObject = new JSONObject(b3);
                            jSONObject.put("activity", str);
                            al alVar = akVar.f11276b;
                            String jSONObject2 = jSONObject.toString();
                            String str3 = null;
                            if (jSONObject2 != null) {
                                try {
                                    str3 = as.a(jSONObject2.getBytes());
                                } catch (Exception unused) {
                                }
                            }
                            alVar.f11287a.a("info", str3);
                            jSONObject.put("action_type", 71);
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
                            jSONObject.put("msg_id", "");
                            jSONObject.put("pa", "");
                            jSONObject.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("din", d.c(context));
                            jSONObject4.put(bh.aO, MsgConstant.SDK_VERSION);
                            jSONObject4.put("push_switch", d.p(context));
                            jSONObject3.put("header", jSONObject4);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("push", jSONArray);
                            jSONObject3.put("content", jSONObject5);
                            UMWorkDispatch.sendEvent(context, 16385, v.a(), jSONObject3.toString());
                            try {
                                UPushMessageNotifyApi.Callback callback = akVar.f11275a;
                                if (callback != null) {
                                    callback.onNotified();
                                    akVar.f11277c = false;
                                    return;
                                }
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        akVar.f11276b.a(0L);
                        return;
                    }
                    akVar.f11276b.a(0L);
                } catch (Throwable th) {
                    UPLog.e("Notify", th);
                }
            }
        });
    }

    static boolean a(boolean z) throws Exception {
        Application a2 = x.a();
        String zid = UMUtils.getZid(a2);
        if (TextUtils.isEmpty(zid)) {
            UPLog.d("Notify", "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(a2).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.d("Notify", "appkey skip.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(bh.al, zid);
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("appkey", messageAppkey);
        jSONObject.put("dps", z ? 1 : 0);
        JSONObject jSONObject2 = null;
        try {
            jSONObject2 = g.a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/switch", messageAppkey, false);
        } catch (Exception e2) {
            UPLog.d("Notify", "uploadEnableState error:", e2.getMessage());
        }
        return jSONObject2 != null;
    }

    static boolean a(Context context, String str, String str2, String str3, String str4) {
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
            String str5 = new String(as.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
            byte[] a2 = as.a("bm1ldWcuZjkvT20rTDgyMw==");
            String a3 = ax.a(context.getPackageName(), str5, a2);
            String a4 = ax.a(jSONObject3, str5, a2);
            Intent intent = new Intent();
            intent.putExtra("data", a4);
            intent.putExtra("pkg", a3);
            intent.setPackage(str3);
            intent.setComponent(componentName);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (this.f11276b.c()) {
                String d2 = this.f11276b.d();
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(d2);
                jSONObject.put("activity", jSONObject2.optString("activity"));
                jSONObject.put("pusor", jSONObject2.optJSONArray("pusor"));
                jSONObject.put("trace_id", jSONObject2.optString("trace_id"));
            }
        } catch (Throwable th) {
            UPLog.e("Notify", "handle msg arrived error:", th);
        }
    }
}
