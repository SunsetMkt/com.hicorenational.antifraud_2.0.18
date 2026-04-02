package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes2.dex */
public class en implements fd {
    private int a;

    /* JADX INFO: renamed from: a */
    fa f451a;

    /* JADX INFO: renamed from: a */
    XMPushService f452a;

    /* JADX INFO: renamed from: a */
    private Exception f453a;

    /* JADX INFO: renamed from: e */
    private long f8953e;

    /* JADX INFO: renamed from: f */
    private long f8954f;

    /* JADX INFO: renamed from: a */
    private long f450a = 0;

    /* JADX INFO: renamed from: b */
    private long f8950b = 0;

    /* JADX INFO: renamed from: c */
    private long f8951c = 0;

    /* JADX INFO: renamed from: d */
    private long f8952d = 0;

    /* JADX INFO: renamed from: a */
    private String f454a = "";

    en(XMPushService xMPushService) {
        this.f8953e = 0L;
        this.f8954f = 0L;
        this.f452a = xMPushService;
        b();
        int iMyUid = Process.myUid();
        try {
            this.f8954f = TrafficStats.getUidRxBytes(iMyUid);
            this.f8953e = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Failed to obtain traffic data during initialization: " + e2);
            this.f8954f = -1L;
            this.f8953e = -1L;
        }
    }

    private void b() {
        this.f8950b = 0L;
        this.f8952d = 0L;
        this.f450a = 0L;
        this.f8951c = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (au.m149a((Context) this.f452a)) {
            this.f450a = jElapsedRealtime;
        }
        if (this.f452a.m666c()) {
            this.f8951c = jElapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f454a + " netDuration = " + this.f8950b + " ChannelDuration = " + this.f8952d + " channelConnectedTime = " + this.f8951c);
        ej ejVar = new ej();
        ejVar.f429a = (byte) 0;
        ejVar.a(ei.CHANNEL_ONLINE_RATE.a());
        ejVar.a(this.f454a);
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        ejVar.b((int) (this.f8950b / 1000));
        ejVar.c((int) (this.f8952d / 1000));
        eo.m380a().a(ejVar);
        b();
    }

    Exception a() {
        return this.f453a;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m379a() {
        if (this.f452a == null) {
            return;
        }
        String strM145a = au.m145a((Context) this.f452a);
        boolean zB = au.b(this.f452a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f450a > 0) {
            this.f8950b += jElapsedRealtime - this.f450a;
            this.f450a = 0L;
        }
        if (this.f8951c != 0) {
            this.f8952d += jElapsedRealtime - this.f8951c;
            this.f8951c = 0L;
        }
        if (zB) {
            if ((!TextUtils.equals(this.f454a, strM145a) && this.f8950b > 30000) || this.f8950b > 5400000) {
                c();
            }
            this.f454a = strM145a;
            if (this.f450a == 0) {
                this.f450a = jElapsedRealtime;
            }
            if (this.f452a.m666c()) {
                this.f8951c = jElapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        m379a();
        this.f8951c = SystemClock.elapsedRealtime();
        ep.a(0, ei.CONN_SUCCESS.a(), faVar.mo412a(), faVar.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        this.a = 0;
        this.f453a = null;
        this.f451a = faVar;
        this.f454a = au.m145a((Context) this.f452a);
        ep.a(0, ei.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        long uidTxBytes;
        if (this.a == 0 && this.f453a == null) {
            this.a = i2;
            this.f453a = exc;
            ep.b(faVar.mo412a(), exc);
        }
        if (i2 == 22 && this.f8951c != 0) {
            long jM410a = faVar.m410a() - this.f8951c;
            if (jM410a < 0) {
                jM410a = 0;
            }
            this.f8952d += jM410a + ((long) (fg.b() / 2));
            this.f8951c = 0L;
        }
        m379a();
        int iMyUid = Process.myUid();
        long uidRxBytes = -1;
        try {
            uidRxBytes = TrafficStats.getUidRxBytes(iMyUid);
            uidTxBytes = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Failed to obtain traffic data: " + e2);
            uidTxBytes = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f8954f) + ", tx=" + (uidTxBytes - this.f8953e));
        this.f8954f = uidRxBytes;
        this.f8953e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        ep.a(0, ei.CHANNEL_CON_FAIL.a(), 1, faVar.mo412a(), au.b(this.f452a) ? 1 : 0);
        m379a();
    }
}
