package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

/* JADX INFO: loaded from: classes2.dex */
public final class ak {
    UPushMessageNotifyApi.Callback a;

    /* JADX INFO: renamed from: b */
    public final al f7985b = new al();

    /* JADX INFO: renamed from: c */
    boolean f7986c;

    /* JADX INFO: renamed from: com.umeng.message.proguard.ak$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Exception {
            boolean zA = ak.this.f7985b.a();
            boolean zA2 = false;
            try {
                if (d.h(x.a())) {
                    zA2 = ak.a(zA);
                }
            } catch (Throwable th) {
                UPLog.e("Notify", th);
            }
            ak.this.f7985b.b(!zA2);
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ak$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;

        public AnonymousClass2(String str) {
            name = str;
        }

        /* JADX WARN: Not initialized variable reg: 19, insn: 0x02b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:242:0x02b6 */
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
                ak akVar = ak.this;
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
                    akVar.f7985b.a(false);
                    return;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("config");
                try {
                    if (jSONObjectOptJSONObject2 == null) {
                        akVar.f7985b.a(false);
                        return;
                    }
                    int iOptInt = jSONObjectOptJSONObject2.optInt("ipad");
                    boolean z = jSONObjectOptJSONObject2.optInt("aps") == 1;
                    akVar.f7985b.a.a("req_interval", iOptInt);
                    akVar.f7985b.a(z);
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
                        ak akVar2 = akVar;
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
                                    akVar = akVar2;
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
                                    akVar = akVar2;
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
                        akVar = akVar2;
                        str8 = str5;
                        strOptString = str3;
                        str9 = str6;
                        str7 = str4;
                    }
                    String str13 = strOptString;
                    String str14 = str7;
                    String str15 = str8;
                    ak akVar3 = akVar;
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
                            UPushMessageNotifyApi.Callback callback = akVar3.a;
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
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ak$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Intent f7988b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f7989c;

