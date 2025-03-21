package com.umeng.message.proguard;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.component.UmengMessageHandlerService;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.z */
/* loaded from: classes2.dex */
final class C3606z extends AbstractC3552aa {
    C3606z() {
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    public final void mo12225a(String str, int i2, String str2) throws Exception {
        Object obj;
        int i3;
        NotificationManager notificationManager;
        List<NotificationChannel> notificationChannels;
        Application m12460a = C3604x.m12460a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        Object obj2 = "";
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i2);
        JSONArray jSONArray = new JSONArray();
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) m12460a.getSystemService("notification")) == null || (notificationChannels = notificationManager.getNotificationChannels()) == null) {
            obj = "";
            i3 = -1;
        } else {
            obj = "";
            i3 = -1;
            for (NotificationChannel notificationChannel : notificationChannels) {
                Object obj3 = obj2;
                if (TextUtils.equals(str2, notificationChannel.getId())) {
                    obj2 = notificationChannel.getId();
                    obj = String.valueOf(notificationChannel.getName());
                    i3 = notificationChannel.getImportance();
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("chan_id", notificationChannel.getId());
                    jSONObject4.put("chan_name", String.valueOf(notificationChannel.getName()));
                    jSONObject4.put("chan_imp", notificationChannel.getImportance());
                    jSONArray.put(jSONObject4);
                    obj2 = obj3;
                }
            }
        }
        jSONObject3.put("chan_id", obj2);
        jSONObject3.put("chan_name", obj);
        jSONObject3.put("chan_imp", i3);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", C3600t.m12447c() ? 1 : 0);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (C3586f.m12390b(m12460a)) {
            jSONObject2.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", C3584d.m12351c(m12460a));
            jSONObject2.put("push_switch", C3584d.m12372p(m12460a));
            UMWorkDispatch.sendEvent(m12460a, 16391, C3602v.m12452a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject2);
        jSONObject6.put("jsonBody", jSONObject5);
        jSONObject6.put(RemoteMessageConst.MSGID, str);
        jSONObject6.put("actionType", i2);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(m12460a.getPackageName());
        intent.setClass(m12460a, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject6.toString());
        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: b */
    public final void mo12228b(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application m12460a = C3604x.m12460a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
        String optString = jSONObject.optString("fail", "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
            return;
        }
        JSONObject m12398a = C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/alias/set", UMUtils.getAppkey(m12460a));
        if (m12398a == null || !TextUtils.equals(m12398a.optString("success", ""), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        messageSharedPrefs.m12115a(str, str2, 1, m12398a.optLong(RemoteMessageConst.TTL, 3600L));
        messageSharedPrefs.m12114a("alias_set_", m12398a.optLong(C3351bh.f11599aX));
        uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: c */
    public final void mo12229c(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application m12460a = C3604x.m12460a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
        JSONObject m12398a = C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/alias/delete", UMUtils.getAppkey(m12460a));
        if (m12398a == null || !TextUtils.equals(m12398a.getString("success"), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete failed.");
            return;
        }
        try {
            messageSharedPrefs.f13042a.getContentResolver().delete(C3588h.m12402a(messageSharedPrefs.f13042a), "type=? and alias=?", new String[]{str2, str});
        } catch (Exception e2) {
            UPLog.m12143e("Prefs", e2);
        }
        messageSharedPrefs.m12114a("alias_del_", m12398a.optLong(C3351bh.f11599aX));
        uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete success.");
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    final void mo12226a(String str, String str2, int i2) throws Exception {
        Object obj;
        NotificationManager notificationManager;
        List<NotificationChannel> notificationChannels;
        Application m12460a = C3604x.m12460a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        Object obj2 = "";
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", 9);
        jSONObject3.put("repop_count", i2);
        JSONArray jSONArray = new JSONArray();
        int i3 = -1;
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) m12460a.getSystemService("notification")) == null || (notificationChannels = notificationManager.getNotificationChannels()) == null) {
            obj = "";
        } else {
            obj = "";
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (TextUtils.equals(str2, notificationChannel.getId())) {
                    obj2 = notificationChannel.getId();
                    obj = String.valueOf(notificationChannel.getName());
                    i3 = notificationChannel.getImportance();
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("chan_id", notificationChannel.getId());
                    jSONObject4.put("chan_name", String.valueOf(notificationChannel.getName()));
                    jSONObject4.put("chan_imp", notificationChannel.getImportance());
                    jSONArray.put(jSONObject4);
                    obj2 = obj2;
                }
            }
        }
        jSONObject3.put("chan_id", obj2);
        jSONObject3.put("chan_name", obj);
        jSONObject3.put("chan_imp", i3);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", C3600t.m12447c() ? 1 : 0);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (C3586f.m12390b(m12460a)) {
            jSONObject2.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", C3584d.m12351c(m12460a));
            jSONObject2.put("push_switch", C3584d.m12372p(m12460a));
            UMWorkDispatch.sendEvent(m12460a, 16392, C3602v.m12452a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject2);
        jSONObject6.put("jsonBody", jSONObject5);
        jSONObject6.put(RemoteMessageConst.MSGID, str);
        jSONObject6.put("actionType", 9);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(m12460a.getPackageName());
        intent.setClass(m12460a, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject6.toString());
        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    public final void mo12224a(String str, int i2) throws Exception {
        Application m12460a = C3604x.m12460a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i2);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (C3586f.m12390b(m12460a)) {
            jSONObject2.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", C3584d.m12351c(m12460a));
            jSONObject2.put("push_switch", C3584d.m12372p(m12460a));
            UMWorkDispatch.sendEvent(m12460a, 16385, C3602v.m12452a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("jsonHeader", jSONObject2);
        jSONObject5.put("jsonBody", jSONObject4);
        jSONObject5.put(RemoteMessageConst.MSGID, str);
        jSONObject5.put("actionType", i2);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(m12460a.getPackageName());
        intent.setClass(m12460a, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject5.toString());
        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    public final void mo12222a() throws Exception {
        Application m12460a = C3604x.m12460a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (C3586f.m12390b(m12460a)) {
            jSONObject2.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", C3584d.m12351c(m12460a));
            jSONObject2.put("push_switch", C3584d.m12372p(m12460a));
            UMWorkDispatch.sendEvent(m12460a, InputDeviceCompat.SOURCE_STYLUS, C3602v.m12452a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("jsonHeader", jSONObject2);
        jSONObject5.put("jsonBody", jSONObject4);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(m12460a.getPackageName());
        intent.setClass(m12460a, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_launch");
        intent.putExtra("send_message", jSONObject5.toString());
        AbstractServiceC3597q.enqueueWork(m12460a, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    public final void mo12223a(String str) throws Exception {
        Application m12460a = C3604x.m12460a();
        if (C3586f.m12390b(m12460a)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("din", C3584d.m12351c(m12460a));
            jSONObject2.put(C3351bh.f11590aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("push_switch", C3584d.m12372p(m12460a));
            jSONObject.put("header", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(m12460a).m12131k());
            jSONObject3.put("old_device_token", str);
            try {
                if (C3586f.m12392c(m12460a)) {
                    jSONObject3.put("utdid_gen", 1);
                    String m12393d = C3586f.m12393d(m12460a);
                    if (!TextUtils.isEmpty(m12393d)) {
                        jSONObject3.put("utdid_rst_id", m12393d);
                    }
                    C3586f.m12394e(m12460a);
                }
            } catch (Throwable unused) {
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("push", jSONArray);
            jSONObject.put("content", jSONObject4);
            UMWorkDispatch.sendEvent(m12460a, 16387, C3602v.m12452a(), jSONObject.toString());
        }
    }

    @Override // com.umeng.message.proguard.AbstractC3552aa
    /* renamed from: a */
    public final void mo12227a(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application m12460a = C3604x.m12460a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
        String optString = jSONObject.optString("fail", "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
            return;
        }
        JSONObject m12398a = C3587g.m12398a(jSONObject, "https://msg.umengcloud.com/v3/alias", UMUtils.getAppkey(m12460a));
        if (m12398a != null && TextUtils.equals(m12398a.optString("success", ""), ITagManager.SUCCESS)) {
            messageSharedPrefs.m12115a(str, str2, 0, m12398a.optLong(RemoteMessageConst.TTL, 3600L));
            messageSharedPrefs.m12114a("alias_add_", m12398a.optLong(C3351bh.f11599aX));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
            return;
        }
        uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
    }
}
