package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.dv;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class bb {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i2, String str2, Notification notification) {
        af a2;
        Notification a3;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (a3 = a(notification, i2, str2, (a2 = af.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (a3.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.aw.a((Object) a3, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = a3.extras.getLong("mipush_org_when", 0L);
        int i3 = a3.extras.getInt("mipush_n_top_fre", 0);
        int i4 = a3.extras.getInt("mipush_n_top_prd", 0);
        if (i4 <= 0 || i4 < i3) {
            return;
        }
        long j3 = (i4 * 1000) + j2;
        int min = (j2 >= currentTimeMillis || currentTimeMillis >= j3) ? 0 : i3 > 0 ? (int) Math.min((j3 - currentTimeMillis) / 1000, i3) : i4;
        if (!z) {
            if (min > 0) {
                a3.when = currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m50a("update top notification: " + str2);
                a2.a(i2, a3);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, a3);
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
                com.xiaomi.channel.commonutils.logger.b.m50a("update top notification to common: " + str2);
                a2.a(i2, recoverBuilder.build());
            }
        }
        if (min > 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("schedule top notification next update delay: " + min);
            com.xiaomi.push.ae.a(context).m131a(b(i2, str2));
            com.xiaomi.push.ae.a(context).b(a(context, str, i2, str2, (Notification) null), min);
        }
    }

    static void a(Context context, Map<String, String> map, dv dvVar, long j2) {
        if (map == null || dvVar == null || !com.xiaomi.push.j.m627a(context) || !m714a(map)) {
            return;
        }
        int a2 = a(map);
        int b2 = b(map);
        if (a2 <= 0 || b2 > a2) {
            com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + a2 + " frequency:" + b2);
            return;
        }
        dvVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j2);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (b2 > 0) {
            bundle.putInt("mipush_n_top_fre", b2);
        }
        bundle.putInt("mipush_n_top_prd", a2);
        dvVar.addExtras(bundle);
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2, String str) {
        return "n_top_update_" + i2 + c.c.a.b.a.a.s1 + str;
    }

    @TargetApi(19)
    /* renamed from: a, reason: collision with other method in class */
    static void m713a(Context context, String str, int i2, String str2, Notification notification) {
        if (com.xiaomi.push.j.m627a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i2, str2, notification);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m714a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.s.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification a(Notification notification, int i2, String str, af afVar) {
        if (notification != null) {
            if (str.equals(notification.extras.getString("message_id"))) {
                return notification;
            }
            return null;
        }
        List<StatusBarNotification> m687b = afVar.m687b();
        if (m687b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : m687b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i2 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static ae.a a(final Context context, final String str, final int i2, final String str2, final Notification notification) {
        return new ae.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.ae.a
            /* renamed from: a */
            public String mo183a() {
                return bb.b(i2, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                bb.c(context, str, i2, str2, notification);
            }
        };
    }
}
