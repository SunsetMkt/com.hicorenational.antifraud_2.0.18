package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4390m;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* renamed from: com.xiaomi.push.fh */
/* loaded from: classes2.dex */
public abstract class AbstractC4214fh extends AbstractC4207fa {

    /* renamed from: a */
    protected Exception f15296a;

    /* renamed from: a */
    protected Socket f15297a;

    /* renamed from: b */
    protected XMPushService f15298b;

    /* renamed from: c */
    private int f15299c;

    /* renamed from: c */
    String f15300c;

    /* renamed from: d */
    private String f15301d;

    /* renamed from: e */
    protected volatile long f15302e;

    /* renamed from: f */
    protected volatile long f15303f;

    /* renamed from: g */
    protected volatile long f15304g;

    /* renamed from: h */
    private long f15305h;

    public AbstractC4214fh(XMPushService xMPushService, C4208fb c4208fb) {
        super(xMPushService, c4208fb);
        this.f15296a = null;
        this.f15300c = null;
        this.f15302e = 0L;
        this.f15303f = 0L;
        this.f15304g = 0L;
        this.f15305h = 0L;
        this.f15298b = xMPushService;
    }

    /* renamed from: a */
    public Context m14804a() {
        return this.f15298b;
    }

    /* renamed from: a */
    protected abstract void mo14744a(boolean z);

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: b */
    public void mo14777b(boolean z) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        mo14744a(z);
        C4390m.m16121a(this.f15298b).m16147c();
        if (z) {
            return;
        }
        this.f15298b.m15798a(new XMPushService.AbstractC4337j(13) { // from class: com.xiaomi.push.fh.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                Thread.yield();
                if (!AbstractC4214fh.this.m14780c() || AbstractC4214fh.this.m14769a(elapsedRealtime)) {
                    return;
                }
                C4390m.m16121a(AbstractC4214fh.this.f15298b).m16146b();
                AbstractC4214fh.this.f15298b.m15795a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "check the ping-pong." + currentTimeMillis;
            }
        }, C2084a.f6135q);
    }

    /* renamed from: c */
    public String m14809c() {
        return ((AbstractC4207fa) this).f15268a;
    }

    /* renamed from: e */
    public synchronized void m14811e() {
        try {
            if (!m14780c() && !m14778b()) {
                m14764a(0, 0, (Exception) null);
                m14802a(((AbstractC4207fa) this).f15265a);
                return;
            }
            AbstractC4022b.m13347a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new C4215fi(e2);
        }
    }

    /* renamed from: f */
    public void m14812f() {
        this.f15302e = SystemClock.elapsedRealtime();
    }

    /* renamed from: g */
    public void m14813g() {
        this.f15303f = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public String mo14762a() {
        return this.f15301d;
    }

    /* renamed from: c */
    public void m14810c(final int i2, final Exception exc) {
        C4092au.m13800b();
        this.f15298b.m15797a(new XMPushService.AbstractC4337j(2) { // from class: com.xiaomi.push.fh.2
            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public void mo14644a() {
                AbstractC4214fh.this.f15298b.m15795a(i2, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
            /* renamed from: a */
            public String mo14643a() {
                return "shutdown the connection. " + i2 + ", " + exc;
            }
        });
    }

    /* renamed from: a */
    protected synchronized void mo14739a(int i2, Exception exc) {
        if (m14770b() == 2) {
            return;
        }
        m14764a(2, i2, exc);
        ((AbstractC4207fa) this).f15268a = "";
        try {
            this.f15297a.close();
        } catch (Throwable unused) {
        }
        this.f15302e = 0L;
        this.f15303f = 0L;
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: b */
    public void mo14773b(int i2, Exception exc) {
        mo14739a(i2, exc);
        if ((exc != null || i2 == 18) && this.f15304g != 0) {
            m14807a(exc);
        }
    }

    /* renamed from: a */
    protected void m14807a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f15304g < 300000) {
            if (C4092au.m13799a((Context) this.f15298b)) {
                this.f15299c++;
                if (this.f15299c >= 2) {
                    String mo14762a = mo14762a();
                    AbstractC4022b.m13347a("max short conn time reached, sink down current host:" + mo14762a);
                    m14808a(mo14762a, 0L, exc);
                    this.f15299c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.f15299c = 0;
    }

    /* renamed from: a */
    protected void m14808a(String str, long j2, Exception exc) {
        C4128cc m14077a = C4132cg.m14066a().m14077a(C4208fb.m14784a(), false);
        if (m14077a != null) {
            m14077a.m14051b(str, j2, 0L, exc);
            C4132cg.m14066a().m14090c();
        }
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public void mo14745a(C4197er[] c4197erArr) {
        throw new C4215fi("Don't support send Blob");
    }

    /* renamed from: a */
    private void m14802a(C4208fb c4208fb) {
        m14803a(c4208fb.m14793c(), c4208fb.m14787a());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02ad  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m14803a(java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.AbstractC4214fh.m14803a(java.lang.String, int):void");
    }

    /* renamed from: a */
    protected synchronized void mo14738a() {
    }

    /* renamed from: a */
    public Socket m14806a() {
        return new Socket();
    }

    /* renamed from: a */
    C4128cc m14805a(final String str) {
        C4128cc m14077a = C4132cg.m14066a().m14077a(str, false);
        if (!m14077a.mo14052b()) {
            C4231fy.m14907a(new Runnable() { // from class: com.xiaomi.push.fh.3
                @Override // java.lang.Runnable
                public void run() {
                    C4132cg.m14066a().m14077a(str, true);
                }
            });
        }
        return m14077a;
    }
}
