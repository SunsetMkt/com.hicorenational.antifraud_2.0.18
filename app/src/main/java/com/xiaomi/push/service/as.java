package com.xiaomi.push.service;

import com.xiaomi.push.eo;
import com.xiaomi.push.service.XMPushService.e;

/* JADX INFO: loaded from: classes2.dex */
class as {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9387d = 300000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private XMPushService f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9388b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9389c = 0;
    private int a = 500;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f1011a = 0;

    public as(XMPushService xMPushService) {
        this.f1012a = xMPushService;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m701a() {
        this.f1011a = System.currentTimeMillis();
        this.f1012a.a(1);
        this.f9388b = 0;
    }

    public void a(boolean z) {
        if (!this.f1012a.m661a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f1012a.m662a(1)) {
                this.f9388b++;
            }
            this.f1012a.a(1);
            com.xiaomi.channel.commonutils.logger.b.m49a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f1012a;
            xMPushService.getClass();
            xMPushService.a(xMPushService.new e());
            return;
        }
        if (this.f1012a.m662a(1)) {
            return;
        }
        int iA = a();
        this.f9388b++;
        com.xiaomi.channel.commonutils.logger.b.m48a("schedule reconnect in " + iA + "ms");
        XMPushService xMPushService2 = this.f1012a;
        xMPushService2.getClass();
        xMPushService2.a(xMPushService2.new e(), (long) iA);
        if (this.f9388b == 2 && eo.m380a().m385a()) {
            z.b();
        }
        if (this.f9388b == 3) {
            z.a();
        }
    }

    private int a() {
        if (this.f9388b > 8) {
            return 300000;
        }
        double dRandom = (Math.random() * 2.0d) + 1.0d;
        int i2 = this.f9388b;
        if (i2 > 4) {
            return (int) (dRandom * 60000.0d);
        }
        if (i2 > 1) {
            return (int) (dRandom * 10000.0d);
        }
        if (this.f1011a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f1011a < 310000) {
            int i3 = this.a;
            int i4 = f9387d;
            if (i3 >= i4) {
                return i3;
            }
            this.f9389c++;
            if (this.f9389c >= 4) {
                return i4;
            }
            this.a = (int) (((double) i3) * 1.5d);
            return i3;
        }
        this.a = 1000;
        this.f9389c = 0;
        return 0;
    }
}
