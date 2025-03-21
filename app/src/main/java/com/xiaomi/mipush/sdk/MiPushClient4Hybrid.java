package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.C4048b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4252gs;
import com.xiaomi.push.C4255gv;
import com.xiaomi.push.C4265he;
import com.xiaomi.push.C4266hf;
import com.xiaomi.push.C4267hg;
import com.xiaomi.push.C4272hl;
import com.xiaomi.push.C4273hm;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.EnumC4183ed;
import com.xiaomi.push.EnumC4239gf;
import com.xiaomi.push.EnumC4249gp;
import com.xiaomi.push.EnumC4253gt;
import com.xiaomi.push.service.C4358aj;
import com.xiaomi.push.service.C4369au;
import com.xiaomi.push.service.C4402x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, C4048b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            intValue = (intValue & (-4)) + C4233g.b.NOT_ALLOWED.m14944a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return C4048b.m13476a(context).m13479a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, C4267hg c4267hg) {
        C4048b.a aVar;
        String m15403c = c4267hg.m15403c();
        if (c4267hg.m15393a() == 0 && (aVar = dataMap.get(m15403c)) != null) {
            aVar.m13508a(c4267hg.f16139e, c4267hg.f16140f);
            C4048b.m13476a(context).m13484a(m15403c, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(c4267hg.f16139e)) {
            arrayList = new ArrayList();
            arrayList.add(c4267hg.f16139e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_REGISTER.f15082a, arrayList, c4267hg.f16127a, c4267hg.f16138d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(m15403c, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, C4273hm c4273hm) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_UNREGISTER.f15082a, null, c4273hm.f16262a, c4273hm.f16270d, null, null);
        String m15515a = c4273hm.m15515a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(m15515a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (C4048b.m13476a(context).m13489a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            C4048b.a m13479a = C4048b.m13476a(context).m13479a(str);
            if (m13479a != null) {
                arrayList.add(m13479a.f14386c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC4183ed.COMMAND_REGISTER.f15082a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                C4265he c4265he = new C4265he();
                c4265he.m15314b(str2);
                c4265he.m15318c(EnumC4249gp.PullOfflineMessage.f15769a);
                c4265he.m15301a(C4358aj.m15941a());
                c4265he.m15304a(false);
                C4067u.m13627a(context).m13664a(c4265he, EnumC4239gf.Notification, false, true, null, false, str, str2);
                AbstractC4022b.m13356b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < C2084a.f6136r) {
            AbstractC4022b.m13347a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String m13878a = C4100bb.m13878a(6);
        C4048b.a aVar = new C4048b.a(context);
        aVar.m13515c(str2, str3, m13878a);
        dataMap.put(str, aVar);
        C4266hf c4266hf = new C4266hf();
        c4266hf.m15342a(C4358aj.m15941a());
        c4266hf.m15349b(str2);
        c4266hf.m15361e(str3);
        c4266hf.m15358d(str);
        c4266hf.m15364f(m13878a);
        c4266hf.m15354c(C4233g.m14931a(context, context.getPackageName()));
        c4266hf.m15348b(C4233g.m14925a(context, context.getPackageName()));
        c4266hf.m15370h(BuildConfig.VERSION_NAME);
        c4266hf.m15340a(BuildConfig.VERSION_CODE);
        c4266hf.m15341a(EnumC4253gt.Init);
        if (!C4300j.m15691d()) {
            String m15650d = C4287i.m15650d(context);
            if (!TextUtils.isEmpty(m15650d)) {
                c4266hf.m15373i(C4100bb.m13879a(m15650d));
            }
        }
        int m15630a = C4287i.m15630a();
        if (m15630a >= 0) {
            c4266hf.m15353c(m15630a);
        }
        C4265he c4265he2 = new C4265he();
        c4265he2.m15318c(EnumC4249gp.HybridRegister.f15769a);
        c4265he2.m15314b(C4048b.m13476a(context).m13480a());
        c4265he2.m15322d(context.getPackageName());
        c4265he2.m15305a(C4276hp.m15567a(c4266hf));
        c4265he2.m15301a(C4358aj.m15941a());
        C4067u.m13627a(context).m13659a((C4067u) c4265he2, EnumC4239gf.Notification, (C4252gs) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        C4066t.m13608a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            AbstractC4022b.m13347a("do not ack message, message is null");
            return;
        }
        try {
            C4255gv c4255gv = new C4255gv();
            c4255gv.m15153b(C4048b.m13476a(context).m13480a());
            c4255gv.m15147a(miPushMessage.getMessageId());
            c4255gv.m15146a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            c4255gv.m15148a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                c4255gv.m15156c(miPushMessage.getTopic());
            }
            C4067u.m13627a(context).m13661a((C4067u) c4255gv, EnumC4239gf.AckMessage, false, C4369au.m16011a(PushMessageHelper.generateMessage(miPushMessage)));
            AbstractC4022b.m13356b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        C4048b.a m13479a = C4048b.m13476a(context).m13479a(str);
        if (m13479a == null) {
            return;
        }
        C4272hl c4272hl = new C4272hl();
        c4272hl.m15493a(C4358aj.m15941a());
        c4272hl.m15503d(str);
        c4272hl.m15498b(m13479a.f14382a);
        c4272hl.m15501c(m13479a.f14386c);
        c4272hl.m15505e(m13479a.f14384b);
        C4265he c4265he = new C4265he();
        c4265he.m15318c(EnumC4249gp.HybridUnregister.f15769a);
        c4265he.m15314b(C4048b.m13476a(context).m13480a());
        c4265he.m15322d(context.getPackageName());
        c4265he.m15305a(C4276hp.m15567a(c4272hl));
        c4265he.m15301a(C4358aj.m15941a());
        C4067u.m13627a(context).m13659a((C4067u) c4265he, EnumC4239gf.Notification, (C4252gs) null);
        C4048b.m13476a(context).m13492b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        C4402x.m16315a(context, linkedList);
    }
}
