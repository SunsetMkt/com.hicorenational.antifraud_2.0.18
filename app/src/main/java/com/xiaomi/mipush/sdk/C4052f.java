package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4099ba;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4306p;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.service.C4356ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.f */
/* loaded from: classes2.dex */
public class C4052f {

    /* renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f14408a = new int[EnumC4050d.values().length];

        static {
            try {
                f14408a[EnumC4050d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14408a[EnumC4050d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14408a[EnumC4050d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14408a[EnumC4050d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a */
    public static void m13538a(Context context, EnumC4050d enumC4050d, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int m13529a = m13529a(context, enumC4050d, str);
        if (m13529a == 0) {
            AbstractC4022b.m13347a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        AbstractC4022b.m13347a("ASSEMBLE_PUSH : send token upload, check:" + m13529a);
        m13539a(context, str);
        EnumC4068v m13555a = C4053g.m13555a(enumC4050d);
        if (m13555a == null) {
            return;
        }
        C4067u.m13627a(context).m13667a((String) null, m13555a, enumC4050d, "upload");
    }

    /* renamed from: b */
    public static void m13549b(final Context context, final EnumC4050d enumC4050d, final String str) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
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
                    AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive incorrect token");
                    return;
                }
                AbstractC4022b.m13347a("ASSEMBLE_PUSH : receive correct token");
                C4052f.m13553d(context, enumC4050d, str2);
                C4052f.m13536a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static synchronized void m13553d(Context context, EnumC4050d enumC4050d, String str) {
        synchronized (C4052f.class) {
            String m13534a = m13534a(enumC4050d);
            if (TextUtils.isEmpty(m13534a)) {
                AbstractC4022b.m13347a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(m13534a, str).putString("last_check_token", C4048b.m13476a(context).m13495c());
            if (m13544a(enumC4050d)) {
                edit.putInt(m13547b(enumC4050d), m13528a());
            }
            edit.putString("syncingToken", "");
            C4306p.m15711a(edit);
            AbstractC4022b.m13347a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }

    /* renamed from: b */
    public static void m13548b(Context context) {
        C4051e.m13518a(context).register();
    }

    /* renamed from: c */
    public static void m13551c(Context context) {
        C4051e.m13518a(context).unregister();
    }

    /* renamed from: b */
    public static String m13547b(EnumC4050d enumC4050d) {
        return m13534a(enumC4050d) + "_version";
    }

    /* renamed from: c */
    public static String m13550c(EnumC4050d enumC4050d) {
        int i2 = AnonymousClass2.f14408a[enumC4050d.ordinal()];
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

    /* renamed from: a */
    private static int m13529a(Context context, EnumC4050d enumC4050d, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String m13534a = m13534a(enumC4050d);
        String string = sharedPreferences.getString(m13534a, "");
        String m13495c = C4048b.m13476a(context).m13495c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(m13534a)) {
            AbstractC4022b.m13347a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(m13495c, string2)) {
            return 3;
        }
        if (m13544a(enumC4050d)) {
            if (m13528a() != sharedPreferences.getInt(m13547b(enumC4050d), 0)) {
                return 4;
            }
        }
        return 0;
    }

    /* renamed from: a */
    static String m13532a(Context context, EnumC4050d enumC4050d) {
        return m13533a(context, enumC4050d, false);
    }

    /* renamed from: a */
    public static boolean m13545a(C4262hb c4262hb, EnumC4050d enumC4050d) {
        if (c4262hb == null || c4262hb.m15264a() == null || c4262hb.m15264a().m15097a() == null) {
            return false;
        }
        return (enumC4050d == EnumC4050d.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(c4262hb.m15264a().m15097a().get("assemble_push_type"));
    }

    /* renamed from: a */
    public static byte[] m13546a(Context context, C4262hb c4262hb, EnumC4050d enumC4050d) {
        if (m13545a(c4262hb, enumC4050d)) {
            return C4099ba.m13876a(m13532a(context, enumC4050d));
        }
        return null;
    }

    /* renamed from: a */
    static void m13536a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String m13534a = m13534a(EnumC4050d.ASSEMBLE_PUSH_HUAWEI);
        String m13534a2 = m13534a(EnumC4050d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(m13534a, "")) && TextUtils.isEmpty(sharedPreferences.getString(m13534a2, ""))) {
            z = true;
        }
        if (z) {
            C4067u.m13627a(context).m13653a(2, m13534a);
        }
    }

    /* renamed from: a */
    public static void m13537a(Context context, EnumC4050d enumC4050d) {
        String m13534a = m13534a(enumC4050d);
        if (TextUtils.isEmpty(m13534a)) {
            return;
        }
        C4306p.m15711a(context.getSharedPreferences("mipush_extra", 0).edit().putString(m13534a, ""));
    }

    /* renamed from: a */
    public static boolean m13543a(Context context, EnumC4050d enumC4050d) {
        if (C4053g.m13556a(enumC4050d) != null) {
            return C4356ah.m15923a(context).m15935a(C4053g.m13556a(enumC4050d).m15014a(), true);
        }
        return false;
    }

    /* renamed from: a */
    public static void m13541a(String str, int i2) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
    }

