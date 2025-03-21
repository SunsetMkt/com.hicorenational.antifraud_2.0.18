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
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static int f7207a;

    public static synchronized void a(Context context, o oVar) {
        int hashCode;
        int i2;
        int i3;
        int hashCode2;
        synchronized (n.class) {
            if (context != null) {
                if (!a(oVar)) {
                    HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + oVar.o());
                    if (f7207a == 0) {
                        f7207a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(oVar.k())) {
                        String p = oVar.p();
                        if (!TextUtils.isEmpty(p)) {
                            int hashCode3 = p.hashCode();
                            oVar.a(hashCode3);
                            HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (oVar.r() != -1) {
                            hashCode = oVar.r();
                            i2 = (oVar.j() + System.currentTimeMillis()).hashCode();
                            i3 = i2 + 1;
                            hashCode2 = (oVar.r() + oVar.j() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = f7207a + 1;
                            i2 = hashCode + 1;
                            i3 = i2 + 1;
                            hashCode2 = i3 + 1;
                            f7207a = hashCode2;
                        }
                    } else {
                        hashCode = (oVar.k() + oVar.j()).hashCode();
                        i2 = f7207a + 1;
                        i3 = i2 + 1;
                        f7207a = i3;
                        hashCode2 = (oVar.k() + oVar.j() + context.getPackageName()).hashCode();
                    }
                    HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i2 + ",delNotifyId:" + i3 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i2;
                    iArr[2] = i3;
                    if (oVar.e() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification a2 = e.d() ? a(context, oVar, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && a2 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, a2);
                        l.a(context, oVar.o(), oVar.b(), MessageService.MSG_DB_COMPLETE);
                    }
                }
            }
        }
    }

    private static PendingIntent b(Context context, o oVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], a(context, oVar, iArr, "2", CommonNetImpl.FLAG_AUTH), e.a());
    }

    private static PendingIntent c(Context context, o oVar, int[] iArr) {
        Intent a2 = a(context, oVar, iArr, "1", CommonNetImpl.FLAG_AUTH);
        if (!a()) {
            return PendingIntent.getBroadcast(context, iArr[1], a2, e.a());
        }
        a2.setClass(context, TransActivity.class);
        a2.setFlags(268468224);
        return PendingIntent.getActivity(context, iArr[1], a2, e.a());
    }

    private static void d(o oVar, Notification.Builder builder) {
        String t = oVar.t();
        String i2 = oVar.i();
        if (TextUtils.isEmpty(i2)) {
            builder.setContentText(t);
            return;
        }
        builder.setContentText(i2);
        if (TextUtils.isEmpty(t)) {
            return;
        }
        builder.setContentTitle(t);
    }

    @SuppressLint({"NewApi"})
    private static void b(Context context, Notification.Builder builder, o oVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String j2 = oVar.j();
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", j2);
            builder.setExtras(bundle);
        }
    }

    private static void c(o oVar, Notification.Builder builder) {
        builder.setTicker(oVar.w());
    }

    private static void b(o oVar, Notification.Builder builder) {
        String s = oVar.s();
        if (TextUtils.isEmpty(s)) {
            return;
        }
        builder.setSubText(s);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent a(Context context, o oVar, int[] iArr, String str, int i2) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", oVar.n()).putExtra("selfshow_token", oVar.x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i2);
        return intent;
    }

    private static Notification a(Context context, o oVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (j.a(oVar) == k.STYLE_BIGTEXT) {
            j.a(builder, oVar.f(), oVar);
        }
        h.a(context, builder, oVar);
        b(oVar, builder);
        d(oVar, builder);
        a(context, oVar, builder);
        a(builder);
        a(oVar, builder);
        c(oVar, builder);
        builder.setContentIntent(c(context, oVar, iArr));
        builder.setDeleteIntent(b(context, oVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, oVar);
        a(context, builder, oVar);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    private static void a(Context context, Notification.Builder builder, o oVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !e.a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String j2 = oVar.j();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + j2);
        if (!TextUtils.isEmpty(j2)) {
            String a2 = e.a(context, j2);
            HMSLog.i("PushSelfShowLog", "the app name is:" + a2);
            if (a2 != null) {
                bundle.putCharSequence("android.extraAppName", a2);
            }
        }
        builder.setExtras(bundle);
    }

    private static void a(Context context, o oVar, Notification.Builder builder) {
        Bitmap a2 = h.a(context, oVar);
        if (a2 != null) {
            builder.setLargeIcon(a2);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void a(o oVar, Notification.Builder builder) {
        builder.setAutoCancel(oVar.d() == 1);
        builder.setOngoing(false);
    }

    private static boolean a(o oVar) {
        return oVar == null || (TextUtils.isEmpty(oVar.t()) && TextUtils.isEmpty(oVar.i()));
    }
}
