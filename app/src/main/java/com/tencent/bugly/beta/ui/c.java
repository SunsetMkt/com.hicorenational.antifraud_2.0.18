package com.tencent.bugly.beta.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static c a = new c();

    /* JADX INFO: renamed from: b */
    public DownloadTask f6051b;

    /* JADX INFO: renamed from: d */
    public y f6053d;

    /* JADX INFO: renamed from: e */
    public b f6054e;

    /* JADX INFO: renamed from: g */
    private Notification f6056g;

    /* JADX INFO: renamed from: j */
    private long f6059j;

    /* JADX INFO: renamed from: k */
    private NotificationCompat.Builder f6060k;

    /* JADX INFO: renamed from: i */
    private boolean f6058i = true;

    /* JADX INFO: renamed from: h */
    private Context f6057h = com.tencent.bugly.beta.global.e.G.u;

    /* JADX INFO: renamed from: c */
    public String f6052c = this.f6057h.getPackageName() + ".beta.DOWNLOAD_NOTIFY";

    /* JADX INFO: renamed from: f */
    private NotificationManager f6055f = (NotificationManager) this.f6057h.getSystemService("notification");

    private c() {
        this.f6057h.registerReceiver(new BetaReceiver(), new IntentFilter(this.f6052c));
        b();
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("001", "bugly_upgrade", 2);
            notificationChannel.setDescription("bugly upgrade");
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.f6055f.createNotificationChannel(notificationChannel);
        }
    }

    public void a(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        this.f6051b = downloadTask;
        this.f6059j = this.f6051b.getSavedLength();
        this.f6058i = downloadTask.isNeededNotify();
        if (this.f6058i && com.tencent.bugly.beta.global.e.G.T) {
            this.f6055f.cancel(1000);
            Intent intent = new Intent(this.f6052c);
            intent.putExtra(SocialConstants.TYPE_REQUEST, 1);
            if (this.f6060k == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        this.f6060k = new NotificationCompat.Builder(this.f6057h, "001");
                    } catch (Throwable unused) {
                        this.f6060k = new NotificationCompat.Builder(this.f6057h);
                    }
                } else {
                    this.f6060k = new NotificationCompat.Builder(this.f6057h);
                }
            }
            NotificationCompat.Builder contentTitle = this.f6060k.setTicker(Beta.strNotificationDownloading + com.tencent.bugly.beta.global.e.G.A).setContentTitle(com.tencent.bugly.beta.global.e.G.A);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            objArr[1] = Integer.valueOf((int) (this.f6051b.getTotalLength() != 0 ? (this.f6051b.getSavedLength() * 100) / this.f6051b.getTotalLength() : 0L));
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.f6057h, 1, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(false);
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
            int i2 = eVar.f6024h;
            if (i2 > 0) {
                this.f6060k.setSmallIcon(i2);
            } else {
                PackageInfo packageInfo = eVar.B;
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    this.f6060k.setSmallIcon(applicationInfo.icon);
                }
            }
            try {
                if (com.tencent.bugly.beta.global.e.G.f6025i > 0 && this.f6057h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f6025i) != null) {
                    this.f6060k.setLargeIcon(com.tencent.bugly.beta.global.a.a(this.f6057h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f6025i)));
                }
            } catch (Resources.NotFoundException e2) {
                an.c(c.class, "[initNotify] " + e2.getMessage(), new Object[0]);
            }
            this.f6056g = this.f6060k.build();
            this.f6055f.notify(1000, this.f6056g);
        }
    }

    public void a() {
        DownloadTask downloadTask;
        if (this.f6058i && (downloadTask = this.f6051b) != null && com.tencent.bugly.beta.global.e.G.T) {
            if (downloadTask.getSavedLength() - this.f6059j > 307200 || this.f6051b.getStatus() == 1 || this.f6051b.getStatus() == 5 || this.f6051b.getStatus() == 3) {
                this.f6059j = this.f6051b.getSavedLength();
                if (this.f6051b.getStatus() == 1) {
                    this.f6060k.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationDownloadSucc));
                } else if (this.f6051b.getStatus() == 5) {
                    this.f6060k.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationDownloadError));
                } else {
                    if (this.f6051b.getStatus() == 2) {
                        NotificationCompat.Builder contentTitle = this.f6060k.setContentTitle(com.tencent.bugly.beta.global.e.G.A);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        objArr[1] = Integer.valueOf((int) (this.f6051b.getTotalLength() != 0 ? (this.f6051b.getSavedLength() * 100) / this.f6051b.getTotalLength() : 0L));
                        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setAutoCancel(false);
                    } else if (this.f6051b.getStatus() == 3) {
                        NotificationCompat.Builder contentTitle2 = this.f6060k.setContentTitle(com.tencent.bugly.beta.global.e.G.A);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        objArr2[1] = Integer.valueOf((int) (this.f6051b.getTotalLength() != 0 ? (this.f6051b.getSavedLength() * 100) / this.f6051b.getTotalLength() : 0L));
                        contentTitle2.setContentText(String.format(locale2, "%s %d%%", objArr2)).setAutoCancel(false);
                    }
                }
                this.f6056g = this.f6060k.build();
                this.f6055f.notify(1000, this.f6056g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6 A[Catch: all -> 0x0109, TryCatch #0 {, blocks: (B:38:0x0001, B:40:0x001d, B:46:0x0039, B:45:0x002f, B:47:0x0042, B:49:0x00a6, B:55:0x00cb, B:57:0x00d1, B:59:0x00e1, B:60:0x00f8, B:50:0x00b0, B:52:0x00b6, B:54:0x00be, B:43:0x0023), top: B:66:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0 A[Catch: all -> 0x0109, TryCatch #0 {, blocks: (B:38:0x0001, B:40:0x001d, B:46:0x0039, B:45:0x002f, B:47:0x0042, B:49:0x00a6, B:55:0x00cb, B:57:0x00d1, B:59:0x00e1, B:60:0x00f8, B:50:0x00b0, B:52:0x00b6, B:54:0x00be, B:43:0x0023), top: B:66:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(y yVar, b bVar) {
        this.f6053d = yVar;
        this.f6054e = bVar;
        this.f6055f.cancel(1001);
        Intent intent = new Intent(this.f6052c);
        intent.putExtra(SocialConstants.TYPE_REQUEST, 2);
        if (this.f6060k == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.f6060k = new NotificationCompat.Builder(this.f6057h, "001");
                } catch (Throwable unused) {
                    this.f6060k = new NotificationCompat.Builder(this.f6057h);
                }
            } else {
                this.f6060k = new NotificationCompat.Builder(this.f6057h);
            }
            this.f6060k.setTicker(com.tencent.bugly.beta.global.e.G.A + Beta.strNotificationHaveNewVersion).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationHaveNewVersion)).setContentIntent(PendingIntent.getBroadcast(this.f6057h, 2, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(true).setContentText(String.format("%s.%s", yVar.f6598e.f6575d, Integer.valueOf(yVar.f6598e.f6574c)));
            if (com.tencent.bugly.beta.global.e.G.f6024h <= 0) {
            }
            if (com.tencent.bugly.beta.global.e.G.f6025i > 0) {
                this.f6060k.setLargeIcon(com.tencent.bugly.beta.global.a.a(this.f6057h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f6025i)));
            }
            this.f6056g = this.f6060k.build();
            this.f6055f.notify(1001, this.f6056g);
        } else {
            this.f6060k.setTicker(com.tencent.bugly.beta.global.e.G.A + Beta.strNotificationHaveNewVersion).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationHaveNewVersion)).setContentIntent(PendingIntent.getBroadcast(this.f6057h, 2, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(true).setContentText(String.format("%s.%s", yVar.f6598e.f6575d, Integer.valueOf(yVar.f6598e.f6574c)));
            if (com.tencent.bugly.beta.global.e.G.f6024h <= 0) {
                this.f6060k.setSmallIcon(com.tencent.bugly.beta.global.e.G.f6024h);
            } else if (com.tencent.bugly.beta.global.e.G.B != null && com.tencent.bugly.beta.global.e.G.B.applicationInfo != null) {
                this.f6060k.setSmallIcon(com.tencent.bugly.beta.global.e.G.B.applicationInfo.icon);
            }
            if (com.tencent.bugly.beta.global.e.G.f6025i > 0 && this.f6057h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f6025i) != null) {
                this.f6060k.setLargeIcon(com.tencent.bugly.beta.global.a.a(this.f6057h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f6025i)));
            }
            this.f6056g = this.f6060k.build();
            this.f6055f.notify(1001, this.f6056g);
        }
    }
}
