package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.c */
/* loaded from: classes2.dex */
class C4380c extends XMPushService.AbstractC4337j {

    /* renamed from: a */
    private XMPushService f16695a;

    /* renamed from: a */
    private C4197er[] f16696a;

    public C4380c(XMPushService xMPushService, C4197er[] c4197erArr) {
        super(4);
        this.f16695a = null;
        this.f16695a = xMPushService;
        this.f16696a = c4197erArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public String mo14643a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public void mo14644a() {
        try {
            if (this.f16696a != null) {
                this.f16695a.m15805a(this.f16696a);
            }
        } catch (C4215fi e2) {
            AbstractC4022b.m13351a(e2);
            this.f16695a.m15795a(10, e2);
        }
    }
}
