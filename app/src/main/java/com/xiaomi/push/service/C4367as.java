package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4194eo;
import com.xiaomi.push.service.XMPushService.C4332e;

/* renamed from: com.xiaomi.push.service.as */
/* loaded from: classes2.dex */
class C4367as {

    /* renamed from: d */
    private static int f16637d = 300000;

    /* renamed from: a */
    private XMPushService f16640a;

    /* renamed from: b */
    private int f16641b = 0;

    /* renamed from: c */
    private int f16642c = 0;

    /* renamed from: a */
    private int f16638a = 500;

    /* renamed from: a */
    private long f16639a = 0;

    public C4367as(XMPushService xMPushService) {
        this.f16640a = xMPushService;
    }

    /* renamed from: a */
    public void m16000a() {
        this.f16639a = System.currentTimeMillis();
        this.f16640a.m15794a(1);
        this.f16641b = 0;
    }

    /* renamed from: a */
    public void m16001a(boolean z) {
        if (!this.f16640a.m15806a()) {
            AbstractC4022b.m13359c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f16640a.m15807a(1)) {
                this.f16641b++;
            }
            this.f16640a.m15794a(1);
            AbstractC4022b.m13348a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f16640a;
            xMPushService.getClass();
            xMPushService.m15797a(xMPushService.new C4332e());
            return;
        }
        if (this.f16640a.m15807a(1)) {
            return;
        }
        int m15999a = m15999a();
        this.f16641b++;
        AbstractC4022b.m13347a("schedule reconnect in " + m15999a + "ms");
        XMPushService xMPushService2 = this.f16640a;
        xMPushService2.getClass();
        xMPushService2.m15798a(xMPushService2.new C4332e(), (long) m15999a);
        if (this.f16641b == 2 && C4194eo.m14657a().m14664a()) {
            C4404z.m16347b();
        }
        if (this.f16641b == 3) {
            C4404z.m16344a();
        }
    }

    /* renamed from: a */
    private int m15999a() {
        if (this.f16641b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i2 = this.f16641b;
        if (i2 > 4) {
            return (int) (random * 60000.0d);
        }
        if (i2 > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f16639a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f16639a < 310000) {
            int i3 = this.f16638a;
            int i4 = f16637d;
            if (i3 >= i4) {
                return i3;
            }
            this.f16642c++;
            if (this.f16642c >= 4) {
                return i4;
            }
            this.f16638a = (int) (i3 * 1.5d);
            return i3;
        }
        this.f16638a = 1000;
        this.f16642c = 0;
        return 0;
    }
}
