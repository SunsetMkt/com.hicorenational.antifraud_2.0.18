package com.umeng.message;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.a;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.component.UmengNotificationClickActivity;
import com.umeng.message.component.UmengNotificationReceiver;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ac;
import com.umeng.message.proguard.am;
import com.umeng.message.proguard.an;
import com.umeng.message.proguard.aw;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.t;
import com.umeng.message.proguard.w;
import com.umeng.message.proguard.x;
import com.umeng.message.proguard.y;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class UmengMessageHandler implements UPushMessageHandler {

    /* renamed from: a, reason: collision with root package name */
    private static Date f11130a;

    /* renamed from: b, reason: collision with root package name */
    private int f11131b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification a(android.content.Context r22, com.umeng.message.entity.UMessage r23) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.a(android.content.Context, com.umeng.message.entity.UMessage):android.app.Notification");
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        UMessage uMessage2;
        UPLog.i("MsgHandler", "notification:", uMessage.getRaw());
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        boolean z = uMessage.getMsgTime() >= messageSharedPrefs.f11128b.b("last_msg_time", 0L);
        messageSharedPrefs.f11128b.a("last_msg_time", uMessage.getMsgTime());
        Notification notification = getNotification(context, uMessage);
        int notificationDefaults = getNotificationDefaults(context, uMessage);
        if (notification == null) {
            notification = a(context, uMessage);
        }
        if (notification == null) {
            UPLog.e("MsgHandler", "notification null");
            return;
        }
        int i2 = this.f11131b;
        if (i2 == 0) {
            this.f11131b = (int) SystemClock.elapsedRealtime();
        } else {
            this.f11131b = i2 + 1;
        }
        notification.deleteIntent = getDismissPendingIntent(context, uMessage);
        notification.contentIntent = getClickPendingIntent(context, uMessage);
        if ((notificationDefaults & 1) != 0) {
            Uri sound = getSound(context, uMessage);
            if (sound != null) {
                notification.sound = getSound(context, uMessage);
            }
            if (sound != null) {
                notificationDefaults ^= 1;
            }
        }
        notification.defaults = notificationDefaults;
        int i3 = this.f11131b;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (PushAgent.getInstance(context).getNotificationOnForeground() || !t.c()) {
                int b2 = MessageSharedPrefs.getInstance(context).b();
                if (b2 != 1 || z) {
                    w a2 = w.a();
                    if (b2 > 0) {
                        while (a2.c() >= b2) {
                            ac b3 = a2.b();
                            if (b3 != null) {
                                if (notificationManager != null) {
                                    notificationManager.cancel("um", b3.f11222a);
                                }
                                UTrack.getInstance().trackMsgDismissed(b3.f11223b);
                                am.a(b3);
                            }
                        }
                    }
                    ac acVar = new ac(i3, uMessage);
                    a2.a(acVar);
                    if (notificationManager != null) {
                        notificationManager.notify("um", i3, notification);
                        UTrack.getInstance().trackMsgShow(uMessage, notification);
                    }
                    if (Build.VERSION.SDK_INT >= 23 && (uMessage2 = acVar.f11223b) != null && acVar.f11224c == null && uMessage2.isRepost()) {
                        MessageSharedPrefs.getInstance(x.a()).f11128b.a("re_pop_cfg", uMessage2.getRepostCount());
                        acVar.f11224c = new an(acVar).a();
                    }
                } else {
                    UTrack.getInstance().trackMsgDismissed(uMessage);
                }
            } else {
                UPLog.i("MsgHandler", "foreground notification dismiss. msgId:", uMessage.getMsgId());
                UTrack.getInstance().trackMsgDismissed(uMessage);
            }
        } catch (Exception e2) {
            UPLog.e("MsgHandler", e2);
        }
        setBadgeNum(context, uMessage);
    }

    public Bitmap getBackgroundImage(Context context, UMessage uMessage) {
        try {
            String backgroundImageUrl = uMessage.getBackgroundImageUrl();
            if (TextUtils.isEmpty(backgroundImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(backgroundImageUrl)), bb.a(), bb.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            String barImageUrl = uMessage.getBarImageUrl();
            if (TextUtils.isEmpty(barImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(barImageUrl)), bb.a(), bb.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setFlags(335544320);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("NOTIFICATION_ID", this.f11131b);
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT < 23 ? CommonNetImpl.FLAG_AUTH : 335544320);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        intent.putExtra("NOTIFICATION_ID", this.f11131b);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : CommonNetImpl.FLAG_AUTH);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            String bigImage = uMessage.getBigImage();
            if (TextUtils.isEmpty(bigImage)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(bigImage)), bb.a(), bb.a(256.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0003, B:5:0x0009, B:9:0x0014, B:11:0x0033, B:24:0x003e, B:16:0x005d, B:14:0x004c, B:27:0x0048, B:22:0x0058), top: B:2:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap getLargeIcon(android.content.Context r6, com.umeng.message.entity.UMessage r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MsgHandler"
            r1 = 0
            boolean r2 = r7.isLargeIconFromInternet()     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L30
            java.lang.String r2 = r7.getLargeIconUrl()     // Catch: java.lang.Throwable -> L66
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L14
            return r1
        L14:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L66
            java.io.File r4 = com.umeng.message.proguard.f.g(r6)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = com.umeng.commonsdk.utils.UMUtils.MD5(r2)     // Catch: java.lang.Throwable -> L66
            r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> L66
            r2 = 1111490560(0x42400000, float:48.0)
            int r4 = com.umeng.message.proguard.bb.a(r2)     // Catch: java.lang.Throwable -> L66
            int r2 = com.umeng.message.proguard.bb.a(r2)     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = com.umeng.message.proguard.f.a(r3, r4, r2)     // Catch: java.lang.Throwable -> L66
            goto L31
        L30:
            r2 = r1
        L31:
            if (r2 != 0) goto L65
            r3 = -1
            java.lang.String r7 = r7.getLargeIconDrawableName()     // Catch: java.lang.Throwable -> L66
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L66
            if (r4 != 0) goto L4c
            com.umeng.message.proguard.a r4 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L66
            int r3 = r4.b(r7)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L66
            goto L5b
        L47:
            r7 = move-exception
            com.umeng.message.common.UPLog.e(r0, r7)     // Catch: java.lang.Throwable -> L66
            goto L5b
        L4c:
            java.lang.String r7 = "umeng_push_notification_default_large_icon"
            com.umeng.message.proguard.a r4 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L66
            int r3 = r4.b(r7)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L66
            goto L5b
        L57:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L66
        L5b:
            if (r3 <= 0) goto L65
            android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r6, r3)     // Catch: java.lang.Throwable -> L66
        L65:
            return r2
        L66:
            r6 = move-exception
            com.umeng.message.common.UPLog.e(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getLargeIcon(android.content.Context, com.umeng.message.entity.UMessage):android.graphics.Bitmap");
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public NotificationChannel getNotificationChannel() {
        return null;
    }

    public NotificationChannel getNotificationChannel(Context context, UMessage uMessage) {
        return getNotificationChannel();
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        Calendar calendar = Calendar.getInstance();
        if (isInNoDisturbTime(context)) {
            return 0;
        }
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        long g2 = messageSharedPrefs.g() * 1000;
        if (f11130a != null && calendar.getTimeInMillis() - f11130a.getTime() < g2) {
            return 0;
        }
        int h2 = messageSharedPrefs.h();
        UPLog.i("MsgHandler", "vibrate:", Integer.valueOf(h2));
        int i2 = (h2 != 1 && (h2 == 2 || !uMessage.isVibrate())) ? 0 : 2;
        int i3 = messageSharedPrefs.i();
        UPLog.i("MsgHandler", "lights:", Integer.valueOf(i3));
        if (i3 == 1 || (i3 != 2 && uMessage.isLights())) {
            i2 |= 4;
        }
        int j2 = messageSharedPrefs.j();
        UPLog.i("MsgHandler", "sound:", Integer.valueOf(j2));
        if (j2 == 1 || (j2 != 2 && uMessage.isSound())) {
            i2 |= 1;
        }
        f11130a = calendar.getTime();
        if (uMessage.isScreenOn()) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                boolean isScreenOn = powerManager.isScreenOn();
                UPLog.i("MsgHandler", "screen on:".concat(String.valueOf(isScreenOn)));
                if (!isScreenOn) {
                    powerManager.newWakeLock(805306374, "UPush:NTF").acquire(a.q);
                }
            } catch (Throwable th) {
                UPLog.e("MsgHandler", th);
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:3:0x0003, B:19:0x000d, B:9:0x002e, B:11:0x0040, B:6:0x001b, B:22:0x0017, B:17:0x0027), top: B:2:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e A[Catch: all -> 0x004a, TryCatch #2 {all -> 0x004a, blocks: (B:3:0x0003, B:19:0x000d, B:9:0x002e, B:11:0x0040, B:6:0x001b, B:22:0x0017, B:17:0x0027), top: B:2:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getSmallIconId(android.content.Context r6, com.umeng.message.entity.UMessage r7) {
        /*
            r5 = this;
            java.lang.String r0 = "MsgHandler"
            r1 = -1
            java.lang.String r7 = r7.getSmallIconDrawableName()     // Catch: java.lang.Throwable -> L4a
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L4a
            if (r2 != 0) goto L1b
            com.umeng.message.proguard.a r2 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L4a
            int r1 = r2.b(r7)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L4a
            goto L2a
        L16:
            r7 = move-exception
            com.umeng.message.common.UPLog.e(r0, r7)     // Catch: java.lang.Throwable -> L4a
            goto L2a
        L1b:
            java.lang.String r7 = "umeng_push_notification_default_small_icon"
            com.umeng.message.proguard.a r2 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L4a
            int r1 = r2.b(r7)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L4a
            goto L2a
        L26:
            r7 = move-exception
            com.umeng.message.common.UPLog.w(r0, r7)     // Catch: java.lang.Throwable -> L4a
        L2a:
            r7 = 0
            r2 = 1
            if (r1 >= 0) goto L3e
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "no custom notification small icon! change to use app icon"
            r3[r7] = r4     // Catch: java.lang.Throwable -> L4a
            com.umeng.message.common.UPLog.i(r0, r3)     // Catch: java.lang.Throwable -> L4a
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()     // Catch: java.lang.Throwable -> L4a
            int r6 = r6.icon     // Catch: java.lang.Throwable -> L4a
            r1 = r6
        L3e:
            if (r1 >= 0) goto L4e
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "can't find notification small icon"
            r6[r7] = r2     // Catch: java.lang.Throwable -> L4a
            com.umeng.message.common.UPLog.e(r0, r6)     // Catch: java.lang.Throwable -> L4a
            goto L4e
        L4a:
            r6 = move-exception
            com.umeng.message.common.UPLog.e(r0, r6)
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSmallIconId(android.content.Context, com.umeng.message.entity.UMessage):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if (r1.exists() == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.isSoundFromInternet()     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L22
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6b
            java.io.File r2 = com.umeng.message.proguard.f.g(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.MD5(r3)     // Catch: java.lang.Throwable -> L6b
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = r1.getPath()     // Catch: java.lang.Throwable -> L6b
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L23
        L22:
            r2 = r0
        L23:
            if (r2 != 0) goto L64
            r1 = -1
            java.lang.String r3 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L6b
            if (r3 != 0) goto L3c
            java.lang.String r6 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.c(r6)     // Catch: java.lang.Throwable -> L6b
        L3c:
            if (r1 >= 0) goto L48
            java.lang.String r6 = "umeng_push_notification_default_sound"
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.c(r6)     // Catch: java.lang.Throwable -> L6b
        L48:
            if (r1 <= 0) goto L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = "android.resource://"
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L6b
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "/"
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L6b
        L64:
            if (r2 == 0) goto L71
            android.net.Uri r5 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L6b
            return r5
        L6b:
            r5 = move-exception
            java.lang.String r6 = "MsgHandler"
            com.umeng.message.common.UPLog.w(r6, r5)
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        if ("notification".equals(uMessage.getDisplayType())) {
            dealWithNotificationMessage(context, uMessage);
            return;
        }
        if ("custom".equals(uMessage.getDisplayType())) {
            if (TextUtils.isEmpty(uMessage.getRecallMsgId())) {
                dealWithCustomMessage(context, uMessage);
                return;
            }
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return;
                }
                w a2 = w.a();
                ac a3 = a2.a(uMessage.getRecallMsgId());
                if (a3 == null) {
                    y.a().a(uMessage.getRecallMsgId(), 5);
                    return;
                }
                notificationManager.cancel("um", a3.f11222a);
                a2.b(a3);
                am.a(a3);
                y.a().a(uMessage.getRecallMsgId(), 4);
            } catch (Throwable th) {
                UPLog.e("MsgHandler", th);
            }
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        Calendar calendar = Calendar.getInstance();
        int i2 = (calendar.get(11) * 60) + calendar.get(12);
        boolean z = i2 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = i2 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        return (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute() ? z && z2 : z || z2;
    }

    public void setBadgeNum(Context context, UMessage uMessage) {
        if (uMessage.getBadgeSet() >= 0) {
            aw.a(context, uMessage.getBadgeSet());
            UPLog.d("MsgHandler", "setBadgeNum:", Integer.valueOf(uMessage.getBadgeSet()));
        } else if (uMessage.getBadgeAdd() != 0) {
            aw.b(context, uMessage.getBadgeAdd());
            UPLog.d("MsgHandler", "changeBadgeNum:", Integer.valueOf(uMessage.getBadgeAdd()));
        }
    }
}
