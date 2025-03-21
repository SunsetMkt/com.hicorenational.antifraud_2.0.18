package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.android.agoo.message.MessageService;

/* compiled from: PushNotification.java */
/* renamed from: com.huawei.hms.push.n */
/* loaded from: classes.dex */
public class C2494n {

    /* renamed from: a */
    private static int f7753a;

    /* renamed from: a */
    public static synchronized void m7576a(Context context, C2495o c2495o) {
        int hashCode;
        int i2;
        int i3;
        int hashCode2;
        synchronized (C2494n.class) {
            if (context != null) {
                if (!m7580a(c2495o)) {
                    HMSLog.m7712d("PushSelfShowLog", "showNotification, the msg id = " + c2495o.m7616o());
                    if (f7753a == 0) {
                        f7753a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(c2495o.m7612k())) {
                        String m7617p = c2495o.m7617p();
                        if (!TextUtils.isEmpty(m7617p)) {
                            int hashCode3 = m7617p.hashCode();
                            c2495o.m7602a(hashCode3);
                            HMSLog.m7712d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (c2495o.m7618r() != -1) {
                            hashCode = c2495o.m7618r();
                            i2 = (c2495o.m7611j() + System.currentTimeMillis()).hashCode();
                            i3 = i2 + 1;
                            hashCode2 = (c2495o.m7618r() + c2495o.m7611j() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = f7753a + 1;
                            i2 = hashCode + 1;
                            i3 = i2 + 1;
                            hashCode2 = i3 + 1;
                            f7753a = hashCode2;
                        }
                    } else {
                        hashCode = (c2495o.m7612k() + c2495o.m7611j()).hashCode();
                        i2 = f7753a + 1;
                        i3 = i2 + 1;
                        f7753a = i3;
                        hashCode2 = (c2495o.m7612k() + c2495o.m7611j() + context.getPackageName()).hashCode();
                    }
                    HMSLog.m7712d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i2 + ",delNotifyId:" + i3 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i2;
                    iArr[2] = i3;
                    if (c2495o.m7606e() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification m7572a = C2485e.m7559d() ? m7572a(context, c2495o, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && m7572a != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, m7572a);
                        C2492l.m7571a(context, c2495o.m7616o(), c2495o.m7603b(), MessageService.MSG_DB_COMPLETE);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static PendingIntent m7581b(Context context, C2495o c2495o, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], m7573a(context, c2495o, iArr, "2", CommonNetImpl.FLAG_AUTH), C2485e.m7551a());
    }

    /* renamed from: c */
    private static PendingIntent m7584c(Context context, C2495o c2495o, int[] iArr) {
        Intent m7573a = m7573a(context, c2495o, iArr, "1", CommonNetImpl.FLAG_AUTH);
        if (!m7579a()) {
            return PendingIntent.getBroadcast(context, iArr[1], m7573a, C2485e.m7551a());
        }
        m7573a.setClass(context, TransActivity.class);
        m7573a.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], m7573a, C2485e.m7551a());
    }

    /* renamed from: d */
    private static void m7586d(C2495o c2495o, Notification.Builder builder) {
        String m7620t = c2495o.m7620t();
        String m7610i = c2495o.m7610i();
        if (TextUtils.isEmpty(m7610i)) {
            builder.setContentText(m7620t);
            return;
        }
        builder.setContentText(m7610i);
        if (TextUtils.isEmpty(m7620t)) {
            return;
        }
        builder.setContentTitle(m7620t);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static void m7582b(Context context, Notification.Builder builder, C2495o c2495o) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String m7611j = c2495o.m7611j();
            if (TextUtils.isEmpty(m7611j)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", m7611j);
            builder.setExtras(bundle);
        }
    }

    /* renamed from: c */
    private static void m7585c(C2495o c2495o, Notification.Builder builder) {
        builder.setTicker(c2495o.m7622w());
    }

    /* renamed from: b */
    private static void m7583b(C2495o c2495o, Notification.Builder builder) {
        String m7619s = c2495o.m7619s();
        if (TextUtils.isEmpty(m7619s)) {
            return;
        }
        builder.setSubText(m7619s);
    }

    /* renamed from: a */
    private static boolean m7579a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: a */
    private static Intent m7573a(Context context, C2495o c2495o, int[] iArr, String str, int i2) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", c2495o.m7615n()).putExtra("selfshow_token", c2495o.m7623x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i2);
        return intent;
    }

    /* renamed from: a */
    private static Notification m7572a(Context context, C2495o c2495o, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (C2490j.m7567a(c2495o) == EnumC2491k.STYLE_BIGTEXT) {
            C2490j.m7568a(builder, c2495o.m7607f(), c2495o);
        }
        C2488h.m7563a(context, builder, c2495o);
        m7583b(c2495o, builder);
        m7586d(c2495o, builder);
        m7577a(context, c2495o, builder);
        m7574a(builder);
        m7578a(c2495o, builder);
        m7585c(c2495o, builder);
        builder.setContentIntent(m7584c(context, c2495o, iArr));
        builder.setDeleteIntent(m7581b(context, c2495o, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        m7582b(context, builder, c2495o);
        m7575a(context, builder, c2495o);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static void m7575a(Context context, Notification.Builder builder, C2495o c2495o) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !C2485e.m7554a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String m7611j = c2495o.m7611j();
        HMSLog.m7717i("PushSelfShowLog", "the package name of notification is:" + m7611j);
        if (!TextUtils.isEmpty(m7611j)) {
            String m7553a = C2485e.m7553a(context, m7611j);
            HMSLog.m7717i("PushSelfShowLog", "the app name is:" + m7553a);
            if (m7553a != null) {
                bundle.putCharSequence("android.extraAppName", m7553a);
            }
        }
        builder.setExtras(bundle);
    }

    /* renamed from: a */
    private static void m7577a(Context context, C2495o c2495o, Notification.Builder builder) {
        Bitmap m7562a = C2488h.m7562a(context, c2495o);
        if (m7562a != null) {
            builder.setLargeIcon(m7562a);
        }
    }

    /* renamed from: a */
    private static void m7574a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    /* renamed from: a */
    private static void m7578a(C2495o c2495o, Notification.Builder builder) {
        builder.setAutoCancel(c2495o.m7605d() == 1);
        builder.setOngoing(false);
    }

    /* renamed from: a */
    private static boolean m7580a(C2495o c2495o) {
        return c2495o == null || (TextUtils.isEmpty(c2495o.m7620t()) && TextUtils.isEmpty(c2495o.m7610i()));
    }
}
