package com.heytap.mcssdk.p156g;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.heytap.mcssdk.p155d.C2088a;
import com.heytap.msp.push.notification.PushNotification;

/* renamed from: com.heytap.mcssdk.g.a */
/* loaded from: classes.dex */
public class C2091a {
    /* renamed from: a */
    public static Notification m5815a(Context context, String str, PushNotification.Builder builder) {
        Notification.Builder builder2 = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder2.setChannelId(C2088a.f6202a);
        }
        if (Build.VERSION.SDK_INT >= 20) {
            builder2.setGroup(str);
            builder2.setGroupSummary(true);
        }
        if (m5817a(builder2, builder)) {
            return builder2.build();
        }
        return null;
    }

    /* renamed from: a */
    public static NotificationManager m5816a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (NotificationManager) context.getSystemService("notification");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m5817a(Notification.Builder builder, PushNotification.Builder builder2) {
        int iconRes = builder2.getIconRes();
        int iconLevel = builder2.getIconLevel();
        Icon icon = builder2.getIcon();
        if (icon != null && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(icon);
            return true;
        }
        if (iconRes != 0 && iconLevel != 0) {
            builder.setSmallIcon(iconRes, iconLevel);
            return true;
        }
        if (iconRes == 0) {
            return false;
        }
        builder.setSmallIcon(iconRes);
        return true;
    }

    /* renamed from: a */
    public static boolean m5818a(NotificationManager notificationManager, String str, int i2) {
        StatusBarNotification[] m5819a = m5819a(notificationManager, str);
        if (m5819a != null && m5819a.length != 0) {
            for (StatusBarNotification statusBarNotification : m5819a) {
                if (statusBarNotification.getId() == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static StatusBarNotification[] m5819a(NotificationManager notificationManager, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return notificationManager.getActiveNotifications();
        }
        return null;
    }
}
