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

/* JADX INFO: loaded from: classes2.dex */
public class eo {
    private int a;

    /* JADX INFO: renamed from: a */
    private long f455a;

    /* JADX INFO: renamed from: a */
    private en f457a;

    /* JADX INFO: renamed from: a */
    private String f458a;

    /* JADX INFO: renamed from: a */
    private boolean f459a = false;

    /* JADX INFO: renamed from: a */
    private ax f456a = ax.a();

    /* JADX INFO: renamed from: com.xiaomi.push.eo$1 */
    class AnonymousClass1 extends ax.a {
        AnonymousClass1() {
        }

        @Override // com.xiaomi.push.service.ax.a
        public void a(dp.b bVar) {
            if (bVar.m299e()) {
                eo.m380a().m384a(bVar.e());
            }
        }
    }

    static class a {
        static final eo a = new eo();
    }

    /* JADX INFO: renamed from: a */
    public static eo m380a() {
        return a.a;
    }

    boolean b() {
        m381a();
        return this.f459a && this.f456a.m157a() > 0;
    }

    public static en a() {
        en enVar;
        synchronized (a.a) {
            enVar = a.a.f457a;
        }
        return enVar;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f457a = new en(xMPushService);
        this.f458a = "";
        com.xiaomi.push.service.ax.a().a(new ax.a() { // from class: com.xiaomi.push.eo.1
            AnonymousClass1() {
            }

            @Override // com.xiaomi.push.service.ax.a
            public void a(dp.b bVar) {
                if (bVar.m299e()) {
                    eo.m380a().m384a(bVar.e());
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public boolean m385a() {
        return this.f459a;
    }

    /* JADX INFO: renamed from: a */
    public void m384a(int i2) {
        if (i2 > 0) {
            int i3 = i2 * 1000;
            if (i3 > 604800000) {
                i3 = 604800000;
            }
            if (this.a == i3 && this.f459a) {
                return;
            }
            this.f459a = true;
            this.f455a = System.currentTimeMillis();
            this.a = i3;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.f455a);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m381a() {
        if (!this.f459a || System.currentTimeMillis() - this.f455a <= this.a) {
            return;
        }
        this.f459a = false;
        this.f455a = 0L;
    }

    /* JADX INFO: renamed from: a */
    synchronized ek m383a() {
        ek ekVarA;
        ekVarA = null;
        if (b()) {
            ekVarA = a(au.d(this.f457a.f452a) ? 750 : 375);
        }
        return ekVarA;
    }

    private ek a(int i2) {
        ArrayList arrayList = new ArrayList();
        ek ekVar = new ek(this.f458a, arrayList);
        if (!au.d(this.f457a.f452a)) {
            ekVar.a(i.i(this.f457a.f452a));
        }
        ii iiVar = new ii(i2);
        ia iaVarA = new ig.a().a(iiVar);
        try {
            ekVar.b(iaVarA);
        } catch (hu unused) {
        }
        LinkedList<ax.a> linkedListM158a = this.f456a.m158a();
        while (linkedListM158a.size() > 0) {
            try {
                ej ejVarA = a(linkedListM158a.getLast());
                if (ejVarA != null) {
                    ejVarA.b(iaVarA);
                }
                if (iiVar.a() > i2) {
                    break;
                }
                if (ejVarA != null) {
                    arrayList.add(ejVarA);
                }
                linkedListM158a.removeLast();
            } catch (hu | NoSuchElementException unused2) {
            }
        }
        return ekVar;
    }

    /* JADX INFO: renamed from: a */
    synchronized ej m382a() {
        ej ejVar;
        ejVar = new ej();
        ejVar.a(au.m145a((Context) this.f457a.f452a));
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
        ej ejVarM382a = m382a();
        ejVarM382a.a(ei.CHANNEL_STATS_COUNTER.a());
        ejVarM382a.c(aVar.f201a);
        ejVarM382a.c(aVar.f203a);
        return ejVarM382a;
    }

    synchronized void a(ej ejVar) {
        this.f456a.a(ejVar);
    }
}
