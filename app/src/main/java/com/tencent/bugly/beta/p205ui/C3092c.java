package com.tencent.bugly.beta.p205ui;

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
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3200y;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.c */
/* loaded from: classes2.dex */
public class C3092c {

    /* renamed from: a */
    public static C3092c f9950a = new C3092c();

    /* renamed from: b */
    public DownloadTask f9951b;

    /* renamed from: d */
    public C3200y f9953d;

    /* renamed from: e */
    public AbstractC3091b f9954e;

    /* renamed from: g */
    private Notification f9956g;

    /* renamed from: j */
    private long f9959j;

    /* renamed from: k */
    private NotificationCompat.Builder f9960k;

    /* renamed from: i */
    private boolean f9958i = true;

    /* renamed from: h */
    private Context f9957h = C3082e.f9867G.f9919u;

    /* renamed from: c */
    public String f9952c = this.f9957h.getPackageName() + ".beta.DOWNLOAD_NOTIFY";

    /* renamed from: f */
    private NotificationManager f9955f = (NotificationManager) this.f9957h.getSystemService("notification");

    private C3092c() {
        this.f9957h.registerReceiver(new BetaReceiver(), new IntentFilter(this.f9952c));
        m9355b();
    }

    /* renamed from: b */
    private void m9355b() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("001", "bugly_upgrade", 2);
            notificationChannel.setDescription("bugly upgrade");
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.f9955f.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    public void m9357a(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        this.f9951b = downloadTask;
        this.f9959j = this.f9951b.getSavedLength();
        this.f9958i = downloadTask.isNeededNotify();
        if (this.f9958i && C3082e.f9867G.f9887T) {
            this.f9955f.cancel(1000);
            Intent intent = new Intent(this.f9952c);
            intent.putExtra(SocialConstants.TYPE_REQUEST, 1);
            if (this.f9960k == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        this.f9960k = new NotificationCompat.Builder(this.f9957h, "001");
                    } catch (Throwable unused) {
                        this.f9960k = new NotificationCompat.Builder(this.f9957h);
                    }
                } else {
                    this.f9960k = new NotificationCompat.Builder(this.f9957h);
                }
            }
            NotificationCompat.Builder contentTitle = this.f9960k.setTicker(Beta.strNotificationDownloading + C3082e.f9867G.f9869A).setContentTitle(C3082e.f9867G.f9869A);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            objArr[1] = Integer.valueOf((int) (this.f9951b.getTotalLength() != 0 ? (this.f9951b.getSavedLength() * 100) / this.f9951b.getTotalLength() : 0L));
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.f9957h, 1, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(false);
            C3082e c3082e = C3082e.f9867G;
            int i2 = c3082e.f9906h;
            if (i2 > 0) {
                this.f9960k.setSmallIcon(i2);
            } else {
                PackageInfo packageInfo = c3082e.f9870B;
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    this.f9960k.setSmallIcon(applicationInfo.icon);
                }
            }
            try {
                if (C3082e.f9867G.f9907i > 0 && this.f9957h.getResources().getDrawable(C3082e.f9867G.f9907i) != null) {
                    this.f9960k.setLargeIcon(C3078a.m9324a(this.f9957h.getResources().getDrawable(C3082e.f9867G.f9907i)));
                }
            } catch (Resources.NotFoundException e2) {
                C3151an.m9920c(C3092c.class, "[initNotify] " + e2.getMessage(), new Object[0]);
            }
            this.f9956g = this.f9960k.build();
            this.f9955f.notify(1000, this.f9956g);
        }
    }

    /* renamed from: a */
    public void m9356a() {
        DownloadTask downloadTask;
        if (this.f9958i && (downloadTask = this.f9951b) != null && C3082e.f9867G.f9887T) {
            if (downloadTask.getSavedLength() - this.f9959j > 307200 || this.f9951b.getStatus() == 1 || this.f9951b.getStatus() == 5 || this.f9951b.getStatus() == 3) {
                this.f9959j = this.f9951b.getSavedLength();
                if (this.f9951b.getStatus() == 1) {
                    this.f9960k.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", C3082e.f9867G.f9869A, Beta.strNotificationDownloadSucc));
                } else if (this.f9951b.getStatus() == 5) {
                    this.f9960k.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", C3082e.f9867G.f9869A, Beta.strNotificationDownloadError));
                } else {
                    if (this.f9951b.getStatus() == 2) {
                        NotificationCompat.Builder contentTitle = this.f9960k.setContentTitle(C3082e.f9867G.f9869A);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        objArr[1] = Integer.valueOf((int) (this.f9951b.getTotalLength() != 0 ? (this.f9951b.getSavedLength() * 100) / this.f9951b.getTotalLength() : 0L));
                        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setAutoCancel(false);
                    } else if (this.f9951b.getStatus() == 3) {
                        NotificationCompat.Builder contentTitle2 = this.f9960k.setContentTitle(C3082e.f9867G.f9869A);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        objArr2[1] = Integer.valueOf((int) (this.f9951b.getTotalLength() != 0 ? (this.f9951b.getSavedLength() * 100) / this.f9951b.getTotalLength() : 0L));
                        contentTitle2.setContentText(String.format(locale2, "%s %d%%", objArr2)).setAutoCancel(false);
                    }
                }
                this.f9956g = this.f9960k.build();
                this.f9955f.notify(1000, this.f9956g);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m9358a(C3200y c3200y, AbstractC3091b abstractC3091b) {
        this.f9953d = c3200y;
        this.f9954e = abstractC3091b;
        this.f9955f.cancel(1001);
        Intent intent = new Intent(this.f9952c);
        intent.putExtra(SocialConstants.TYPE_REQUEST, 2);
        if (this.f9960k == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    this.f9960k = new NotificationCompat.Builder(this.f9957h, "001");
                } catch (Throwable unused) {
                    this.f9960k = new NotificationCompat.Builder(this.f9957h);
                }
            } else {
                this.f9960k = new NotificationCompat.Builder(this.f9957h);
            }
        }
        this.f9960k.setTicker(C3082e.f9867G.f9869A + Beta.strNotificationHaveNewVersion).setContentTitle(String.format("%s %s", C3082e.f9867G.f9869A, Beta.strNotificationHaveNewVersion)).setContentIntent(PendingIntent.getBroadcast(this.f9957h, 2, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(true).setContentText(String.format("%s.%s", c3200y.f10836e.f10805d, Integer.valueOf(c3200y.f10836e.f10804c)));
        if (C3082e.f9867G.f9906h > 0) {
            this.f9960k.setSmallIcon(C3082e.f9867G.f9906h);
        } else if (C3082e.f9867G.f9870B != null && C3082e.f9867G.f9870B.applicationInfo != null) {
            this.f9960k.setSmallIcon(C3082e.f9867G.f9870B.applicationInfo.icon);
        }
        if (C3082e.f9867G.f9907i > 0 && this.f9957h.getResources().getDrawable(C3082e.f9867G.f9907i) != null) {
            this.f9960k.setLargeIcon(C3078a.m9324a(this.f9957h.getResources().getDrawable(C3082e.f9867G.f9907i)));
        }
        this.f9956g = this.f9960k.build();
        this.f9955f.notify(1001, this.f9956g);
    }
}
