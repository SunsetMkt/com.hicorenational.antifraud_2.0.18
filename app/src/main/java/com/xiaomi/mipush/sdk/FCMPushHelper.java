package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.xiaomi.push.gf;
import com.xiaomi.push.hb;
import com.xiaomi.push.hi;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FCMPushHelper {
    private static void a(Context context, hb hbVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((hi) r.a(context, hbVar), hbVar.m529a(), false);
            PushMessageReceiver a2 = f.a(context);
            if (a2 != null) {
                a2.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
        }
    }

    private static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        f.m96a(context, d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return f.m99a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = f.a(context)) == null) {
            return;
        }
        a2.onNotificationMessageArrived(context, f.a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a2 = f.a(context)) != null) {
            a2.onReceivePassThroughMessage(context, f.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, com.xiaomi.push.service.u.a(decode));
            a(context, decode);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.push.j.b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(f.c(d.ASSEMBLE_PUSH_FCM), UPushThirdTokenCallback.TYPE_FCM, 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        f.m97a(context, d.ASSEMBLE_PUSH_FCM, str);
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(gf.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf((int) hp.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    private static void a(Context context, byte[] bArr) {
        boolean m120a = u.a(context).m120a();
        boolean z = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m67a = m67a(context);
        boolean z2 = false;
        if (m120a && z && m67a) {
            bArr = com.xiaomi.push.service.l.a(bArr, b.m75a(context).d());
            if (bArr == null) {
                com.xiaomi.channel.commonutils.logger.b.m50a("fcm message encrypt failed");
            } else {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("fcm message buf base64 encode failed");
                } else {
                    Intent intent = new Intent(an.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    com.xiaomi.channel.commonutils.logger.b.m50a("fcm message reroute to xmsf");
                    z2 = true;
                }
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a(String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m120a), Boolean.valueOf(z), Boolean.valueOf(m67a)));
        }
        if (z2) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
        x.m753a(context, com.xiaomi.push.service.u.a(bArr), bArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m67a(Context context) {
        return ((long) com.xiaomi.push.j.b(context)) >= 50002000 && b(context);
    }
}
