package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HWPushHelper {
    private static boolean a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return f.m96a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String strA = f.a(context, d.ASSEMBLE_PUSH_HUAWEI, false);
        String strA2 = p.a(context).a(v.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || !"synced".equals(strA2)) ? false : true;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r2 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void notifyHmsNotificationMessageClicked(Context context, String str) throws JSONException {
        String string = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject.has("pushMsg")) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
        }
        PushMessageReceiver pushMessageReceiverA = f.a(context);
        if (pushMessageReceiverA != null) {
            MiPushMessage miPushMessageA = f.a(string);
            if (miPushMessageA.getExtra().containsKey("notify_effect")) {
                return;
            }
            pushMessageReceiverA.onNotificationMessageClicked(context, miPushMessageA);
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) throws JSONException {
        String string = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    string = jSONObject.getString("content");
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
        }
        PushMessageReceiver pushMessageReceiverA = f.a(context);
        if (pushMessageReceiverA != null) {
            pushMessageReceiverA.onReceivePassThroughMessage(context, f.a(string));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_HUAWEI);
        if (abstractPushManagerA != null) {
            abstractPushManagerA.register();
        }
    }

    public static void reportError(String str, int i2) {
        f.a(str, i2);
    }

    public static synchronized void setConnectTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
    }

    public static synchronized void setGetTokenTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
    }

    public static void setNeedConnect(boolean z) {
        a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > 172800000;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > com.heytap.mcssdk.constant.a.r;
    }

    public static void uploadToken(Context context, String str) {
        f.m95a(context, d.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
