package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.AbstractC4207fa;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.service.AbstractC4382e;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.C4366ar;
import com.xiaomi.push.service.C4371aw;
import com.xiaomi.push.service.C4372ax;
import com.xiaomi.push.service.XMPushService;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.ey */
/* loaded from: classes2.dex */
public class C4204ey extends AbstractC4214fh {

    /* renamed from: a */
    private C4199et f15241a;

    /* renamed from: a */
    private C4200eu f15242a;

    /* renamed from: a */
    private Thread f15243a;

    /* renamed from: a */
    private byte[] f15244a;

    public C4204ey(XMPushService xMPushService, C4208fb c4208fb) {
        super(xMPushService, c4208fb);
    }

    /* renamed from: h */
    private void m14737h() {
        try {
            this.f15241a = new C4199et(((AbstractC4214fh) this).f15297a.getInputStream(), this);
            this.f15242a = new C4200eu(((AbstractC4214fh) this).f15297a.getOutputStream(), this);
            this.f15243a = new Thread("Blob Reader (" + ((AbstractC4207fa) this).f15272b + ")") { // from class: com.xiaomi.push.ey.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        C4204ey.this.f15241a.m14717a();
                    } catch (Exception e2) {
                        C4204ey.this.m14810c(9, e2);
                    }
                }
            };
            this.f15243a.start();
        } catch (Exception e2) {
            throw new C4215fi("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public boolean mo14746a() {
        return true;
    }

    /* renamed from: b */
    void m14749b(AbstractC4221fo abstractC4221fo) {
        if (abstractC4221fo == null) {
            return;
        }
        Iterator<AbstractC4207fa.a> it = ((AbstractC4207fa) this).f15271a.values().iterator();
        while (it.hasNext()) {
            it.next().m14783a(abstractC4221fo);
        }
    }

    /* renamed from: a */
    synchronized byte[] m14747a() {
        if (this.f15244a == null && !TextUtils.isEmpty(((AbstractC4207fa) this).f15268a)) {
            String m16018a = C4372ax.m16018a();
            this.f15244a = C4366ar.m15996a(((AbstractC4207fa) this).f15268a.getBytes(), (((AbstractC4207fa) this).f15268a.substring(((AbstractC4207fa) this).f15268a.length() / 2) + m16018a.substring(m16018a.length() / 2)).getBytes());
        }
        return this.f15244a;
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: b */
    public void mo14748b(C4197er c4197er) {
        C4200eu c4200eu = this.f15242a;
        if (c4200eu != null) {
            try {
                int m14719a = c4200eu.m14719a(c4197er);
                ((AbstractC4207fa) this).f15278d = SystemClock.elapsedRealtime();
                String m14710f = c4197er.m14710f();
                if (!TextUtils.isEmpty(m14710f)) {
                    C4232fz.m14917a(((AbstractC4207fa) this).f15267a, m14710f, m14719a, false, true, System.currentTimeMillis());
                }
                Iterator<AbstractC4207fa.a> it = ((AbstractC4207fa) this).f15275b.values().iterator();
                while (it.hasNext()) {
                    it.next().m14782a(c4197er);
                }
                return;
            } catch (Exception e2) {
                throw new C4215fi(e2);
            }
        }
        throw new C4215fi("the writer is null.");
    }

    /* renamed from: a */
    private C4197er m14735a(boolean z) {
        C4203ex c4203ex = new C4203ex();
        if (z) {
            c4203ex.m14691a("1");
        }
        byte[] m14675a = C4195ep.m14675a();
        if (m14675a != null) {
            C4168dp.j jVar = new C4168dp.j();
            jVar.m14490a(C4071a.m13687a(m14675a));
            c4203ex.m14694a(jVar.m14590a(), (String) null);
        }
        return c4203ex;
    }

    @Override // com.xiaomi.push.AbstractC4214fh
    /* renamed from: a */
    protected void mo14744a(boolean z) {
        if (this.f15242a != null) {
            C4197er m14735a = m14735a(z);
            AbstractC4022b.m13347a("[Slim] SND ping id=" + m14735a.m14709e());
            mo14748b(m14735a);
            m14812f();
            return;
        }
        throw new C4215fi("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public synchronized void mo14742a(C4361am.b bVar) {
        C4196eq.m14678a(bVar, m14809c(), this);
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public synchronized void mo14743a(String str, String str2) {
        C4196eq.m14679a(str, str2, this);
    }

    @Override // com.xiaomi.push.AbstractC4214fh
    /* renamed from: a */
    protected synchronized void mo14739a(int i2, Exception exc) {
        if (this.f15241a != null) {
            this.f15241a.m14718b();
            this.f15241a = null;
        }
        if (this.f15242a != null) {
            try {
                this.f15242a.m14721b();
            } catch (Exception e2) {
                AbstractC4022b.m13361d("SlimConnection shutdown cause exception: " + e2);
            }
            this.f15242a = null;
        }
        this.f15244a = null;
        super.mo14739a(i2, exc);
    }

    @Override // com.xiaomi.push.AbstractC4214fh, com.xiaomi.push.AbstractC4207fa
    /* renamed from: a */
    public void mo14745a(C4197er[] c4197erArr) {
        for (C4197er c4197er : c4197erArr) {
            mo14748b(c4197er);
        }
    }

    @Override // com.xiaomi.push.AbstractC4207fa
    @Deprecated
    /* renamed from: a */
    public void mo14741a(AbstractC4221fo abstractC4221fo) {
        mo14748b(C4197er.m14680a(abstractC4221fo, (String) null));
    }

    @Override // com.xiaomi.push.AbstractC4214fh
    /* renamed from: a */
    protected synchronized void mo14738a() {
        m14737h();
        this.f15242a.m14720a();
    }

    /* renamed from: a */
    void m14740a(C4197er c4197er) {
        if (c4197er == null) {
            return;
        }
        if (AbstractC4382e.m16077a(c4197er)) {
            C4197er c4197er2 = new C4197er();
            c4197er2.m14688a(c4197er.m14683a());
            c4197er2.m14692a("SYNC", "ACK_RTT");
            c4197er2.m14691a(c4197er.m14709e());
            c4197er2.m14701b(c4197er.m14699b());
            c4197er2.m14689a(c4197er.m14705c());
            XMPushService xMPushService = ((AbstractC4207fa) this).f15267a;
            xMPushService.m15797a(new C4371aw(xMPushService, c4197er2));
        }
        if (c4197er.m14695a()) {
            AbstractC4022b.m13347a("[Slim] RCV blob chid=" + c4197er.m14683a() + "; id=" + c4197er.m14709e() + "; errCode=" + c4197er.m14698b() + "; err=" + c4197er.m14706c());
        }
        if (c4197er.m14683a() == 0) {
            if ("PING".equals(c4197er.m14685a())) {
                AbstractC4022b.m13347a("[Slim] RCV ping id=" + c4197er.m14709e());
                m14813g();
            } else if ("CLOSE".equals(c4197er.m14685a())) {
                m14810c(13, null);
            }
        }
        Iterator<AbstractC4207fa.a> it = ((AbstractC4207fa) this).f15271a.values().iterator();
        while (it.hasNext()) {
            it.next().m14782a(c4197er);
        }
    }
}