        AnonymousClass3(Context context, Intent intent, String str) {
            context = context;
            intent = intent;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ak akVar = ak.this;
                Context context = context;
                Intent intent = intent;
                String str = str;
                akVar.f7985b.a(System.currentTimeMillis());
                String stringExtra = intent.getStringExtra("data");
                String stringExtra2 = intent.getStringExtra("pkg");
                intent.removeExtra("data");
                intent.removeExtra("pkg");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String str2 = new String(as.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
                    byte[] bArrA = as.a("bm1ldWcuZjkvT20rTDgyMw==");
                    String strB = ax.b(stringExtra2, str2, bArrA);
                    String strB2 = ax.b(stringExtra, str2, bArrA);
                    if (!TextUtils.isEmpty(strB2) && !TextUtils.isEmpty(strB)) {
                        JSONObject jSONObject = new JSONObject(strB2);
                        jSONObject.put("activity", str);
                        al alVar = akVar.f7985b;
                        String string = jSONObject.toString();
                        String strA = null;
                        if (string != null) {
                            try {
                                strA = as.a(string.getBytes());
                            } catch (Exception unused) {
                            }
                        }
                        alVar.a.a("info", strA);
                        jSONObject.put("action_type", 71);
                        jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
                        jSONObject.put("msg_id", "");
                        jSONObject.put("pa", "");
                        jSONObject.put("ts", System.currentTimeMillis());
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("din", d.c(context));
                        jSONObject3.put(bh.aO, MsgConstant.SDK_VERSION);
                        jSONObject3.put("push_switch", d.p(context));
                        jSONObject2.put("header", jSONObject3);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("push", jSONArray);
                        jSONObject2.put("content", jSONObject4);
                        UMWorkDispatch.sendEvent(context, 16385, v.a(), jSONObject2.toString());
                        try {
                            UPushMessageNotifyApi.Callback callback = akVar.a;
                            if (callback != null) {
                                callback.onNotified();
                                akVar.f7986c = false;
                                return;
                            }
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    akVar.f7985b.a(0L);
                    return;
                }
                akVar.f7985b.a(0L);
            } catch (Throwable th) {
                UPLog.e("Notify", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.message.proguard.ak$4 */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ boolean a;

        AnonymousClass4(boolean z) {
            z = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ak.this.f7985b.b(true);
            boolean zA = false;
            try {
                if (d.h(x.a())) {
                    zA = ak.a(z);
                }
            } catch (Throwable th) {
                UPLog.e("Notify", th);
            }
            ak.this.f7985b.b(!zA);
        }
    }

    public final void a() {
        if (this.f7985b.e()) {
            b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    boolean zA = ak.this.f7985b.a();
                    boolean zA2 = false;
                    try {
                        if (d.h(x.a())) {
                            zA2 = ak.a(zA);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ak.this.f7985b.b(!zA2);
                }
            });
        }
    }

    public final void a(Activity activity, Intent intent) {
        this.f7986c = true;
        if (activity == null || intent == null) {
            return;
        }
        b.b(new Runnable() { // from class: com.umeng.message.proguard.ak.3
            final /* synthetic */ Context a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Intent f7988b;

            /* JADX INFO: renamed from: c */
            final /* synthetic */ String f7989c;

            AnonymousClass3(Context context, Intent intent2, String str) {
                context = context;
                intent = intent2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ak akVar = ak.this;
                    Context context = context;
                    Intent intent2 = intent;
                    String str = str;
                    akVar.f7985b.a(System.currentTimeMillis());
                    String stringExtra = intent2.getStringExtra("data");
                    String stringExtra2 = intent2.getStringExtra("pkg");
                    intent2.removeExtra("data");
                    intent2.removeExtra("pkg");
                    if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                        String str2 = new String(as.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
                        byte[] bArrA = as.a("bm1ldWcuZjkvT20rTDgyMw==");
                        String strB = ax.b(stringExtra2, str2, bArrA);
                        String strB2 = ax.b(stringExtra, str2, bArrA);
                        if (!TextUtils.isEmpty(strB2) && !TextUtils.isEmpty(strB)) {
                            JSONObject jSONObject = new JSONObject(strB2);
                            jSONObject.put("activity", str);
                            al alVar = akVar.f7985b;
                            String string = jSONObject.toString();
                            String strA = null;
                            if (string != null) {
                                try {
                                    strA = as.a(string.getBytes());
                                } catch (Exception unused) {
                                }
                            }
                            alVar.a.a("info", strA);
                            jSONObject.put("action_type", 71);
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, PushAgent.getInstance(context).getRegistrationId());
                            jSONObject.put("msg_id", "");
                            jSONObject.put("pa", "");
                            jSONObject.put("ts", System.currentTimeMillis());
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("din", d.c(context));
                            jSONObject3.put(bh.aO, MsgConstant.SDK_VERSION);
                            jSONObject3.put("push_switch", d.p(context));
                            jSONObject2.put("header", jSONObject3);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("push", jSONArray);
                            jSONObject2.put("content", jSONObject4);
                            UMWorkDispatch.sendEvent(context, 16385, v.a(), jSONObject2.toString());
                            try {
                                UPushMessageNotifyApi.Callback callback = akVar.a;
                                if (callback != null) {
                                    callback.onNotified();
                                    akVar.f7986c = false;
                                    return;
                                }
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        akVar.f7985b.a(0L);
                        return;
                    }
                    akVar.f7985b.a(0L);
                } catch (Throwable th) {
                    UPLog.e("Notify", th);
                }
            }
        });
    }

    static boolean a(boolean z) throws Exception {
        Application applicationA = x.a();
        String zid = UMUtils.getZid(applicationA);
        if (TextUtils.isEmpty(zid)) {
            UPLog.d("Notify", "zid skip.");
            return false;
        }
        String messageAppkey = PushAgent.getInstance(applicationA).getMessageAppkey();
        if (TextUtils.isEmpty(messageAppkey)) {
            UPLog.d("Notify", "appkey skip.");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(bh.al, zid);
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("appkey", messageAppkey);
        jSONObject.put("dps", z ? 1 : 0);
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = g.a(jSONObject, "https://offmsg.umeng.com/v2/offmsg/switch", messageAppkey, false);
        } catch (Exception e2) {
            UPLog.d("Notify", "uploadEnableState error:", e2.getMessage());
        }
        return jSONObjectA != null;
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
            String string = jSONObject.toString();
            String str5 = new String(as.a("dUxpNC9mNCtQYjM5LlQxOQ=="));
            byte[] bArrA = as.a("bm1ldWcuZjkvT20rTDgyMw==");
            String strA = ax.a(context.getPackageName(), str5, bArrA);
            String strA2 = ax.a(string, str5, bArrA);
            Intent intent = new Intent();
            intent.putExtra("data", strA2);
            intent.putExtra("pkg", strA);
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
            if (this.f7985b.c()) {
                String strD = this.f7985b.d();
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strD);
                jSONObject.put("activity", jSONObject2.optString("activity"));
                jSONObject.put("pusor", jSONObject2.optJSONArray("pusor"));
                jSONObject.put("trace_id", jSONObject2.optString("trace_id"));
            }
        } catch (Throwable th) {
            UPLog.e("Notify", "handle msg arrived error:", th);
        }
    }
}
