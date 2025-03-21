package com.umeng.message.proguard;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
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

/* loaded from: classes2.dex */
final class z extends aa {
    z() {
    }

    @Override // com.umeng.message.proguard.aa
    public final void a(String str, int i2, String str2) throws Exception {
        Object obj;
        int i3;
        NotificationManager notificationManager;
        List<NotificationChannel> notificationChannels;
        Application a2 = x.a();
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
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) a2.getSystemService("notification")) == null || (notificationChannels = notificationManager.getNotificationChannels()) == null) {
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
        jSONObject3.put("fg_stat", t.c() ? 1 : 0);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(a2).k());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a2)) {
            jSONObject2.put(bh.aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a2));
            jSONObject2.put("push_switch", d.p(a2));
            UMWorkDispatch.sendEvent(a2, 16391, v.a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject2);
        jSONObject6.put("jsonBody", jSONObject5);
        jSONObject6.put(RemoteMessageConst.MSGID, str);
        jSONObject6.put("actionType", i2);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(a2.getPackageName());
        intent.setClass(a2, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject6.toString());
        q.enqueueWork(a2, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.aa
    public final void b(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application a2 = x.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
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
        JSONObject a3 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/set", UMUtils.getAppkey(a2));
        if (a3 == null || !TextUtils.equals(a3.optString("success", ""), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
            return;
        }
        messageSharedPrefs.a(str, str2, 1, a3.optLong(RemoteMessageConst.TTL, 3600L));
        messageSharedPrefs.a("alias_set_", a3.optLong(bh.aX));
        uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
    }

    @Override // com.umeng.message.proguard.aa
    public final void c(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application a2 = x.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
        JSONObject a3 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/delete", UMUtils.getAppkey(a2));
        if (a3 == null || !TextUtils.equals(a3.getString("success"), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete failed.");
            return;
        }
        try {
            messageSharedPrefs.f11127a.getContentResolver().delete(h.a(messageSharedPrefs.f11127a), "type=? and alias=?", new String[]{str2, str});
        } catch (Exception e2) {
            UPLog.e("Prefs", e2);
        }
        messageSharedPrefs.a("alias_del_", a3.optLong(bh.aX));
        uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete success.");
    }

    @Override // com.umeng.message.proguard.aa
    final void a(String str, String str2, int i2) throws Exception {
        Object obj;
        NotificationManager notificationManager;
        List<NotificationChannel> notificationChannels;
        Application a2 = x.a();
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
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) a2.getSystemService("notification")) == null || (notificationChannels = notificationManager.getNotificationChannels()) == null) {
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
        jSONObject3.put("fg_stat", t.c() ? 1 : 0);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(a2).k());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a2)) {
            jSONObject2.put(bh.aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a2));
            jSONObject2.put("push_switch", d.p(a2));
            UMWorkDispatch.sendEvent(a2, 16392, v.a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("jsonHeader", jSONObject2);
        jSONObject6.put("jsonBody", jSONObject5);
        jSONObject6.put(RemoteMessageConst.MSGID, str);
        jSONObject6.put("actionType", 9);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(a2.getPackageName());
        intent.setClass(a2, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject6.toString());
        q.enqueueWork(a2, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.aa
    public final void a(String str, int i2) throws Exception {
        Application a2 = x.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i2);
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(a2).k());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a2)) {
            jSONObject2.put(bh.aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a2));
            jSONObject2.put("push_switch", d.p(a2));
            UMWorkDispatch.sendEvent(a2, 16385, v.a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("jsonHeader", jSONObject2);
        jSONObject5.put("jsonBody", jSONObject4);
        jSONObject5.put(RemoteMessageConst.MSGID, str);
        jSONObject5.put("actionType", i2);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(a2.getPackageName());
        intent.setClass(a2, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_logs");
        intent.putExtra("send_message", jSONObject5.toString());
        q.enqueueWork(a2, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.aa
    public final void a() throws Exception {
        Application a2 = x.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(a2).k());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a2)) {
            jSONObject2.put(bh.aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a2));
            jSONObject2.put("push_switch", d.p(a2));
            UMWorkDispatch.sendEvent(a2, InputDeviceCompat.SOURCE_STYLUS, v.a(), jSONObject.toString());
            return;
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("jsonHeader", jSONObject2);
        jSONObject5.put("jsonBody", jSONObject4);
        Intent intent = new Intent("com.umeng.message.action");
        intent.setPackage(a2.getPackageName());
        intent.setClass(a2, UmengMessageHandlerService.class);
        intent.putExtra("um_command", "send");
        intent.putExtra("um_px_path", "umpx_push_launch");
        intent.putExtra("send_message", jSONObject5.toString());
        q.enqueueWork(a2, UmengMessageHandlerService.class, intent);
    }

    @Override // com.umeng.message.proguard.aa
    public final void a(String str) throws Exception {
        Application a2 = x.a();
        if (f.b(a2)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("din", d.c(a2));
            jSONObject2.put(bh.aO, MsgConstant.SDK_VERSION);
            jSONObject2.put("push_switch", d.p(a2));
            jSONObject.put("header", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(RemoteMessageConst.DEVICE_TOKEN, MessageSharedPrefs.getInstance(a2).k());
            jSONObject3.put("old_device_token", str);
            try {
                if (f.c(a2)) {
                    jSONObject3.put("utdid_gen", 1);
                    String d2 = f.d(a2);
                    if (!TextUtils.isEmpty(d2)) {
                        jSONObject3.put("utdid_rst_id", d2);
                    }
                    f.e(a2);
                }
            } catch (Throwable unused) {
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("push", jSONArray);
            jSONObject.put("content", jSONObject4);
            UMWorkDispatch.sendEvent(a2, 16387, v.a(), jSONObject.toString());
        }
    }

    @Override // com.umeng.message.proguard.aa
    public final void a(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) throws Exception {
        Application a2 = x.a();
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(a2);
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
        JSONObject a3 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias", UMUtils.getAppkey(a2));
        if (a3 != null && TextUtils.equals(a3.optString("success", ""), ITagManager.SUCCESS)) {
            messageSharedPrefs.a(str, str2, 0, a3.optLong(RemoteMessageConst.TTL, 3600L));
            messageSharedPrefs.a("alias_add_", a3.optLong(bh.aX));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
            return;
        }
        uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
    }
}
