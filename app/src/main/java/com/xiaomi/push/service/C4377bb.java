package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.NotificationBuilderC4174dv;
import java.util.List;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.service.bb */
/* loaded from: classes2.dex */
public class C4377bb {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: c */
    public static void m16067c(Context context, String str, int i2, String str2, Notification notification) {
        C4354af m15874a;
        Notification m16058a;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (m16058a = m16058a(notification, i2, str2, (m15874a = C4354af.m15874a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (m16058a.getGroupAlertBehavior() != 1) {
            C4094aw.m13827a((Object) m16058a, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = m16058a.extras.getLong("mipush_org_when", 0L);
        int i3 = m16058a.extras.getInt("mipush_n_top_fre", 0);
        int i4 = m16058a.extras.getInt("mipush_n_top_prd", 0);
        if (i4 <= 0 || i4 < i3) {
            return;
        }
        long j3 = (i4 * 1000) + j2;
        int min = (j2 >= currentTimeMillis || currentTimeMillis >= j3) ? 0 : i3 > 0 ? (int) Math.min((j3 - currentTimeMillis) / 1000, i3) : i4;
        if (!z) {
            if (min > 0) {
                m16058a.when = currentTimeMillis;
                AbstractC4022b.m13347a("update top notification: " + str2);
                m15874a.m15892a(i2, m16058a);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, m16058a);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                AbstractC4022b.m13347a("update top notification to common: " + str2);
                m15874a.m15892a(i2, recoverBuilder.build());
            }
        }
        if (min > 0) {
            AbstractC4022b.m13347a("schedule top notification next update delay: " + min);
            C4076ae.m13698a(context).m13709a(m16065b(i2, str2));
            C4076ae.m13698a(context).m13710b(m16059a(context, str, i2, str2, (Notification) null), min);
        }
    }

    /* renamed from: a */
    static void m16062a(Context context, Map<String, String> map, NotificationBuilderC4174dv notificationBuilderC4174dv, long j2) {
        if (map == null || notificationBuilderC4174dv == null || !C4300j.m15681a(context) || !m16063a(map)) {
            return;
        }
        int m16057a = m16057a(map);
        int m16064b = m16064b(map);
        if (m16057a <= 0 || m16064b > m16057a) {
            AbstractC4022b.m13361d("set top notification failed - period:" + m16057a + " frequency:" + m16064b);
            return;
        }
        notificationBuilderC4174dv.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j2);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (m16064b > 0) {
            bundle.putInt("mipush_n_top_fre", m16064b);
        }
        bundle.putInt("mipush_n_top_prd", m16057a);
        notificationBuilderC4174dv.addExtras(bundle);
    }

    /* renamed from: b */
    private static int m16064b(Map<String, String> map) {
        return Math.max(0, C4310s.m15725a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m16065b(int i2, String str) {
        return "n_top_update_" + i2 + AbstractC1191a.f2606s1 + str;
    }

    @TargetApi(19)
    /* renamed from: a */
    static void m16061a(Context context, String str, int i2, String str2, Notification notification) {
        if (C4300j.m15681a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            m16067c(context, str, i2, str2, notification);
        }
    }

    /* renamed from: a */
    private static boolean m16063a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        AbstractC4022b.m13359c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    /* renamed from: a */
    private static int m16057a(Map<String, String> map) {
        return Math.max(0, C4310s.m15725a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    /* renamed from: a */
    private static Notification m16058a(Notification notification, int i2, String str, C4354af c4354af) {
        if (notification != null) {
            if (str.equals(notification.extras.getString("message_id"))) {
                return notification;
            }
            return null;
        }
        List<StatusBarNotification> m15897b = c4354af.m15897b();
        if (m15897b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : m15897b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i2 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C4076ae.a m16059a(final Context context, final String str, final int i2, final String str2, final Notification notification) {
        return new C4076ae.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.C4076ae.a
            /* renamed from: a */
            public String mo13391a() {
                return C4377bb.m16065b(i2, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                C4377bb.m16067c(context, str, i2, str2, notification);
            }
        };
    }
}
