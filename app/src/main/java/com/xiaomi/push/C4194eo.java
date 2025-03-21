package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4095ax;
import com.xiaomi.push.C4168dp;
import com.xiaomi.push.C4294ig;
import com.xiaomi.push.service.C4372ax;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* renamed from: com.xiaomi.push.eo */
/* loaded from: classes2.dex */
public class C4194eo {

    /* renamed from: a */
    private int f15196a;

    /* renamed from: a */
    private long f15197a;

    /* renamed from: a */
    private C4193en f15199a;

    /* renamed from: a */
    private String f15200a;

    /* renamed from: a */
    private boolean f15201a = false;

    /* renamed from: a */
    private C4095ax f15198a = C4095ax.m13833a();

    /* renamed from: com.xiaomi.push.eo$a */
    static class a {

        /* renamed from: a */
        static final C4194eo f15203a = new C4194eo();
    }

    /* renamed from: a */
    public static C4194eo m14657a() {
        return a.f15203a;
    }

    /* renamed from: b */
    boolean m14665b() {
        m14658a();
        return this.f15201a && this.f15198a.m13835a() > 0;
    }

    /* renamed from: a */
    public static C4193en m14656a() {
        C4193en c4193en;
        synchronized (a.f15203a) {
            c4193en = a.f15203a.f15199a;
        }
        return c4193en;
    }

    /* renamed from: a */
    public synchronized void m14663a(XMPushService xMPushService) {
        this.f15199a = new C4193en(xMPushService);
        this.f15200a = "";
        C4372ax.m16017a().m16029a(new C4372ax.a() { // from class: com.xiaomi.push.eo.1
            @Override // com.xiaomi.push.service.C4372ax.a
            /* renamed from: a */
            public void mo14666a(C4168dp.b bVar) {
                if (bVar.m14385e()) {
                    C4194eo.m14657a().m14661a(bVar.m14384e());
                }
            }
        });
    }

    /* renamed from: a */
    public boolean m14664a() {
        return this.f15201a;
    }

    /* renamed from: a */
    public void m14661a(int i2) {
        if (i2 > 0) {
            int i3 = i2 * 1000;
            if (i3 > 604800000) {
                i3 = 604800000;
            }
            if (this.f15196a == i3 && this.f15201a) {
                return;
            }
            this.f15201a = true;
            this.f15197a = System.currentTimeMillis();
            this.f15196a = i3;
            AbstractC4022b.m13359c("enable dot duration = " + i3 + " start = " + this.f15197a);
        }
    }

    /* renamed from: a */
    private void m14658a() {
        if (!this.f15201a || System.currentTimeMillis() - this.f15197a <= this.f15196a) {
            return;
        }
        this.f15201a = false;
        this.f15197a = 0L;
    }

    /* renamed from: a */
    synchronized C4190ek m14660a() {
        C4190ek c4190ek;
        c4190ek = null;
        if (m14665b()) {
            c4190ek = m14655a(C4092au.m13803d(this.f15199a.f15188a) ? 750 : 375);
        }
        return c4190ek;
    }

    /* renamed from: a */
    private C4190ek m14655a(int i2) {
        ArrayList arrayList = new ArrayList();
        C4190ek c4190ek = new C4190ek(this.f15200a, arrayList);
        if (!C4092au.m13803d(this.f15199a.f15188a)) {
            c4190ek.m14632a(C4287i.m15655i(this.f15199a.f15188a));
        }
        C4296ii c4296ii = new C4296ii(i2);
        AbstractC4288ia mo15627a = new C4294ig.a().mo15627a(c4296ii);
        try {
            c4190ek.mo14612b(mo15627a);
        } catch (C4281hu unused) {
        }
        LinkedList<C4095ax.a> m13836a = this.f15198a.m13836a();
        while (m13836a.size() > 0) {
            try {
                C4189ej m14654a = m14654a(m13836a.getLast());
                if (m14654a != null) {
                    m14654a.mo14612b(mo15627a);
                }
                if (c4296ii.m15664a() > i2) {
                    break;
                }
                if (m14654a != null) {
                    arrayList.add(m14654a);
                }
                m13836a.removeLast();
            } catch (C4281hu | NoSuchElementException unused2) {
            }
        }
        return c4190ek;
    }

    /* renamed from: a */
    synchronized C4189ej m14659a() {
        C4189ej c4189ej;
        c4189ej = new C4189ej();
        c4189ej.m14604a(C4092au.m13789a((Context) this.f15199a.f15188a));
        c4189ej.f15157a = (byte) 0;
        c4189ej.f15161b = 1;
        c4189ej.m14619d((int) (System.currentTimeMillis() / 1000));
        return c4189ej;
    }

    /* renamed from: a */
    private C4189ej m14654a(C4095ax.a aVar) {
        if (aVar.f14587a == 0) {
            Object obj = aVar.f14588a;
            if (obj instanceof C4189ej) {
                return (C4189ej) obj;
            }
            return null;
        }
        C4189ej m14659a = m14659a();
        m14659a.m14603a(EnumC4188ei.CHANNEL_STATS_COUNTER.m14600a());
        m14659a.m14615c(aVar.f14587a);
        m14659a.m14616c(aVar.f14589a);
        return m14659a;
    }

    /* renamed from: a */
    synchronized void m14662a(C4189ej c4189ej) {
        this.f15198a.m13837a(c4189ej);
    }
}
