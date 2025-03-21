package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.en */
/* loaded from: classes2.dex */
public class C4193en implements InterfaceC4210fd {

    /* renamed from: a */
    private int f15185a;

    /* renamed from: a */
    AbstractC4207fa f15187a;

    /* renamed from: a */
    XMPushService f15188a;

    /* renamed from: a */
    private Exception f15189a;

    /* renamed from: e */
    private long f15194e;

    /* renamed from: f */
    private long f15195f;

    /* renamed from: a */
    private long f15186a = 0;

    /* renamed from: b */
    private long f15191b = 0;

    /* renamed from: c */
    private long f15192c = 0;

    /* renamed from: d */
    private long f15193d = 0;

    /* renamed from: a */
    private String f15190a = "";

    C4193en(XMPushService xMPushService) {
        this.f15194e = 0L;
        this.f15195f = 0L;
        this.f15188a = xMPushService;
        m14650b();
        int myUid = Process.myUid();
        try {
            this.f15195f = TrafficStats.getUidRxBytes(myUid);
            this.f15194e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("Failed to obtain traffic data during initialization: " + e2);
            this.f15195f = -1L;
            this.f15194e = -1L;
        }
    }

    /* renamed from: b */
    private void m14650b() {
        this.f15191b = 0L;
        this.f15193d = 0L;
        this.f15186a = 0L;
        this.f15192c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C4092au.m13799a((Context) this.f15188a)) {
            this.f15186a = elapsedRealtime;
        }
        if (this.f15188a.m15812c()) {
            this.f15192c = elapsedRealtime;
        }
    }

    /* renamed from: c */
    private synchronized void m14651c() {
        AbstractC4022b.m13359c("stat connpt = " + this.f15190a + " netDuration = " + this.f15191b + " ChannelDuration = " + this.f15193d + " channelConnectedTime = " + this.f15192c);
        C4189ej c4189ej = new C4189ej();
        c4189ej.f15157a = (byte) 0;
        c4189ej.m14603a(EnumC4188ei.CHANNEL_ONLINE_RATE.m14600a());
        c4189ej.m14604a(this.f15190a);
        c4189ej.m14619d((int) (System.currentTimeMillis() / 1000));
        c4189ej.m14610b((int) (this.f15191b / 1000));
        c4189ej.m14615c((int) (this.f15193d / 1000));
        C4194eo.m14657a().m14662a(c4189ej);
        m14650b();
    }

    /* renamed from: a */
    Exception m14652a() {
        return this.f15189a;
    }

    /* renamed from: a */
    public synchronized void m14653a() {
        if (this.f15188a == null) {
            return;
        }
        String m13789a = C4092au.m13789a((Context) this.f15188a);
        boolean m13801b = C4092au.m13801b(this.f15188a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f15186a > 0) {
            this.f15191b += elapsedRealtime - this.f15186a;
            this.f15186a = 0L;
        }
        if (this.f15192c != 0) {
            this.f15193d += elapsedRealtime - this.f15192c;
            this.f15192c = 0L;
        }
        if (m13801b) {
            if ((!TextUtils.equals(this.f15190a, m13789a) && this.f15191b > 30000) || this.f15191b > 5400000) {
                m14651c();
            }
            this.f15190a = m13789a;
            if (this.f15186a == 0) {
                this.f15186a = elapsedRealtime;
            }
            if (this.f15188a.m15812c()) {
                this.f15192c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: b */
    public void mo14176b(AbstractC4207fa abstractC4207fa) {
        m14653a();
        this.f15192c = SystemClock.elapsedRealtime();
        C4195ep.m14671a(0, EnumC4188ei.CONN_SUCCESS.m14600a(), abstractC4207fa.mo14762a(), abstractC4207fa.m14759a());
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14173a(AbstractC4207fa abstractC4207fa) {
        this.f15185a = 0;
        this.f15189a = null;
        this.f15187a = abstractC4207fa;
        this.f15190a = C4092au.m13789a((Context) this.f15188a);
        C4195ep.m14669a(0, EnumC4188ei.CONN_SUCCESS.m14600a());
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14174a(AbstractC4207fa abstractC4207fa, int i2, Exception exc) {
        long j2;
        if (this.f15185a == 0 && this.f15189a == null) {
            this.f15185a = i2;
            this.f15189a = exc;
            C4195ep.m14677b(abstractC4207fa.mo14762a(), exc);
        }
        if (i2 == 22 && this.f15192c != 0) {
            long m14760a = abstractC4207fa.m14760a() - this.f15192c;
            if (m14760a < 0) {
                m14760a = 0;
            }
            this.f15193d += m14760a + (C4213fg.m14801b() / 2);
            this.f15192c = 0L;
        }
        m14653a();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            j3 = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            AbstractC4022b.m13347a("Failed to obtain traffic data: " + e2);
            j2 = -1L;
        }
        AbstractC4022b.m13359c("Stats rx=" + (j3 - this.f15195f) + ", tx=" + (j2 - this.f15194e));
        this.f15195f = j3;
        this.f15194e = j2;
    }

    @Override // com.xiaomi.push.InterfaceC4210fd
    /* renamed from: a */
    public void mo14175a(AbstractC4207fa abstractC4207fa, Exception exc) {
        C4195ep.m14670a(0, EnumC4188ei.CHANNEL_CON_FAIL.m14600a(), 1, abstractC4207fa.mo14762a(), C4092au.m13801b(this.f15188a) ? 1 : 0);
        m14653a();
    }
}
