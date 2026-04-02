package com.xiaomi.push.service;

import com.xiaomi.push.er;
import com.xiaomi.push.fi;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes2.dex */
class c extends XMPushService.j {
    private XMPushService a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private er[] f1038a;

    public c(XMPushService xMPushService, er[] erVarArr) {
        super(4);
        this.a = null;
        this.a = xMPushService;
        this.f1038a = erVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* JADX INFO: renamed from: a */
    public void mo377a() {
        try {
            if (this.f1038a != null) {
                this.a.a(this.f1038a);
            }
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.a.a(10, e2);
        }
    }
}