    /* renamed from: a */
    public static boolean m13542a(Context context) {
        if (context == null) {
            return false;
        }
        return C4092au.m13799a(context);
    }

    /* renamed from: a */
    private static synchronized void m13539a(Context context, String str) {
        synchronized (C4052f.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    /* renamed from: a */
    protected static synchronized String m13533a(Context context, EnumC4050d enumC4050d, boolean z) {
        synchronized (C4052f.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String m13534a = m13534a(enumC4050d);
            if (TextUtils.isEmpty(m13534a)) {
                return "";
            }
            return sharedPreferences.getString(m13534a, "");
        }
    }

    /* renamed from: a */
    protected static PushMessageReceiver m13531a(Context context) {
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
                return (PushMessageReceiver) C4309r.m15716a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e2) {
            AbstractC4022b.m13361d(e2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static void m13540a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, m13530a(extras.getString("pushMsg")));
    }

    /* renamed from: a */
    public static MiPushMessage m13530a(String str) {
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
                AbstractC4022b.m13361d(e2.toString());
            }
        }
        return miPushMessage;
    }

    /* renamed from: a */
    public static HashMap<String, String> m13535a(Context context, EnumC4050d enumC4050d) {
        HashMap<String, String> hashMap = new HashMap<>();
        int i2 = AnonymousClass2.f14408a[enumC4050d.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i2 == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e2) {
                AbstractC4022b.m13361d(e2.toString());
            }
            str = new C4310s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m15730a("brand", EnumC4063q.HUAWEI.name()).m15730a("token", m13533a(context, enumC4050d, true)).m15730a("package_name", context.getPackageName()).m15730a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1)).toString();
        } else if (i2 == 2) {
            C4310s.a m15730a = new C4310s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m15730a("brand", EnumC4063q.FCM.name()).m15730a("token", m13533a(context, enumC4050d, false)).m15730a("package_name", context.getPackageName());
            int m13528a = m13528a();
            if (m13528a != 0) {
                m15730a.m15730a("version", Integer.valueOf(m13528a));
            } else {
                m15730a.m15730a("version", Integer.valueOf(BuildConfig.VERSION_CODE));
            }
            str = m15730a.toString();
        } else if (i2 == 3) {
            str = new C4310s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m15730a("brand", EnumC4063q.OPPO.name()).m15730a("token", m13533a(context, enumC4050d, true)).m15730a("package_name", context.getPackageName()).toString();
        } else if (i2 == 4) {
            C4310s.a m15730a2 = new C4310s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).m15730a("brand", EnumC4063q.VIVO.name()).m15730a("token", m13533a(context, enumC4050d, true)).m15730a("package_name", context.getPackageName());
            int m13528a2 = m13528a();
            if (m13528a2 != 0) {
                m15730a2.m15730a("version", Integer.valueOf(m13528a2));
            }
            str = m15730a2.toString();
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* renamed from: a */
    public static int m13528a() {
        Integer num = (Integer) C4094aw.m13823a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public static boolean m13544a(EnumC4050d enumC4050d) {
        return enumC4050d == EnumC4050d.ASSEMBLE_PUSH_FTOS || enumC4050d == EnumC4050d.ASSEMBLE_PUSH_FCM;
    }

    /* renamed from: a */
    public static String m13534a(EnumC4050d enumC4050d) {
        int i2 = AnonymousClass2.f14408a[enumC4050d.ordinal()];
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
