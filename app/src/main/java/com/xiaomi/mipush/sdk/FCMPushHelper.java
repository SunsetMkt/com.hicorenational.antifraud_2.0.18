package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4262hb;
import com.xiaomi.push.C4269hi;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.service.AbstractC4362an;
import com.xiaomi.push.service.C4389l;
import com.xiaomi.push.service.C4399u;
import com.xiaomi.push.service.C4402x;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FCMPushHelper {
    /* renamed from: a */
    private static void m13423a(Context context, C4262hb c4262hb) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((C4269hi) C4064r.m13598a(context, c4262hb), c4262hb.m15264a(), false);
            PushMessageReceiver m13531a = C4052f.m13531a(context);
            if (m13531a != null) {
                m13531a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            AbstractC4022b.m13349a("fcm broadcast notification come error ", th);
        }
    }

    /* renamed from: b */
    private static boolean m13426b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        C4052f.m13537a(context, EnumC4050d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        C4052f.m13540a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return C4052f.m13543a(context, EnumC4050d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver m13531a;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (m13531a = C4052f.m13531a(context)) == null) {
            return;
        }
        m13531a.onNotificationMessageArrived(context, C4052f.m13530a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver m13531a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (m13531a = C4052f.m13531a(context)) != null) {
            m13531a.onReceivePassThroughMessage(context, C4052f.m13530a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            m13423a(context, C4399u.m16236a(decode));
            m13424a(context, decode);
        } catch (Throwable th) {
            AbstractC4022b.m13349a("fcm notify notification error ", th);
        }
        return m13422a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) C4300j.m15683b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(C4052f.m13550c(EnumC4050d.ASSEMBLE_PUSH_FCM), UPushThirdTokenCallback.TYPE_FCM, 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        C4052f.m13538a(context, EnumC4050d.ASSEMBLE_PUSH_FCM, str);
    }

    /* renamed from: a */
    private static Map<String, String> m13422a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(EnumC4239gf.AckMessage.m14968a()));
        hashMap.put("deviceStatus", String.valueOf((int) C4276hp.m15564a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    /* renamed from: a */
    private static void m13424a(Context context, byte[] bArr) {
        boolean m13671a = C4067u.m13627a(context).m13671a();
        boolean z = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m13425a = m13425a(context);
        boolean z2 = false;
        if (m13671a && z && m13425a) {
            bArr = C4389l.m16118a(bArr, C4048b.m13476a(context).m13497d());
            if (bArr == null) {
                AbstractC4022b.m13347a("fcm message encrypt failed");
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    AbstractC4022b.m13347a("fcm message buf base64 encode failed");
                } else {
                    Intent intent = new Intent(AbstractC4362an.f16612n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    AbstractC4022b.m13347a("fcm message reroute to xmsf");
                    z2 = true;
                }
            }
        } else {
            AbstractC4022b.m13347a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m13671a), Boolean.valueOf(z), Boolean.valueOf(m13425a)));
        }
        if (z2) {
            return;
        }
        AbstractC4022b.m13356b("fcm message post local");
        C4402x.m16304a(context, C4399u.m16236a(bArr), bArr);
    }

    /* renamed from: a */
    private static boolean m13425a(Context context) {
        return ((long) C4300j.m15683b(context)) >= 50002000 && m13426b(context);
    }
}
