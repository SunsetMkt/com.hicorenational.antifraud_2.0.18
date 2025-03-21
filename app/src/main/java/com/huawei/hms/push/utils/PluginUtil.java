package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.C2489i;
import com.huawei.hms.push.C2492l;
import com.huawei.hms.push.C2493m;
import com.huawei.hms.push.C2498r;
import com.huawei.hms.push.C2500t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.nio.charset.Charset;
import java.util.List;
import org.android.agoo.message.MessageService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PluginUtil {
    private PluginUtil() {
    }

    /* renamed from: a */
    private static void m7650a(Context context, String str, String str2, String str3) {
        HMSLog.m7717i("PluginUtil", "onNotification");
        if (!C2489i.m7565a(context)) {
            HMSLog.m7717i("PluginUtil", context.getPackageName() + " disable display notification.");
            C2492l.m7571a(context, str, null, "103");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        Charset charset = C2493m.f7752a;
        intent.putExtra("selfshow_info", str3.getBytes(charset));
        intent.putExtra("selfshow_token", str2.getBytes(charset));
        intent.setPackage(context.getPackageName());
        C2500t.m7636a(context, intent);
        HMSLog.m7717i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context context, String str, String str2, Bundle bundle) {
        C2492l.m7571a(context, str, str2, "appHasOpenedId");
        C2492l.m7570a(context, bundle, "hmsStatistics");
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z) {
        HMSLog.m7717i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m7717i("PluginUtil", "Empty message received");
            return true;
        }
        if (z) {
            m7649a(context, str);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(C2493m.f7752a));
        bundle.putString("message_type", "received_message");
        return new C2498r().m7633a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.m7717i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        bundle.putString("message_type", "server_deleted_message");
        return new C2498r().m7633a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.m7717i("PluginUtil", "onMessage");
        if (context == null || strArr == null || strArr.length < 5) {
            return;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        if (m7652a(context, strArr)) {
            m7650a(context, strArr[0], strArr[3], strArr[4]);
        } else {
            onDataMessage(context, strArr[0], strArr[4], true);
        }
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        HMSLog.m7717i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("error", errorEnum.getInternalCode());
        bundle.putString("message_type", "new_token");
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
        if (TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new C2498r().m7633a(context, bundle, intent);
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        C2492l.m7571a(context, str, str2, MessageService.MSG_DB_COMPLETE);
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        C2492l.m7571a(context, str, str2, "1");
        onAppOpened(context, str, str2, null);
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, m7648a(str2), true);
    }

    public static void saveNotifySwitch(Context context, boolean z) {
        new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z);
    }

    /* renamed from: a */
    private static String m7648a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", str);
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException unused) {
            HMSLog.m7715e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m7651a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            HMSLog.m7718w("PluginUtil", "get running app processes null!");
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                int i2 = runningAppProcessInfo.importance;
                return (i2 == 100 || i2 == 200) ? false : true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m7652a(Context context, String[] strArr) {
        if (TextUtils.equals(strArr[1], "0")) {
            return m7651a(context) || TextUtils.equals(strArr[2], "1");
        }
        return false;
    }

    /* renamed from: a */
    private static void m7649a(Context context, String str) {
        C2492l.m7571a(context, str, null, "102");
    }
}
