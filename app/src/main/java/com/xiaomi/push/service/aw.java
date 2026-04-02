package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes2.dex */
public class aw extends XMPushService.j {
    private er a;

    /* JADX INFO: renamed from: a */
    private XMPushService f1014a;

    public aw(XMPushService xMPushService, er erVar) {
        super(4);
        this.f1014a = null;
        this.f1014a = xMPushService;
        this.a = erVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo377a() {
        try {
            if (this.a != null) {
                if (e.a(this.a)) {
                    this.a.c(System.currentTimeMillis() - this.a.m387a());
                }
                this.f1014a.a(this.a);
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f1014a.a(10, e2);
        }
    }
}
