package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ax;
import com.xiaomi.push.dp;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class eo {

    /* renamed from: a, reason: collision with root package name */
    private int f12779a;

    /* renamed from: a, reason: collision with other field name */
    private long f455a;

    /* renamed from: a, reason: collision with other field name */
    private en f457a;

    /* renamed from: a, reason: collision with other field name */
    private String f458a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f459a = false;

    /* renamed from: a, reason: collision with other field name */
    private ax f456a = ax.a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        static final eo f12781a = new eo();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static eo m382a() {
        return a.f12781a;
    }

    boolean b() {
        m383a();
        return this.f459a && this.f456a.m159a() > 0;
    }

    public static en a() {
        en enVar;
        synchronized (a.f12781a) {
            enVar = a.f12781a.f457a;
        }
        return enVar;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f457a = new en(xMPushService);
        this.f458a = "";
        com.xiaomi.push.service.ax.a().a(new ax.a() { // from class: com.xiaomi.push.eo.1
            @Override // com.xiaomi.push.service.ax.a
            public void a(dp.b bVar) {
                if (bVar.m301e()) {
                    eo.m382a().m386a(bVar.e());
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m387a() {
        return this.f459a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m386a(int i2) {
        if (i2 > 0) {
            int i3 = i2 * 1000;
            if (i3 > 604800000) {
                i3 = 604800000;
            }
            if (this.f12779a == i3 && this.f459a) {
                return;
            }
            this.f459a = true;
            this.f455a = System.currentTimeMillis();
            this.f12779a = i3;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.f455a);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m383a() {
        if (!this.f459a || System.currentTimeMillis() - this.f455a <= this.f12779a) {
            return;
        }
        this.f459a = false;
        this.f455a = 0L;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized ek m385a() {
        ek ekVar;
        ekVar = null;
        if (b()) {
            ekVar = a(au.d(this.f457a.f452a) ? 750 : 375);
        }
        return ekVar;
    }

    private ek a(int i2) {
        ArrayList arrayList = new ArrayList();
        ek ekVar = new ek(this.f458a, arrayList);
        if (!au.d(this.f457a.f452a)) {
            ekVar.a(i.i(this.f457a.f452a));
        }
        ii iiVar = new ii(i2);
        ia a2 = new ig.a().a(iiVar);
        try {
            ekVar.b(a2);
        } catch (hu unused) {
        }
        LinkedList<ax.a> m160a = this.f456a.m160a();
        while (m160a.size() > 0) {
            try {
                ej a3 = a(m160a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (iiVar.a() > i2) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m160a.removeLast();
            } catch (hu | NoSuchElementException unused2) {
            }
        }
        return ekVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized ej m384a() {
        ej ejVar;
        ejVar = new ej();
        ejVar.a(au.m147a((Context) this.f457a.f452a));
        ejVar.f429a = (byte) 0;
        ejVar.f433b = 1;
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        return ejVar;
    }

    private ej a(ax.a aVar) {
        if (aVar.f201a == 0) {
            Object obj = aVar.f202a;
            if (obj instanceof ej) {
                return (ej) obj;
            }
            return null;
        }
        ej m384a = m384a();
        m384a.a(ei.CHANNEL_STATS_COUNTER.a());
        m384a.c(aVar.f201a);
        m384a.c(aVar.f203a);
        return m384a;
    }

    synchronized void a(ej ejVar) {
        this.f456a.a(ejVar);
    }
}
