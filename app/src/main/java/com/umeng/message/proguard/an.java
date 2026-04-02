package com.umeng.message.proguard;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.common.UPLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class an extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f7992b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ac f7993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7994d;

    public an(ac acVar) {
        this.f7993c = acVar;
    }

    private StatusBarNotification a(NotificationManager notificationManager) {
        ac acVar = this.f7993c;
        if (acVar == null || acVar.f7944b == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications != null && activeNotifications.length != 0) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (TextUtils.equals(statusBarNotification.getTag(), "um") && statusBarNotification.getId() == this.f7993c.a) {
                        return statusBarNotification;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            UPLog.e("RePop", th);
            return null;
        }
    }

    @Override // com.umeng.message.proguard.c
    public final Future<?> b() {
        if (d()) {
            return this.a;
        }
        ac acVar = this.f7993c;
        if (acVar == null) {
            return this.a;
        }
        if (acVar.f7944b == null) {
            return this.a;
        }
        boolean z = false;
        long j2 = this.f7994d;
        if (j2 == 0) {
            this.f7994d = System.currentTimeMillis();
            z = true;
        } else if (!f.a(j2)) {
            return this.a;
        }
        Application applicationA = x.a();
        if (MessageSharedPrefs.getInstance(applicationA).o() >= MessageSharedPrefs.getInstance(applicationA).n()) {
            return this.a;
        }
        this.a = b.a(this, z ? r0.getRepostStart() : r0.getRepostInterval(), TimeUnit.MINUTES);
        return this.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (f7992b) {
                if (Build.VERSION.SDK_INT < 18) {
                    this.a = null;
                    UPLog.d("RePop", "not support sdk:", Integer.valueOf(Build.VERSION.SDK_INT));
                    return;
                }
                if (this.f7993c == null) {
                    this.a = null;
                    return;
                }
                if (!f.a(this.f7994d)) {
                    this.a = null;
                    return;
                }
                Application applicationA = x.a();
                NotificationManager notificationManager = (NotificationManager) applicationA.getSystemService("notification");
                if (notificationManager == null) {
                    this.a = null;
                    UPLog.d("RePop", "mgr null!");
                    return;
                }
                StatusBarNotification statusBarNotificationA = a(notificationManager);
                if (statusBarNotificationA == null) {
                    this.a = null;
                    UPLog.d("RePop", "sbn null! msgId:", this.f7993c.f7944b.getMsgId());
                    return;
                }
                int iN = MessageSharedPrefs.getInstance(applicationA).n();
                int iO = MessageSharedPrefs.getInstance(applicationA).o();
                UPLog.d("RePop", "task total times:", Integer.valueOf(iO), "config:", Integer.valueOf(iN));
                if (iO >= iN) {
                    return;
                }
                Notification notification = statusBarNotificationA.getNotification();
                if (notification != null) {
                    notificationManager.cancel("um", this.f7993c.a);
                    notification.when = System.currentTimeMillis();
                    notificationManager.notify("um", this.f7993c.a, notification);
                    this.a = null;
                    this.f7993c.f7946d++;
                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
                    Calendar calendar = Calendar.getInstance();
                    messageSharedPrefs.f7878b.a("re_pop_times", String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)), Integer.valueOf(iO + 1)));
                    UTrack.getInstance().trackMsgRepost(this.f7993c.f7944b, notification);
                    UPLog.d("RePop", "show msgId:", this.f7993c.f7944b.getMsgId(), "count:", Integer.valueOf(this.f7993c.f7946d));
                    a();
                }
            }
        } catch (Throwable th) {
            UPLog.e("RePop", th);
        }
    }
}
