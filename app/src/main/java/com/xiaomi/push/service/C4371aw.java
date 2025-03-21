package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4197er;
import com.xiaomi.push.C4215fi;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.aw */
/* loaded from: classes2.dex */
public class C4371aw extends XMPushService.AbstractC4337j {

    /* renamed from: a */
    private C4197er f16651a;

    /* renamed from: a */
    private XMPushService f16652a;

    public C4371aw(XMPushService xMPushService, C4197er c4197er) {
        super(4);
        this.f16652a = null;
        this.f16652a = xMPushService;
        this.f16651a = c4197er;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public String mo14643a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC4337j
    /* renamed from: a */
    public void mo14644a() {
        try {
            if (this.f16651a != null) {
                if (AbstractC4382e.m16077a(this.f16651a)) {
                    this.f16651a.m14707c(System.currentTimeMillis() - this.f16651a.m14684a());
                }
                this.f16652a.m15796a(this.f16651a);
            }
        } catch (C4215fi e2) {
            AbstractC4022b.m13351a(e2);
            this.f16652a.m15795a(10, e2);
        }
    }
}
