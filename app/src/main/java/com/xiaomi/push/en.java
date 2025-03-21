package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
public class en implements fd {

    /* renamed from: a, reason: collision with root package name */
    private int f12773a;

    /* renamed from: a, reason: collision with other field name */
    fa f451a;

    /* renamed from: a, reason: collision with other field name */
    XMPushService f452a;

    /* renamed from: a, reason: collision with other field name */
    private Exception f453a;

    /* renamed from: e, reason: collision with root package name */
    private long f12777e;

    /* renamed from: f, reason: collision with root package name */
    private long f12778f;

    /* renamed from: a, reason: collision with other field name */
    private long f450a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f12774b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f12775c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f12776d = 0;

    /* renamed from: a, reason: collision with other field name */
    private String f454a = "";

    en(XMPushService xMPushService) {
        this.f12777e = 0L;
        this.f12778f = 0L;
        this.f452a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f12778f = TrafficStats.getUidRxBytes(myUid);
            this.f12777e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Failed to obtain traffic data during initialization: " + e2);
            this.f12778f = -1L;
            this.f12777e = -1L;
        }
    }

    private void b() {
        this.f12774b = 0L;
        this.f12776d = 0L;
        this.f450a = 0L;
        this.f12775c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (au.m151a((Context) this.f452a)) {
            this.f450a = elapsedRealtime;
        }
        if (this.f452a.m668c()) {
            this.f12775c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f454a + " netDuration = " + this.f12774b + " ChannelDuration = " + this.f12776d + " channelConnectedTime = " + this.f12775c);
        ej ejVar = new ej();
        ejVar.f429a = (byte) 0;
        ejVar.a(ei.CHANNEL_ONLINE_RATE.a());
        ejVar.a(this.f454a);
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        ejVar.b((int) (this.f12774b / 1000));
        ejVar.c((int) (this.f12776d / 1000));
        eo.m382a().a(ejVar);
        b();
    }

    Exception a() {
        return this.f453a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m381a() {
        if (this.f452a == null) {
            return;
        }
        String m147a = au.m147a((Context) this.f452a);
        boolean b2 = au.b(this.f452a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f450a > 0) {
            this.f12774b += elapsedRealtime - this.f450a;
            this.f450a = 0L;
        }
        if (this.f12775c != 0) {
            this.f12776d += elapsedRealtime - this.f12775c;
            this.f12775c = 0L;
        }
        if (b2) {
            if ((!TextUtils.equals(this.f454a, m147a) && this.f12774b > 30000) || this.f12774b > 5400000) {
                c();
            }
            this.f454a = m147a;
            if (this.f450a == 0) {
                this.f450a = elapsedRealtime;
            }
            if (this.f452a.m668c()) {
                this.f12775c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        m381a();
        this.f12775c = SystemClock.elapsedRealtime();
        ep.a(0, ei.CONN_SUCCESS.a(), faVar.mo414a(), faVar.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        this.f12773a = 0;
        this.f453a = null;
        this.f451a = faVar;
        this.f454a = au.m147a((Context) this.f452a);
        ep.a(0, ei.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        long j2;
        if (this.f12773a == 0 && this.f453a == null) {
            this.f12773a = i2;
            this.f453a = exc;
            ep.b(faVar.mo414a(), exc);
        }
        if (i2 == 22 && this.f12775c != 0) {
            long m412a = faVar.m412a() - this.f12775c;
            if (m412a < 0) {
                m412a = 0;
            }
            this.f12776d += m412a + (fg.b() / 2);
            this.f12775c = 0L;
        }
        m381a();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            j3 = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Failed to obtain traffic data: " + e2);
            j2 = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j3 - this.f12778f) + ", tx=" + (j2 - this.f12777e));
        this.f12778f = j3;
        this.f12777e = j2;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        ep.a(0, ei.CHANNEL_CON_FAIL.a(), 1, faVar.mo414a(), au.b(this.f452a) ? 1 : 0);
        m381a();
    }
}
