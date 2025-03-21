package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C0334r;
import com.xiaomi.push.ae;
import com.xiaomi.push.au;
import com.xiaomi.push.aw;
import com.xiaomi.push.ba;
import com.xiaomi.push.hb;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12372a = new int[d.values().length];

        static {
            try {
                f12372a[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m97a(Context context, d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, dVar, str);
        if (a2 == 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : send token upload, check:" + a2);
        a(context, str);
        v m101a = g.m101a(dVar);
        if (m101a == null) {
            return;
        }
        u.a(context).a((String) null, m101a, dVar, "upload");
    }

    public static void b(final Context context, final d dVar, final String str) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String[] split = str.split(Constants.WAVE_SEPARATOR);
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str2 = "";
                        break;
                    }
                    String str3 = split[i2];
                    if (!TextUtils.isEmpty(str3) && str3.startsWith("token:")) {
                        str2 = str3.substring(str3.indexOf(Constants.COLON_SEPARATOR) + 1);
                        break;
                    }
                    i2++;
                }
                if (TextUtils.isEmpty(str2)) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : receive incorrect token");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : receive correct token");
                f.d(context, dVar, str2);
                f.m95a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        synchronized (f.class) {
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", b.m75a(context).m83c());
            if (m100a(dVar)) {
                edit.putInt(b(dVar), a());
            }
            edit.putString("syncingToken", "");
            com.xiaomi.push.p.a(edit);
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    public static String b(d dVar) {
        return a(dVar) + "_version";
    }

    public static String c(d dVar) {
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        if (i2 == 1) {
            return "hms_push_error";
        }
        if (i2 == 2) {
            return "fcm_push_error";
        }
        if (i2 == 3) {
            return "cos_push_error";
        }
        if (i2 != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    private static int a(Context context, d dVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(dVar);
        String string = sharedPreferences.getString(a2, "");
        String m83c = b.m75a(context).m83c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(m83c, string2)) {
            return 3;
        }
        if (m100a(dVar)) {
            if (a() != sharedPreferences.getInt(b(dVar), 0)) {
                return 4;
            }
        }
        return 0;
    }

    static String a(Context context, d dVar) {
        return a(context, dVar, false);
    }

    public static boolean a(hb hbVar, d dVar) {
        if (hbVar == null || hbVar.m529a() == null || hbVar.m529a().m496a() == null) {
            return false;
        }
        return (dVar == d.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(hbVar.m529a().m496a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, hb hbVar, d dVar) {
        if (a(hbVar, dVar)) {
            return ba.m176a(a(context, dVar));
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m95a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(d.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            u.a(context).a(2, a2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m96a(Context context, d dVar) {
        String a2 = a(dVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        com.xiaomi.push.p.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m99a(Context context, d dVar) {
        if (g.m102a(dVar) != null) {
            return ah.a(context).a(g.m102a(dVar).a(), true);
        }
        return false;
    }

    public static void a(String str, int i2) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m98a(Context context) {
        if (context == null) {
            return false;
        }
        return au.m151a(context);
    }

    private static synchronized void a(Context context, String str) {
        synchronized (f.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    protected static synchronized String a(Context context, d dVar, boolean z) {
        synchronized (f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            return sharedPreferences.getString(a2, "");
        }
    }

    protected static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) C0334r.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            return null;
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
        }
        return miPushMessage;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m94a(Context context, d dVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i2 == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
            str = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.HUAWEI.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1)).toString();
        } else if (i2 == 2) {
            s.a a2 = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.FCM.name()).a("token", a(context, dVar, false)).a("package_name", context.getPackageName());
            int a3 = a();
            if (a3 != 0) {
                a2.a("version", Integer.valueOf(a3));
            } else {
                a2.a("version", Integer.valueOf(BuildConfig.VERSION_CODE));
            }
            str = a2.toString();
        } else if (i2 == 3) {
            str = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.OPPO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).toString();
        } else if (i2 == 4) {
            s.a a4 = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.VIVO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName());
            int a5 = a();
            if (a5 != 0) {
                a4.a("version", Integer.valueOf(a5));
            }
            str = a4.toString();
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    public static int a() {
        Integer num = (Integer) aw.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m100a(d dVar) {
        return dVar == d.ASSEMBLE_PUSH_FTOS || dVar == d.ASSEMBLE_PUSH_FCM;
    }

    public static String a(d dVar) {
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        if (i2 == 1) {
            return "hms_push_token";
        }
        if (i2 == 2) {
            return "fcm_push_token_v2";
        }
        if (i2 == 3) {
            return "cos_push_token";
        }
        if (i2 != 4) {
            return null;
        }
        return "ftos_push_token";
    }
}
