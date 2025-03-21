package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HWPushHelper {

    /* renamed from: a */
    private static boolean f14343a = false;

    public static void convertMessage(Intent intent) {
        C4052f.m13540a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return C4052f.m13542a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String m13533a = C4052f.m13533a(context, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, false);
        String m13589a = C4062p.m13587a(context).m13589a(EnumC4068v.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(m13533a) || TextUtils.isEmpty(m13589a) || !"synced".equals(m13589a)) ? false : true;
    }

    public static boolean isUserOpenHmsPush(Context context) {
        return MiPushClient.getOpenHmsPush(context);
    }

    public static boolean needConnect() {
        return f14343a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r2 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void notifyHmsNotificationMessageClicked(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "pushMsg"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r2 = ""
            if (r1 != 0) goto L37
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L2f
            r1.<init>(r6)     // Catch: java.lang.Exception -> L2f
            int r6 = r1.length()     // Catch: java.lang.Exception -> L2f
            if (r6 <= 0) goto L37
            r6 = 0
        L16:
            int r3 = r1.length()     // Catch: java.lang.Exception -> L2f
            if (r6 >= r3) goto L37
            org.json.JSONObject r3 = r1.getJSONObject(r6)     // Catch: java.lang.Exception -> L2f
            boolean r4 = r3.has(r0)     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L2c
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Exception -> L2f
            r2 = r6
            goto L37
        L2c:
            int r6 = r6 + 1
            goto L16
        L2f:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13361d(r6)
        L37:
            com.xiaomi.mipush.sdk.PushMessageReceiver r6 = com.xiaomi.mipush.sdk.C4052f.m13531a(r5)
            if (r6 == 0) goto L51
            com.xiaomi.mipush.sdk.MiPushMessage r0 = com.xiaomi.mipush.sdk.C4052f.m13530a(r2)
            java.util.Map r1 = r0.getExtra()
            java.lang.String r2 = "notify_effect"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L4e
            return
        L4e:
            r6.onNotificationMessageClicked(r5, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.HWPushHelper.notifyHmsNotificationMessageClicked(android.content.Context, java.lang.String):void");
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e2) {
            AbstractC4022b.m13361d(e2.toString());
        }
        PushMessageReceiver m13531a = C4052f.m13531a(context);
        if (m13531a != null) {
            m13531a.onReceivePassThroughMessage(context, C4052f.m13530a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager m13522a = C4051e.m13518a(context).m13522a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
        if (m13522a != null) {
            m13522a.register();
        }
    }

    public static void reportError(String str, int i2) {
        C4052f.m13541a(str, i2);
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        f14343a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > 172800000;
        }
        return z;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > C2084a.f6136r;
        }
        return z;
    }

    public static void uploadToken(Context context, String str) {
        C4052f.m13538a(context, EnumC4050d.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
