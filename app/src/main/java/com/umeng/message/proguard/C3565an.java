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

/* renamed from: com.umeng.message.proguard.an */
/* loaded from: classes2.dex */
public final class C3565an extends AbstractRunnableC3583c {

    /* renamed from: b */
    private static final Object f13216b = new Object();

    /* renamed from: c */
    private final C3554ac f13217c;

    /* renamed from: d */
    private long f13218d;

    public C3565an(C3554ac c3554ac) {
        this.f13217c = c3554ac;
    }

    /* renamed from: a */
    private StatusBarNotification m12270a(NotificationManager notificationManager) {
        C3554ac c3554ac = this.f13217c;
        if (c3554ac == null || c3554ac.f13151b == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications != null && activeNotifications.length != 0) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (TextUtils.equals(statusBarNotification.getTag(), "um") && statusBarNotification.getId() == this.f13217c.f13150a) {
                        return statusBarNotification;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            UPLog.m12143e("RePop", th);
            return null;
        }
    }

    @Override // com.umeng.message.proguard.AbstractRunnableC3583c
    /* renamed from: b */
    public final Future<?> mo12271b() {
        if (m12342d()) {
            return this.f13267a;
        }
        C3554ac c3554ac = this.f13217c;
        if (c3554ac == null) {
            return this.f13267a;
        }
        if (c3554ac.f13151b == null) {
            return this.f13267a;
        }
        boolean z = false;
        long j2 = this.f13218d;
        if (j2 == 0) {
            this.f13218d = System.currentTimeMillis();
            z = true;
        } else if (!C3586f.m12387a(j2)) {
            return this.f13267a;
        }
        Application m12460a = C3604x.m12460a();
        if (MessageSharedPrefs.getInstance(m12460a).m12135o() >= MessageSharedPrefs.getInstance(m12460a).m12134n()) {
            return this.f13267a;
        }
        this.f13267a = C3578b.m12321a(this, z ? r0.getRepostStart() : r0.getRepostInterval(), TimeUnit.MINUTES);
        return this.f13267a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (f13216b) {
                if (Build.VERSION.SDK_INT < 18) {
                    this.f13267a = null;
                    UPLog.m12142d("RePop", "not support sdk:", Integer.valueOf(Build.VERSION.SDK_INT));
                    return;
                }
                if (this.f13217c == null) {
                    this.f13267a = null;
                    return;
                }
                if (!C3586f.m12387a(this.f13218d)) {
                    this.f13267a = null;
                    return;
                }
                Application m12460a = C3604x.m12460a();
                NotificationManager notificationManager = (NotificationManager) m12460a.getSystemService("notification");
                if (notificationManager == null) {
                    this.f13267a = null;
                    UPLog.m12142d("RePop", "mgr null!");
                    return;
                }
                StatusBarNotification m12270a = m12270a(notificationManager);
                if (m12270a == null) {
                    this.f13267a = null;
                    UPLog.m12142d("RePop", "sbn null! msgId:", this.f13217c.f13151b.getMsgId());
                    return;
                }
                int m12134n = MessageSharedPrefs.getInstance(m12460a).m12134n();
                int m12135o = MessageSharedPrefs.getInstance(m12460a).m12135o();
                UPLog.m12142d("RePop", "task total times:", Integer.valueOf(m12135o), "config:", Integer.valueOf(m12134n));
                if (m12135o >= m12134n) {
                    return;
                }
                Notification notification = m12270a.getNotification();
                if (notification != null) {
                    notificationManager.cancel("um", this.f13217c.f13150a);
                    notification.when = System.currentTimeMillis();
                    notificationManager.notify("um", this.f13217c.f13150a, notification);
                    this.f13267a = null;
                    this.f13217c.f13153d++;
                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(m12460a);
                    Calendar calendar = Calendar.getInstance();
                    messageSharedPrefs.f13043b.m12285a("re_pop_times", String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)), Integer.valueOf(m12135o + 1)));
                    UTrack.getInstance().trackMsgRepost(this.f13217c.f13151b, notification);
                    UPLog.m12142d("RePop", "show msgId:", this.f13217c.f13151b.getMsgId(), "count:", Integer.valueOf(this.f13217c.f13153d));
                    m12340a();
                }
            }
        } catch (Throwable th) {
            UPLog.m12143e("RePop", th);
        }
    }
}
