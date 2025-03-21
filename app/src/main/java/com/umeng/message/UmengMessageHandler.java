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
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.component.UmengNotificationClickActivity;
import com.umeng.message.component.UmengNotificationReceiver;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C3554ac;
import com.umeng.message.proguard.C3564am;
import com.umeng.message.proguard.C3565an;
import com.umeng.message.proguard.C3574aw;
import com.umeng.message.proguard.C3580bb;
import com.umeng.message.proguard.C3586f;
import com.umeng.message.proguard.C3600t;
import com.umeng.message.proguard.C3603w;
import com.umeng.message.proguard.C3604x;
import com.umeng.message.proguard.C3605y;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
public class UmengMessageHandler implements UPushMessageHandler {

    /* renamed from: a */
    private static Date f13045a;

    /* renamed from: b */
    private int f13046b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0197  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification m12136a(android.content.Context r22, com.umeng.message.entity.UMessage r23) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.m12136a(android.content.Context, com.umeng.message.entity.UMessage):android.app.Notification");
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        UMessage uMessage2;
        UPLog.m12145i("MsgHandler", "notification:", uMessage.getRaw());
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        boolean z = uMessage.getMsgTime() >= messageSharedPrefs.f13043b.m12289b("last_msg_time", 0L);
        messageSharedPrefs.f13043b.m12284a("last_msg_time", uMessage.getMsgTime());
        Notification notification = getNotification(context, uMessage);
        int notificationDefaults = getNotificationDefaults(context, uMessage);
        if (notification == null) {
            notification = m12136a(context, uMessage);
        }
        if (notification == null) {
            UPLog.m12144e("MsgHandler", "notification null");
            return;
        }
        int i2 = this.f13046b;
        if (i2 == 0) {
            this.f13046b = (int) SystemClock.elapsedRealtime();
        } else {
            this.f13046b = i2 + 1;
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
        int i3 = this.f13046b;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (PushAgent.getInstance(context).getNotificationOnForeground() || !C3600t.m12447c()) {
                int m12120b = MessageSharedPrefs.getInstance(context).m12120b();
                if (m12120b != 1 || z) {
                    C3603w m12454a = C3603w.m12454a();
                    if (m12120b > 0) {
                        while (m12454a.m12459c() >= m12120b) {
                            C3554ac m12457b = m12454a.m12457b();
                            if (m12457b != null) {
                                if (notificationManager != null) {
                                    notificationManager.cancel("um", m12457b.f13150a);
                                }
                                UTrack.getInstance().trackMsgDismissed(m12457b.f13151b);
                                C3564am.m12269a(m12457b);
                            }
                        }
                    }
                    C3554ac c3554ac = new C3554ac(i3, uMessage);
                    m12454a.m12456a(c3554ac);
                    if (notificationManager != null) {
                        notificationManager.notify("um", i3, notification);
                        UTrack.getInstance().trackMsgShow(uMessage, notification);
                    }
                    if (Build.VERSION.SDK_INT >= 23 && (uMessage2 = c3554ac.f13151b) != null && c3554ac.f13152c == null && uMessage2.isRepost()) {
                        MessageSharedPrefs.getInstance(C3604x.m12460a()).f13043b.m12283a("re_pop_cfg", uMessage2.getRepostCount());
                        c3554ac.f13152c = new C3565an(c3554ac).m12340a();
                    }
                } else {
                    UTrack.getInstance().trackMsgDismissed(uMessage);
                }
            } else {
                UPLog.m12145i("MsgHandler", "foreground notification dismiss. msgId:", uMessage.getMsgId());
                UTrack.getInstance().trackMsgDismissed(uMessage);
            }
        } catch (Exception e2) {
            UPLog.m12143e("MsgHandler", e2);
        }
        setBadgeNum(context, uMessage);
    }

    public Bitmap getBackgroundImage(Context context, UMessage uMessage) {
        try {
            String backgroundImageUrl = uMessage.getBackgroundImageUrl();
            if (TextUtils.isEmpty(backgroundImageUrl)) {
                return null;
            }
            return C3586f.m12379a(new File(C3586f.m12396g(context), UMUtils.MD5(backgroundImageUrl)), C3580bb.m12336a(), C3580bb.m12337a(64.0f));
        } catch (Throwable th) {
            UPLog.m12143e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            String barImageUrl = uMessage.getBarImageUrl();
            if (TextUtils.isEmpty(barImageUrl)) {
                return null;
            }
            return C3586f.m12379a(new File(C3586f.m12396g(context), UMUtils.MD5(barImageUrl)), C3580bb.m12336a(), C3580bb.m12337a(64.0f));
        } catch (Throwable th) {
            UPLog.m12143e("MsgHandler", th);
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setFlags(335544320);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("NOTIFICATION_ID", this.f13046b);
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT < 23 ? CommonNetImpl.FLAG_AUTH : 335544320);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        intent.putExtra("NOTIFICATION_ID", this.f13046b);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : CommonNetImpl.FLAG_AUTH);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            String bigImage = uMessage.getBigImage();
            if (TextUtils.isEmpty(bigImage)) {
                return null;
            }
            return C3586f.m12379a(new File(C3586f.m12396g(context), UMUtils.MD5(bigImage)), C3580bb.m12336a(), C3580bb.m12337a(256.0f));
        } catch (Throwable th) {
            UPLog.m12143e("MsgHandler", th);
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
            java.io.File r4 = com.umeng.message.proguard.C3586f.m12396g(r6)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = com.umeng.commonsdk.utils.UMUtils.MD5(r2)     // Catch: java.lang.Throwable -> L66
            r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> L66
            r2 = 1111490560(0x42400000, float:48.0)
            int r4 = com.umeng.message.proguard.C3580bb.m12337a(r2)     // Catch: java.lang.Throwable -> L66
            int r2 = com.umeng.message.proguard.C3580bb.m12337a(r2)     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = com.umeng.message.proguard.C3586f.m12379a(r3, r4, r2)     // Catch: java.lang.Throwable -> L66
            goto L31
        L30:
            r2 = r1
        L31:
            if (r2 != 0) goto L65
            r3 = -1
            java.lang.String r7 = r7.getLargeIconDrawableName()     // Catch: java.lang.Throwable -> L66
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L66
            if (r4 != 0) goto L4c
            com.umeng.message.proguard.a r4 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L66
            int r3 = r4.m12220b(r7)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L66
            goto L5b
        L47:
            r7 = move-exception
            com.umeng.message.common.UPLog.m12143e(r0, r7)     // Catch: java.lang.Throwable -> L66
            goto L5b
        L4c:
            java.lang.String r7 = "umeng_push_notification_default_large_icon"
            com.umeng.message.proguard.a r4 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L66
            int r3 = r4.m12220b(r7)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L66
            goto L5b
        L57:
            r7 = move-exception
            com.umeng.message.common.UPLog.m12146w(r0, r7)     // Catch: java.lang.Throwable -> L66
        L5b:
            if (r3 <= 0) goto L65
            android.content.res.Resources r6 = r6.getResources()     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r6, r3)     // Catch: java.lang.Throwable -> L66
        L65:
            return r2
        L66:
            r6 = move-exception
            com.umeng.message.common.UPLog.m12143e(r0, r6)
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
        long m12127g = messageSharedPrefs.m12127g() * 1000;
        if (f13045a != null && calendar.getTimeInMillis() - f13045a.getTime() < m12127g) {
            return 0;
        }
        int m12128h = messageSharedPrefs.m12128h();
        UPLog.m12145i("MsgHandler", "vibrate:", Integer.valueOf(m12128h));
        int i2 = (m12128h != 1 && (m12128h == 2 || !uMessage.isVibrate())) ? 0 : 2;
        int m12129i = messageSharedPrefs.m12129i();
        UPLog.m12145i("MsgHandler", "lights:", Integer.valueOf(m12129i));
        if (m12129i == 1 || (m12129i != 2 && uMessage.isLights())) {
            i2 |= 4;
        }
        int m12130j = messageSharedPrefs.m12130j();
        UPLog.m12145i("MsgHandler", "sound:", Integer.valueOf(m12130j));
        if (m12130j == 1 || (m12130j != 2 && uMessage.isSound())) {
            i2 |= 1;
        }
        f13045a = calendar.getTime();
        if (uMessage.isScreenOn()) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                boolean isScreenOn = powerManager.isScreenOn();
                UPLog.m12145i("MsgHandler", "screen on:".concat(String.valueOf(isScreenOn)));
                if (!isScreenOn) {
                    powerManager.newWakeLock(805306374, "UPush:NTF").acquire(C2084a.f6135q);
                }
            } catch (Throwable th) {
                UPLog.m12143e("MsgHandler", th);
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
            com.umeng.message.proguard.a r2 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L4a
            int r1 = r2.m12220b(r7)     // Catch: java.lang.Exception -> L16 java.lang.Throwable -> L4a
            goto L2a
        L16:
            r7 = move-exception
            com.umeng.message.common.UPLog.m12143e(r0, r7)     // Catch: java.lang.Throwable -> L4a
            goto L2a
        L1b:
            java.lang.String r7 = "umeng_push_notification_default_small_icon"
            com.umeng.message.proguard.a r2 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L4a
            int r1 = r2.m12220b(r7)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L4a
            goto L2a
        L26:
            r7 = move-exception
            com.umeng.message.common.UPLog.m12146w(r0, r7)     // Catch: java.lang.Throwable -> L4a
        L2a:
            r7 = 0
            r2 = 1
            if (r1 >= 0) goto L3e
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "no custom notification small icon! change to use app icon"
            r3[r7] = r4     // Catch: java.lang.Throwable -> L4a
            com.umeng.message.common.UPLog.m12145i(r0, r3)     // Catch: java.lang.Throwable -> L4a
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()     // Catch: java.lang.Throwable -> L4a
            int r6 = r6.icon     // Catch: java.lang.Throwable -> L4a
            r1 = r6
        L3e:
            if (r1 >= 0) goto L4e
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "can't find notification small icon"
            r6[r7] = r2     // Catch: java.lang.Throwable -> L4a
            com.umeng.message.common.UPLog.m12144e(r0, r6)     // Catch: java.lang.Throwable -> L4a
            goto L4e
        L4a:
            r6 = move-exception
            com.umeng.message.common.UPLog.m12143e(r0, r6)
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
            java.io.File r2 = com.umeng.message.proguard.C3586f.m12396g(r5)     // Catch: java.lang.Throwable -> L6b
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
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.m12221c(r6)     // Catch: java.lang.Throwable -> L6b
        L3c:
            if (r1 >= 0) goto L48
            java.lang.String r6 = "umeng_push_notification_default_sound"
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.C3551a.m12219a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.m12221c(r6)     // Catch: java.lang.Throwable -> L6b
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
            com.umeng.message.common.UPLog.m12146w(r6, r5)
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
                C3603w m12454a = C3603w.m12454a();
                C3554ac m12455a = m12454a.m12455a(uMessage.getRecallMsgId());
                if (m12455a == null) {
                    C3605y.m12463a().m12472a(uMessage.getRecallMsgId(), 5);
                    return;
                }
                notificationManager.cancel("um", m12455a.f13150a);
                m12454a.m12458b(m12455a);
                C3564am.m12269a(m12455a);
                C3605y.m12463a().m12472a(uMessage.getRecallMsgId(), 4);
            } catch (Throwable th) {
                UPLog.m12143e("MsgHandler", th);
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
            C3574aw.m12312a(context, uMessage.getBadgeSet());
            UPLog.m12142d("MsgHandler", "setBadgeNum:", Integer.valueOf(uMessage.getBadgeSet()));
        } else if (uMessage.getBadgeAdd() != 0) {
            C3574aw.m12314b(context, uMessage.getBadgeAdd());
            UPLog.m12142d("MsgHandler", "changeBadgeNum:", Integer.valueOf(uMessage.getBadgeAdd()));
        }
    }
}
